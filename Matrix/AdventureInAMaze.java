/*https://practice.geeksforgeeks.org/problems/adventure-in-a-maze2051/1*/

//TLE
class Pair implements Comparable<Pair>
{
    int r, c, adv;
    Pair(int r, int c, int a)
    {
        this.r = r;
        this.c = c;
        this.adv = a;
    }
    
    @Override
    public int compareTo(Pair p)
    {
        return 0;
    }
}
class Solution
{
    public int[] FindWays(int[][] matrix)
    {
        // Code here
        int max = 0, count = 0, R = matrix.length, C = matrix[0].length;
        Pair p;
        //boolean[][] visited = new boolean[R][C];
        
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(0,0,0));
        while (!queue.isEmpty())
        {
            p = queue.poll();
            //visited[p.r][p.c] = true;
            if (p.r >= R || p.c >= C) continue;
            if (p.r == R-1 && p.c == C-1)
            {
                ++count;
                p.adv += matrix[R-1][C-1];
                if (p.adv > max) max = p.adv;
                continue;
            }
            if (matrix[p.r][p.c] == 1)
                queue.add(new Pair(p.r,p.c+1,p.adv+matrix[p.r][p.c]));
            else if (matrix[p.r][p.c] == 2)
                queue.add(new Pair(p.r+1,p.c,p.adv+matrix[p.r][p.c]));
            else
            {
                queue.add(new Pair(p.r,p.c+1,p.adv+matrix[p.r][p.c]));
                queue.add(new Pair(p.r+1,p.c,p.adv+matrix[p.r][p.c]));
            }
        }
        
        return new int[]{count,max};
    }
}

//