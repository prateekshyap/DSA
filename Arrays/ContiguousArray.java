/*https://leetcode.com/problems/contiguous-array/*/

class Solution {
    public int findMaxLength(int[] nums) {
        int len = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        //add the base case
        map.put(0,-1);
        for (int i = 0; i < nums.length; ++i)
        {
            //add 1 if 1 else subtract 1
            sum += nums[i] == 0 ? -1 : 1;

            //if sum is already present, update length
            if (map.containsKey(sum) && i-((Integer)map.get(sum)) > len)
                len = i-((Integer)map.get(sum));

            //if sum is not present then add it            
            else if (!map.containsKey(sum))
                map.put(sum,i);
        }
        return len;
    }
}