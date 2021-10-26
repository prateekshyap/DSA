/*https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/*/

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int currSum = 0, count = 0;
        for (int i = 0; i < k; ++i)
            currSum += arr[i];
        if (currSum/k >= threshold) ++count;
        for (int i = k; i < arr.length; ++i)
        {
            currSum -= arr[i-k];
            currSum += arr[i];
            if (currSum/k >= threshold) ++count;
        }
        return count;
    }
}