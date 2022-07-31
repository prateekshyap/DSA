/*https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1*/
/*https://leetcode.com/problems/super-egg-drop/*/

class Solution 
{
    static int eggDrop(int n, int k) 
    {
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i < n+1; ++i)
        {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 0; i < k+1; ++i)
            dp[1][i] = i;
        for (int i = 2; i < n+1; ++i)
        {
            for (int j = 2; j < k+1; ++j)
            {
                dp[i][j] = Integer.MAX_VALUE;
                int res = -1;
                for (int p = 1; p <= j; ++p)
                {
                    res = Math.max(dp[i-1][p-1],dp[i][j-p]);
                    dp[i][j] = Math.min(dp[i][j],res);
                }
                dp[i][j] += 1;
            }
        }
        return dp[n][k];
    }
}

class Solution 
{
    static Integer[][] store;
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
    {
        // Your code here
        store = new Integer[n+1][k+1];
        store[n][k] = calculate(n, k);
        return store[n][k];
    }
    static int calculate(int n, int k)
    {
        if (k == 1 || k == 0) return store[n][k] = k;
        
        if (n == 1) return store[n][k] = k;
        
        if (store[n][k] != null) return store[n][k];
        
        int result = 0, min = Integer.MAX_VALUE;
        for (int f = 1; f <= k; ++f)
        {
            result = Math.max(calculate(n-1,f-1),calculate(n,k-f));
            min = Math.min(min,result);
        }
        return store[n][k] = min+1;
    }
}

//dp with binary search
class Solution {
    Integer[][] store;
    public int superEggDrop(int n, int k) {
        store = new Integer[n+1][k+1];
        store[n][k] = calculate(n, k);
        return store[n][k];
    }
    private int calculate(int n, int k)
    {
        if (k == 1 || k == 0) return store[n][k] = k;
        
        if (n == 1) return store[n][k] = k;
        
        if (store[n][k] != null) return store[n][k];
        
        int result = 0, min = Integer.MAX_VALUE, brk, nbrk;
        int low = 1, high = k, mid;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            
            brk = calculate(n-1,mid-1);
            nbrk = calculate(n,k-mid);
            
            result = Math.max(brk,nbrk);
            min = Math.min(result,min);
            
            if (brk >= nbrk) high = mid-1;
            else low = mid+1;
        }
        return store[n][k] = min+1;
    }
}