/*https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = 0;
        boolean flag = true; //helps to store elements at most twice
        for (int i = 1; i < nums.length; ++i)
        {
        	//till ith element is equal to current element
            while(i < nums.length && nums[i] == nums[curr])
            {
            	//if flag is true
                if (flag)
                {
                	//increase current index
                    ++curr;

                    //store ith element to current index
                    nums[curr] = nums[i];

                    //reverse flag to indicate that we have visited current element once
                    flag = false;
                }

                //if flag is false then this case resembles to the normal case
                ++i;
            }
            if (i < nums.length)
            {
            	//store the next element to the right position
                nums[curr+1] = nums[i];

                //increase current index
                ++curr;

                //reset flag
                flag = true;
            }
        }
        return curr+1;
    }
}