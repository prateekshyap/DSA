/*https://practice.geeksforgeeks.org/problems/k-palindrome/1*/

class GfG
{
    boolean is_k_palin(String s, int k)
    {
	    char[] sa = s.toCharArray();
        int[] dp = new int[sa.length];
        int max = 0;
        for (int i = 0; i < dp.length; i++ ) {
            dp[i] = 1; 
            int maxSoFar = 0;
            for (int j = i - 1; j >= 0; j--) {
                int prev = dp[j]; 
                if (sa[i] == sa[j]) {
                    dp[j] = maxSoFar + 2;
                }
                maxSoFar = Math.max(prev, maxSoFar);
            }
        }
        for (int i : dp) max = Math.max(max, i);
        if (s.length()-max <= k) return true;
        return false;
    }
}
