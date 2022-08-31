/*https://leetcode.com/problems/sort-even-and-odd-indices-independently/*/

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int N = nums.length;
        int T = N%2 == 0 ? N/2 : (N/2)+1;
        int[] temp = new int[T];
        int i = 0, j = 0;
        for (i = 0, j = 0; i < N; i += 2, ++j)
            temp[j] = nums[i];
        while (j < T)
            temp[j++] = Integer.MAX_VALUE;
        Arrays.sort(temp);
        for (i = 0, j = 0; i < N; i += 2, ++j)
            nums[i] = temp[j];
        for (i = 1, j = 0; i < N; i += 2, ++j)
            temp[j] = nums[i];
        while (j < T)
            temp[j++] = Integer.MIN_VALUE;
        Arrays.sort(temp);
        for (i = 1, j = T-1; i < N; i += 2, --j)
            nums[i] = temp[j];
        return nums;
    }
}