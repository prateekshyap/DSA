/*https://leetcode.com/problems/maximum-number-of-pairs-in-array/*/

class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);
        int pairs = 0, left = 0, val;
        for (Map.Entry elem : map.entrySet())
        {
            val = (Integer)elem.getValue();
            pairs += val/2;
            if (val%2 == 1) ++left;
        }
        return new int[]{pairs,left};
    }
}