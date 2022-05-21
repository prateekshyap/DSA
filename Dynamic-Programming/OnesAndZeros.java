/*https://leetcode.com/problems/ones-and-zeroes/*/

class Solution {
    HashMap<String,Integer> dp;
    public int findMaxForm(String[] s, int m, int n) {
        dp = new HashMap<String,Integer>();
        return recur(s, 0, m, n);
    }
    
    int recur(String[] s, int i, int m, int n)
    {
        if((m == 0 && n == 0) || i >= s.length) return 0;
        
        String key = m+"#"+n+"#"+i;
        
        if (dp.containsKey(key)) return dp.get(key);

        int M = m;
        int N = n;
       
        String st = s[i];
        for (char ch: st.toCharArray())
        {
            if (ch == '0') M--;
            else N--;
        }

        if (M < 0 || N < 0)
        {
            dp.put(key,recur(s,i+1,m,n));
            return dp.get(key);
        }
        
        dp.put(key,Math.max(recur(s,i+1,m,n),1+recur(s, i+1, M, N)));
        return dp.get(key);
    }
}

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int ones = 0;
        int zeros = 0;
        for (String s : strs)
        {
            ones = countOnes(s);
            zeros = countZeros(s);
            for (int i = m; i >= zeros; --i)
                for(int j = n; j >= ones; --j)
                   dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones]+1);
            
        }
        return dp[m][n];
    }
    public int countOnes(String s)
    {
        int count = 0;
        for (char ch : s.toCharArray())
            if (ch == '1')
                count += 1;
        return count;
    } 
    public int countZeros(String s)
    {
        int count = 0;
        for (char ch : s.toCharArray())
            if (ch == '0')
                count += 1;
        return count;
    } 
}