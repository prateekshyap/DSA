/*https://leetcode.com/problems/3sum/*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; ++i)
        {
        	//do not consider same elements
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            //set two pointers after the fixed pointer
            int start = i+1;
            int end = nums.length-1;
            while (start < end)
            {
            	//get the sum
                int sum = nums[i]+nums[start]+nums[end];

                //if sum is 0
                if (sum == 0)
                {
                	//add the numbers
                    list.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    
                    //do not consider same elements
                    int currStart = nums[start];
                    int currEnd = nums[end];
                    while (start < end && nums[start] == currStart) ++start;
                    while (start < end && nums[end] == currEnd) --end;
                }

                //if sum is positive, move left
                else if (sum > 0)
                    --end;

                //else move right
                else
                    ++start;
            }
        }
        return list;
    }
}