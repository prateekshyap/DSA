/*https://practice.geeksforgeeks.org/problems/four-elements2452/1*/

class Compute
{
    boolean find4Numbers(int nums[], int n, int target) 
    {
        if (nums.length < 4) return false;
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
                if (twoSumTarget < minTwoSum || twoSumTarget > maxTwoSum) continue;
                
                //set two pointers after the fixed pointers
                int start = j+1;
                int end = nums.length-1;
                while (start < end)
                {
                    //get the sum
                    int sum = nums[i]+nums[j]+nums[start]+nums[end];

                    //if sum is equal to target
                    if (sum == target) return true;

                    //if sum is positive, move left
                    else if (sum > target) --end;

                    //else move right
                    else ++start;
                }
            }
        }
        return false;
    }
}