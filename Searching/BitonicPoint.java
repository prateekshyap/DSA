/*https://practice.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1/*/

class Solution {
    int findMaximum(int[] arr, int n) {
        // code here
        int result = arr[n-1], low = 0, high = n-1, mid;
        while (low <= high)
        {
            mid = low+((high-low)/2);
            if (mid == n-1 || arr[mid] >= arr[mid+1])
            {
                result = arr[mid];
                high = mid-1;
            }
            else low = mid+1;
        }
        return result;
    }
}