/*https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/*/

/*DP solution*/

class Solution {
    public int minOperations(int[] nums, int x) {
        int[] prevTable = new int[1];
        int[] currTable = new int[2];
        int minOps = Integer.MAX_VALUE;
        for (int len = nums.length-2; len >= 0; --len)
        {
            currTable = new int[prevTable.length+1];
            int start = 0;
            for (start = 0; start+len < nums.length-1; ++start )
            {
                int end = start+len;
                currTable[start] = prevTable[start]+nums[end+1];
                if (currTable[start] == x)
                    return nums.length-(end-start+1);
            }
            currTable[start] = prevTable[start-1]+nums[start-1];
            if (currTable[start] == x)
                return nums.length-(len+1);
            prevTable = currTable;
        }
        
        for (int i = 0; i < nums.length; ++i)
            if (currTable[i]+nums[i] == x)
                return nums.length;
        return -1;
    }
}

/*Efficient solution using reverse logic*/

class Solution
{
    public int minOperations(int[] nums, int x)
    {
        int totSum = 0;
        for (int i = 0; i < nums.length; ++i)
            totSum += nums[i];
        int rem = totSum-x;
        if (rem == 0) return nums.length;

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0;
        int n = nums.length, len = 0;
        
        map.put(0,-1);
        for (int i = 0; i < n; ++i)
        {
            sum += nums[i];
            map.put(sum,i);
            if (map.containsKey(sum-rem))
                len = Math.max(len,i-(Integer)map.get(sum-rem));
        }
        return len == 0 ? -1 : len == nums.length ? nums.length : n-len;       
    }
}