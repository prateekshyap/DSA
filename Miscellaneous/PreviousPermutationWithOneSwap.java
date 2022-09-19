/*https://leetcode.com/problems/previous-permutation-with-one-swap/*/

class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int maxTillNow = arr.length, swapIndex = -1, index = arr.length-2;
        while (index >= 0)
        {
            if (arr[index] > arr[index+1]) //do not break till the sequence is decreasing backwards
            {
                swapIndex = index; //find the break point
                break;
            }
            --index;
        }
        if (swapIndex == -1) return arr; //if no such index could be found, return the original array
        for (index = arr.length-1; index > swapIndex; --index) //from the last index till the break point
            if ((maxTillNow == arr.length || arr[index] >= arr[maxTillNow]) && arr[index] < arr[swapIndex]) //find the largest value that is smaller than the break point
                maxTillNow = index;

        //swap both the values
        int temp = arr[maxTillNow];
        arr[maxTillNow] = arr[swapIndex];
        arr[swapIndex] = temp;
        
        return arr;
    }
}