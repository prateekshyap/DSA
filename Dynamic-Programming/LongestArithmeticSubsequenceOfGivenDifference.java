/*https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/*/

/*Hashing Solution*/
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int i, n = arr.length, currDiff, result = 0;
        int[] dp = new int[n];
        for (i = 0; i < n; ++i)
        {
            if (map.containsKey(arr[i]-difference))
                dp[i] = dp[(Integer)map.get(arr[i]-difference)]+1;
            else dp[i] = 1;
            if (!map.containsKey(arr[i]) || dp[i] > dp[(Integer)map.get(arr[i])])
                map.put(arr[i],i);
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}

/*Efficient Solution*/
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; ++i)
        {
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        
        int k = max-min+1;
        int dp[] = new int[k];
        
        int ans = 1;
        for (int i = 0; i < n; ++i)
        {
            int idx = arr[i]-min;
            if (idx-difference >= 0 && idx-difference < k)
                dp[idx] = 1+dp[idx-difference];
            else
                dp[idx] = 1;
            ans = Math.max(ans,dp[idx]);
        }
        return ans;
    }
}