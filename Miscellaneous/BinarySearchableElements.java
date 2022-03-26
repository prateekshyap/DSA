/*illogical question*/
/*https://practice.geeksforgeeks.org/problems/binary-searchable-elements/1*/

class Solution {
    static int binarySearchable(int[] arr, int n) {
        // code here
        int[] left = new int[n];
        int[] right = new int[n];
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; ++i)
        {
            left[i] = max;
            max = Math.max(max, arr[i]);
        }
        
        for (int i = n-1; i >= 0; --i)
        {
            right[i] = min;
            min = Math.min(min, arr[i]);
        }
        
        int count = 0;
        
        for (int i = 0; i < n; ++i)
            if (left[i] < arr[i] && right[i] > arr[i])
                ++count;
        return count;
    }
}