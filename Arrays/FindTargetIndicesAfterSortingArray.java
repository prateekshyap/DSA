/*https://leetcode.com/problems/find-target-indices-after-sorting-array/*/

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int[] hash = new int[101];
        int i, j, n = nums.length;
        for (i = 0; i < n; ++i) ++hash[nums[i]];
        int count = 0, size = 0;
        i = 0;
        while (i < target) count += hash[i++];
        
        List<Integer> list = new ArrayList<Integer>();
        size = hash[i];
        for (j = 0; j < hash[i]; ++j)
            list.add(0,count+(--size));
        return list;
        
        // int[] result = new int[hash[i]];
        // size = hash[i];
        // for (i = result.length-1; i >= 0; --i)
        //     result[i] = count+(size--);
        // return result;
    }
}