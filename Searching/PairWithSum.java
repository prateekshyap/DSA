/*https://leetcode.com/problems/two-sum/*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; ++i)
        {
            if (map.containsKey(target-nums[i]))
            {
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                Arrays.sort(result);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}