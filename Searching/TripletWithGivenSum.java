/*https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1*/

class Solution
{
    public static boolean find3Numbers(int nums[], int n, int x)
    {
        if (nums.length < 3) return false;
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

                //if sum is x return true
                if (sum == x)
                    return true;

                //if sum is positive, move left
                else if (sum > x)
                    --end;

                //else move right
                else
                    ++start;
            }
        }
        return false;
    }
}