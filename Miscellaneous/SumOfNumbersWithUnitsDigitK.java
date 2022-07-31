/*https://leetcode.com/problems/sum-of-numbers-with-units-digit-k/*/

class Solution {
    Integer[] dp;
    int minSize;
    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        minSize = Integer.MAX_VALUE;
        int count = 0, i;
        dp = new Integer[3001];
        int curr = k == 0 ? 10 : k, res;
        while (curr <= num)
        {
            res = recur(num,curr,curr,1,k);
            if (res != -1) ++count;
            curr += 10;
        }
        return minSize == Integer.MAX_VALUE ? -1 : minSize;
    }
    public int recur(int num, int curr, int currStart, int currCount, int k)
    {
        if (curr == num)
        {
            dp[num] = currCount;
            minSize = Math.min(minSize,currCount);
            return currCount;
        }
        if (curr > num) return -1;
        if (dp[curr] != null) return dp[curr];
        int next = currStart;
        int count = 0;
        while (next <= num)
        {
            int res = recur(num,curr+next,currStart,currCount+1,k);
            if (res != -1) ++count;
            next += 10;
        }
        dp[curr] = currCount+1;
        return dp[curr];
    }
}

class Solution {
    public int minimumNumbers(int num, int k) {
        
        if (num == 0) return 0;
        else if (num == k) return 1;
        
        int val;
        
        for (int i = 1; i <= 10; ++i){
            val = i * k;
            
            if (val % 10 == num % 10 && val <= num)
                return i;
        }
        
        return -1;
    }
}