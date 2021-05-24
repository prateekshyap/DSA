/*https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/*/

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totSum = 0, currSum = 0;
        for (int i = 0; i < arr.length; ++i)
            totSum += arr[i];
        boolean flag = false;
        if (totSum%3 == 0)
        {
            for (int i = 0; i < arr.length; ++i)
            {
                currSum += arr[i];
                if (!flag)
                {
                    if (currSum*3 == totSum)
                        flag = true;
                }
                else
                {
                    if (currSum-(totSum/3) == totSum/3 && i != arr.length-1)
                        return true;
                }
            }
        }
        return false;
    }
}