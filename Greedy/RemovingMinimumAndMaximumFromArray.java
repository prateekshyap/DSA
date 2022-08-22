/*https://leetcode.com/problems/removing-minimum-and-maximum-from-array/*/

class Solution {
    public int minimumDeletions(int[] nums) {
        int N = nums.length, min = nums[0], max = nums[0], minIndex = 1, maxIndex = 1, i;
        for (i = 0; i < N; ++i)
        {
            if (nums[i] < min)
            {
                min = nums[i];
                minIndex = i+1;
            }
            else if (nums[i] > max)
            {
                max = nums[i];
                maxIndex = i+1;
            }
        }
        // System.out.println(minIndex+" "+maxIndex);
        if (minIndex > maxIndex)
        {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }
        return N == 1 ? 1 : Math.min(minIndex+N-maxIndex+1,Math.min(N-minIndex+1,maxIndex));
    }
}