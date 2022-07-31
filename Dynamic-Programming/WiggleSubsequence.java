/*https://leetcode.com/problems/wiggle-subsequence/*/
/*https://practice.geeksforgeeks.org/problems/longest-alternating-subsequence5951/1/*/

/*Prateekshya*/

/*O(n^2) solution*/

/*
0 -> increase
1 -> decrease
2 -> both
*/

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] length = new int[nums.length];
        int[] status = new int[nums.length];
        length[0] = 1;
        status[0] = 2;
        for (int i = 1; i < nums.length; ++i)
        {
            for (int j = i-1; j >= 0; --j)
            {
            	//if number is greater and the previous number was decreasing, it can be added to the subsequence length
                if (nums[i] > nums[j] && (status[j] == 2 || status[j] == 1))
                {
                    status[i] = 0;
                    length[i] = length[j]+1;
                    break;
                }
                //if number is smaller and the previous number was increasing, it can be added to the subsequence length
                else if (nums[i] < nums[j] && (status[j] == 2 || status[j] == 0))
                {
                    status[i] = 1;
                    length[i] = length[j]+1;
                    break;
                }
            }

            //if length is not updated then it will be same as the previous length
            if (length[i] == 0)
            {
                length[i] = length[i-1];
                status[i] = 2; //not necessary
            }
        }

        return length[nums.length-1];
    }
}

/*O(n) solution*/

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int up = 1, down = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;                
        }
        return Math.max(up, down);
    }
}