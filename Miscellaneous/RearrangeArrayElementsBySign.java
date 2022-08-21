/*https://leetcode.com/problems/rearrange-array-elements-by-sign/*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int p = 0, n = nums.length/2, N = nums.length;
        int[] segregated = new int[N];
        for (int num : nums)
            segregated[num > 0 ? p++ : n++] = num;
        p = 0; n = N/2;
        for (int i = 0; i < N; ++i)
            nums[i] = segregated[i%2 == 0 ? p++ : n++];
        return nums;
    }
}

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int p = 0, n = 1, N = nums.length;
        int[] result = new int[N];
        for (int num : nums)
        {
            if (num > 0)
            {
                result[p] = num;
                p += 2;
            }
            else
            {
                result[n] = num;
                n += 2;
            }
        }
        return result;
    }
}