/*https://practice.geeksforgeeks.org/problems/edit-distance3702/1*/

//recursive approach
class Solution {
    int minOps;
    public int editDistance(String s, String t) {
        if (s.equalsIgnoreCase(t)) return 0;
        minOps = performOps(s,t,s.length(),t.length());
        return minOps;
    }
    public int performOps(String s, String t, int m, int n)
    {
        if (m == 0) return n;
        if (n == 0) return m;
        if (s.charAt(m-1) == t.charAt(n-1))
            return performOps(s,t,m-1,n-1);
        int insert = performOps(s,t,m,n-1)+1; //the new character needs to be compared to the previous character in target string
        int delete = performOps(s,t,m-1,n)+1; //the previous character in input needs to be compared to the current character in target
        int replace = performOps(s,t,m-1,n-1)+1; //previous characters in both the strings need to be compared
        return Math.min(insert,Math.min(replace,delete));
    }
}

//DP
class Solution {
    public int editDistance(String s, String t) {
        int n = t.length();
        int m = s.length();
        
        int[][] dp= new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++)
            dp[i][0] = i;
        
        for(int j = 0; j <= n; j++)
            dp[0][j] = j;
        
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else //minimum among insert, replace and delete
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }
}