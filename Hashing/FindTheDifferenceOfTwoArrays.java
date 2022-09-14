/*https://leetcode.com/problems/find-the-difference-of-two-arrays/*/

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>(), set2 = new HashSet<Integer>();
        for (int num : nums1)
            set1.add(num);
        for (int num : nums2)
            set2.add(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> nums1Distinct = new ArrayList<Integer>();
        for (Integer num : set1)
            if (!set2.contains(num))
                nums1Distinct.add(num);
        result.add(nums1Distinct);
        List<Integer> nums2Distinct = new ArrayList<Integer>();
        for (Integer num : set2)
            if (!set1.contains(num))
                nums2Distinct.add(num);
        result.add(nums2Distinct);
        return result;
    }
}