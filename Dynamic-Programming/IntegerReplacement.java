/*https://leetcode.com/problems/integer-replacement/*/

/*Simple DP*/
class Solution {
    HashMap<Integer,Integer> dp;
    public int integerReplacement(int n) {
        dp = new HashMap<Integer,Integer>();
        dp.put(0,0);
        dp.put(1,0);
        recur(n);
        //for (int i = 0; i <= n; ++i) System.out.println(dp[i]);
        return dp.get(n);
    }
    
    public int recur(int n)
    {
        if (dp.containsKey(n)) return dp.get(n);
        
        if (n == 1) return dp.get(1);
        
        if (n%2 == 0) dp.put(n,recur(n/2)+1);
        else dp.put(n,Math.min(recur(n+1),recur(n-1))+1);
        
        return dp.get(n);
    }
}

/*Efficient solution*/
class Solution {
    public int integerReplacement(int n) {
        long val = (long)n;
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        while(val != 1)
        {
            if(val % 2 == 0)
            {
                val = val/2;
                count++;
            }
            else
            {
                if (val == 3) return count + 2;
                else if (((val + 1)/2) % 2 == 0) val++;
                else val--;
                count++;
            }           
        }
        return count;
    }
}