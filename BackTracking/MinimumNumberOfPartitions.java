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

class Solution {
    int minCuts;
    Integer[] ccm;
    public int minCut(String s) {
        minCuts = Integer.MAX_VALUE;
        if (s.length() == 0) return 1;
        ccm = new Integer[s.length()+1];
        recur(s,0,s.length(),0);
        return minCuts-1;
    }
    public int recur(String s, int index, int n, int cutsCount)
    {
        if (index == n)
        {
            if (cutsCount < minCuts) minCuts = cutsCount;
            ccm[index] = 0;
            return 0;
        }
        int result = Integer.MAX_VALUE;
        if (ccm[index] != null) return ccm[index];
        for (int i = index; i < n; ++i)
        {
            if (isPalindrome(s.substring(index,i+1)))
                result = Math.min(result,recur(s, i+1, n, cutsCount+1)+1);
        }
        ccm[index] = result;
        if (cutsCount+ccm[index] < minCuts) minCuts = cutsCount+ccm[index];
        return ccm[index];
    }
    public boolean isPalindrome(String s)
    {
        int i = 0, j = s.length()-1;
        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
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

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] t = s.toCharArray();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        int i = 0;
        while (i < n) {
            expandAround(t, i, i, dp);
            expandAround(t, i, i + 1, dp);
            i++;
        }
        return dp[n];
    }

    private void expandAround(char[] t, int i, int j, int[] dp) {
        while (i >= 0 && j < t.length && t[i] == t[j]) {
            dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
            i--;
            j++;
        }
    }
}