/*https://leetcode.com/problems/palindrome-partitioning-ii/*/

class Solution
{
    int[][] dp;
    public boolean isPalindrome(String str, int start, int end)
    {
        while(start<end)
        {
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public int palindromicPartitionSolver(String s, int start, int end)
    {
    	//base case
        if(start >= end) return 0;

        //if already calculated, return
        if(dp[start][end] != -1) return dp[start][end];


        /*If the current string is palindrome then we dont need to break it into 
        further sub problems as we want to minimize the cuts.*/
        
        if(isPalindrome(s, start, end))
        {
            dp[start][end]=0;
            return 0;
        }

        int min = Integer.MAX_VALUE;

        //trying Different possible cuts between i and j
        for (int k = start; k <= end; ++k)
        {
        	//if start to k substring is palindrome, then we shall recur for k+1 to end
            if (isPalindrome(s, start, k))
            {
                int partitions = 1+palindromicPartitionSolver(s, k+1, end);
                min = Math.min(min, partitions);                
            }
        }

        //store answer in table and return
        dp[start][end] = min;
        return dp[start][end];
    }
    public int minCut(String s)
    {
        dp = new int[s.length()][s.length()];

        //fill the table with -1
        for (int i = 0; i < dp.length; ++i)
            for (int j = 0; j < dp[0].length; ++j)
                dp[i][j] = -1;

        return palindromicPartitionSolver(s, 0, s.length()-1);
    }
}

//best solution
class Solution {
    public int minCut(String s) {
        //1D Space expand around middle
        char[] a = s.toCharArray();
        int n = a.length;
        int[] dp = new int[n];
        for(int i = 0;i<n;i++) dp[i] = i;
        
        for(int i = 0;i<n;i++)
        {
            solve(a,dp,i,i);
            solve(a,dp,i,i+1);
        }
        
        return dp[n-1];
    }
    
    public void solve(char[] s,int[] dp, int l, int r)
    {
        int n = s.length;
        while(l >= 0 && r < n && s[l] == s[r])
        {
            if(l == 0)
                dp[r] = 0;
            else
                dp[r] = Math.min(1 + dp[l-1],dp[r]);
            l--;
            r++;
        }
    }
}