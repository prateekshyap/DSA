/*https://leetcode.com/problems/4sum/*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums.length < 4) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; ++i)
        {
            for (int j = i+1; j < nums.length-2; ++j)
            {
                //do not consider same elements
                if (i > 0 && nums[i] == nums[i-1])
                    continue;
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;
                
                //skip if the target is outside the range of the current window
                int minTwoSum = nums[j+1] + nums[j+2];
                int maxTwoSum = nums[nums.length - 1] + nums[nums.length - 2];
                int twoSumTarget = target - nums[i] - nums[j];
                if(twoSumTarget < minTwoSum || twoSumTarget > maxTwoSum) continue;
                
                //set two pointers after the fixed pointers
                int start = j+1;
                int end = nums.length-1;
                while (start < end)
                {
                    //get the sum
                    int sum = nums[i]+nums[j]+nums[start]+nums[end];

                    //if sum is equal to target
                    if (sum == target)
                    {
                        //add the numbers
                        list.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));

                        //do not consider same elements
                        int currStart = nums[start];
                        int currEnd = nums[end];
                        while (start < end && nums[start] == currStart) ++start;
                        while (start < end && nums[end] == currEnd) --end;
                    }

                    //if sum is positive, move left
                    else if (sum > target)
                        --end;

                    //else move right
                    else
                        ++start;
                }
            }
        }
        return list;
    }
}