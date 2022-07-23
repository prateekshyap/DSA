/*https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/*/

class Solution {
    public int minPairSum(int[] nums) {
        int s = 0, e = nums.length-1;
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int sum;
        while (s < e)
        {
            sum = nums[s]+nums[e];
            if (sum > max) max = sum;
            ++s; --e;
        }
        return max;
    }
}

class Solution {
    public int minPairSum(int[] nums) {
        int max = 0;
        for (int n : nums) if (n > max) max = n;
        int[] count = new int[max + 1];
        for (int n : nums) count[n]++;
        int y = 0, i = 1, j = max;
        while (i <= j) {
            while (count[i] <= 0) i++;
            while (count[j] <= 0) j--;
            y = Math.max(y, i + j);
            if (count[i] > count[j]) count[i] -= count[j--];
            else if (count[j] > count[i]) count[j] -= count[i++];
            else {
                i++;
                j--;
            }
        }
        return y;
    }
}