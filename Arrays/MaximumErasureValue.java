/*https://leetcode.com/problems/maximum-erasure-value/*/

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int s = 0, e = 0, result = 0, sum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        while (e < nums.length)
        {
            map.put(nums[e],map.getOrDefault(nums[e],0)+1);
            sum += nums[e];
            while (map.get(nums[e]) > 1)
            {
                map.put(nums[s],map.get(nums[s])-1);
                if (map.get(nums[s]) == 0) map.remove(nums[s]);
                sum -= nums[s];
                ++s;
            }
            result = Math.max(result,sum);
            ++e;
        }
        return result;
    }
}