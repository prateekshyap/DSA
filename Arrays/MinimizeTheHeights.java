/*https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1/*/

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        if (n == 1) return 0;
        
        Arrays.sort(arr);
        
        int min = arr[0], max = arr[n-1], i, diff = max-min;
        
        for (i = 1; i < n; ++i)
        {
            if (arr[i]-k < 0) continue;
            min = Math.min(arr[0]+k,arr[i]-k);
            max = Math.max(arr[i-1]+k,arr[n-1]-k);
            diff = Math.min(diff,max-min);
        }
        
        return diff;
    }
}