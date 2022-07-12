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

/*Binary Seacrh*/
import java.util.*;

import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        if (nums.length == 0) return nums;
        int i, j, k;

        i = j = k = 0;

        while (j < nums.length) //till all elements are parsed
        {
            if (nums[i] == nums[j]) ++j; //increase j till the end of the window
            else
            {
                if (j-i >= 2) //if window size is at least 2, keep an element
                    nums[k++] = nums[i];
                nums[k++] = nums[i]; //keep at least one element
                i = j; //close the old window and start a new one
            }
        }

        //last window operation
        if (j-i >= 2)
            nums[k++] = nums[i];
        nums[k++] = nums[i];

        //copy the result
        int[] result = new int[k];
        for (i = 0; i < k; ++i)
            result[i] = nums[i];
        nums = result;

        return nums;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if( nums==null || n==0) return 0;
        
        int currNum=nums[0], count=1, left=1;

        for(int i=1;i<n;i++){
            if(currNum!=nums[i]){
                nums[left++] = nums[i];
                currNum = nums[i];
                count=1;
                continue;
            }
            if(count>=2) continue;

            nums[left++] = nums[i];
            count++;
        }
        return left;
    }
}