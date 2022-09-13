/*https://leetcode.com/problems/intersection-of-multiple-arrays/*/

class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] hash = new int[1001];
        for (int[] arr : nums)
            for (int val : arr)
                ++hash[val];
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= 1000; ++i)
            if (hash[i] == nums.length)
                result.add(i);
        return result;
    }
}