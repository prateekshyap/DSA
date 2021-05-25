/*https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/*/

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totSum = 0, currSum = 0;

        //find the total sum
        for (int i = 0; i < arr.length; ++i)
            totSum += arr[i];
        boolean flag = false;

        //if it is divisible by 3
        if (totSum%3 == 0)
        {
            for (int i = 0; i < arr.length; ++i)
            {
            	//get the sum till current point
                currSum += arr[i];

                //if flag is false
                if (!flag)
                {
                	//if first breakpoint reached, make flag true
                    if (currSum*3 == totSum)
                        flag = true;
                }
                else
                {
                	//if second break point reached, return true
                    if (currSum-(totSum/3) == totSum/3 && i != arr.length-1)
                        return true;
                }
            }
        }

        return false;
    }
}