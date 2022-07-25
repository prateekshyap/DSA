/*https://leetcode.com/problems/number-of-excellent-pairs/submissions/*/

class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        int[] bitCounts = new int[100];
        int max = 0;
        int val;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num : nums)
            set.add(num);
        
        for (int num : set) //for each number
        {
            val = Integer.bitCount(num); //get the bit count
            bitCounts[val]++; //store in hash
            max = Math.max(max, val); //get the maximum
        }
        
        long result = 0;
        
        // for (int num : set) //for each number
        // {
        //     val = Integer.bitCount(num); //get the bit count
        //     for (int i = Math.max(0,k-val); i <= max; ++i)
        //         result += bitCounts[i]; //add all the relevant counterparts            
        // }
        for (int i = 1; i < 100; ++i)
            bitCounts[i] += bitCounts[i-1];
        for (int num : set)
        {
            val = Integer.bitCount(num);
            result += bitCounts[99]-(k-val < 1 ? bitCounts[0] : bitCounts[k-val-1]);
        }
        
        return result;
    }
}