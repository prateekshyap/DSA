/*https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1/*/

class Solution {
    public static void convertToWave(int n, int[] arr) {
        // code here
        int i, temp;
        for (i = 1; i < n; ++i)
        {
            if (i%2 == 0 && arr[i] < arr[i-1])
            {
                temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
            else if (i%2 == 1 && arr[i] > arr[i-1])
            {
                temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
        }
    }
}