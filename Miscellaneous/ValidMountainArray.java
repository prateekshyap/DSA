/*https://leetcode.com/problems/valid-mountain-array/*/

class Solution {
    public boolean validMountainArray(int[] arr) {
        // if (arr.length < 3) return false;
        // boolean isIncreasing = true;
        // if (arr[0] >= arr[1]) return false;
        // for (int i = 1; i < arr.length; ++i)
        // {
        //     if (arr[i] == arr[i-1]) return false;
        //     if (arr[i] > arr[i-1])
        //     {
        //         if (!isIncreasing) return false;
        //     }
        //     if (arr[i] < arr[i-1])
        //         isIncreasing = false;
        // }
        // return !isIncreasing;
        int N = arr.length;
        int i = 0;

        // walk up
        while (i+1 < N && arr[i] < arr[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && arr[i] > arr[i+1])
            i++;

        return i == N-1;
    }
}