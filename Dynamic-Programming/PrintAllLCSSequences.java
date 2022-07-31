/*https://practice.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1/*/

class Solution
{
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        int[][] dir = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i)
        {
            for (int j = 1; j <= n; ++j)
            {
            	//if equal, add one to the diagonally previous element
                if (s.charAt(i-1) == t.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                    dir[i][j] = 1; //1 means diagonal
                }
                //otherwise store the maximum among the upper and left element
                else
                {
                    if (dp[i-1][j] > dp[i][j-1])
                    {
                        dp[i][j] = dp[i-1][j];
                        dir[i][j] = 2; //2 means up
                    }
                    else if (dp[i-1][j] < dp[i][j-1])
                    {
                        dp[i][j] = dp[i][j-1];
                        dir[i][j] = 3; //3 means left
                    }
                    else
                    {
                        dp[i][j] = dp[i][j-1];
                        dir[i][j] = 5; //5 means 2+3 i.e both up and left
                    }
                }
            }
        }
        
        List<String> result = new ArrayList<String>();
        class Visit
        {
            Set<String> set;
            Visit()
            {
                set = new HashSet<String>();
            }
        }
        class Data
        {
            StringBuilder subseq;
            int r, c;
            Data(int r, int c)
            {
                this.r = r;
                this.c = c;
                subseq = new StringBuilder("");
            }
            Data(int r, int c, String s)
            {
                this.r = r;
                this.c = c;
                this.subseq = new StringBuilder(s);
            }
            Data(int r, int c, StringBuilder s)
            {
                this.r = r;
                this.c = c;
                this.subseq = new StringBuilder(s);
            }
        }
        Visit[][] visited = new Visit[m+1][n+1];
        Queue<Data> queue = new LinkedList<Data>();
        queue.add(new Data(m,n));
        Set<String> resultSet = new TreeSet<String>();
        Data d, newData;
        while (!queue.isEmpty())
        {
            d = queue.poll();
            if (visited[d.r][d.c] != null && visited[d.r][d.c].set.contains(d.subseq.toString())) continue;
            if (visited[d.r][d.c] == null) visited[d.r][d.c] = new Visit();
            visited[d.r][d.c].set.add(d.subseq.toString());
            if (d.subseq.length() == dp[m][n])
            {
                resultSet.add(d.subseq.toString());
            }
            else if (dir[d.r][d.c] == 1) //if diagonally came
            {
                d.subseq.insert(0,s.charAt(d.r-1));
                newData = new Data(d.r-1,d.c-1,d.subseq);
                queue.add(newData);
            }
            else if (dir[d.r][d.c] == 2) //if up
            {
                newData = new Data(d.r-1,d.c,d.subseq);
                queue.add(newData);
            }
            else if (dir[d.r][d.c] == 3) //if left
            {
                newData = new Data(d.r,d.c-1,d.subseq);
                queue.add(newData);
            }
            else if (dir[d.r][d.c] == 5) //if both up and left
            {
                newData = new Data(d.r-1,d.c,d.subseq);
                queue.add(newData);
                newData = new Data(d.r,d.c-1,d.subseq);
                queue.add(newData);
            }
        }
        
        result = new ArrayList<>(resultSet);
        return result;
    }
}