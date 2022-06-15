/*https://leetcode.com/problems/sum-of-all-odd-length-subarrays/*/

//prefix sum with sliding window
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0, i, j, n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (i = 1; i < n; ++i) prefix[i] = prefix[i-1]+arr[i];
        for (i = 0; i < n; ++i)
        {
            for (j = i-1; j >= 0; j-=2)
                sum += prefix[i]-prefix[j];
            if (j == -1) sum += prefix[i];
        }
        return sum;
    }
}

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
       	int res = 0, n = arr.length;
        for (int i = 0; i < n; ++i)
            res += ((i+1)*(n-i)+1)/2*arr[i];
        return res;
    }
}