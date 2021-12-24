/*https://leetcode.com/problems/3sum-closest/*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        boolean lowExist = false;
        boolean highExist = false;
        if (nums.length == 3)
            return nums[0]+nums[1]+nums[2];
        int low = Integer.MIN_VALUE, high = Integer.MAX_VALUE;
        boolean isExact = false;
        for (int i = 0; i < nums.length-2; ++i)
        {
            //do not consider same elements
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            //set two pointers
            int start = i+1;
            int end = nums.length-1;
            while (start < end)
            {
                //get the sum
                int sum = nums[i]+nums[start]+nums[end];

                //if sum is equal to target then we are done
                if (sum == target)
                    return target;

                //if sum is less
                else if (sum < target)
                {
                    //if sum is closer to target than the previous sum
                    if (sum > low)
                    {
                        //update it
                        low = sum;
                        lowExist = true;
                    }

                    //do not consider same element
                    int currStart = nums[start];
                    ++start;
                    while (start < end && nums[start] == currStart) ++start;
                }

                //if sum is greater
                else if (sum > target)
                {
                    //if sum is closer to target than the previous sum
                    if (sum < high)
                    {
                        //update it
                        high = sum;
                        highExist = true;
                    }

                    //do not consider same element
                    int currEnd = nums[end];
                    --end;
                    while (start < end && nums[end] == currEnd) --end;
                }
            }
        }

        //return appropriate results
        if (lowExist && !highExist)
            return low;
        if (highExist && !lowExist)
            return high;
        return target > 0 ? ((target-low)>=(high-target)?high:low) : ((target-low)>(high-target)?high:low) ;
    }
}