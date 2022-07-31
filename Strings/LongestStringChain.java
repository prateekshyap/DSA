/*https://leetcode.com/problems/longest-string-chain/*/

class Solution {
    Integer[] dp;
    HashMap<String,Integer> map;
    public int longestStrChain(String[] words) {
        map = new HashMap<String,Integer>();
        int i, n = words.length, len = 0, size = 0;
        dp = new Integer[n];
        for (i = 0; i < n; ++i)
            map.put(words[i],i);
        for (String word : words)
            solve(new StringBuilder(word));
        int max = 1;
        for (Integer val : dp)
            if (val != null && val > max)
                max = val;
        return max;
    }
    private int solve(StringBuilder word)
    {
        int index = map.get(word.toString());
        if (dp[index] != null) return dp[index];
        if (word.length() == 1) return dp[index] = 1;
        boolean flag = true;
        StringBuilder temp;
        dp[index] = 1;
        for (int i = 0; i < word.length(); ++i)
        {
            temp = new StringBuilder(word);
            temp.deleteCharAt(i);
            if (map.containsKey(temp.toString()))
                dp[index] = Math.max(dp[index],solve(temp)+1);
        }
        return dp[index];
    }
}

