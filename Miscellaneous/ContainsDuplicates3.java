/*https://leetcode.com/problems/contains-duplicate-iii/*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] arr, int k, int t) {
        long[] nums = new long[arr.length];
        for (int i = 0; i < nums.length; ++i)
            nums[i] = (long)arr[i];
        TreeMap<Long,Integer> map = new TreeMap<Long,Integer>();
        Long low, high;
        if (k >= nums.length)
        {
            for (int i = 0; i < nums.length; ++i)
            {
                low = map.lowerKey(nums[i]);
                high = map.higherKey(nums[i]);
                if ((low != null && low >= nums[i]-t) || (high != null && high <= nums[i]+t) || map.containsKey(nums[i])) return true;
                map.put(nums[i],1);
            }
            return false;
        }
        for (int i = 0; i <= k; ++i)
        {
            low = map.lowerKey(nums[i]);
            high = map.higherKey(nums[i]);
            if ((low != null && low >= nums[i]-t) || (high != null && high <= nums[i]+t) || map.containsKey(nums[i])) return true;
            map.put(nums[i],1);
        }
        for (int i = k+1; i < nums.length; ++i)
        {
            map.remove(nums[i-k-1]);
            low = map.lowerKey(nums[i]);
            high = map.higherKey(nums[i]);
            if ((low != null && low >= nums[i]-t) || (high != null && high <= nums[i]+t) || map.containsKey(nums[i])) return true;
            map.put(nums[i],1);
        }
        return false;
    }
}