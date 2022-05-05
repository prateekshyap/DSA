/*
https://leetcode.com/problems/rotate-array/
*/

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        k = nums.length-k;
        for (int i = 0, j = k-1; i < j; ++i, --j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        for (int i = k, j = nums.length-1; i < j; ++i, --j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        for (int i = 0, j = nums.length-1; i < j; ++i, --j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

/*https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1*/

class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        // add your code here
        int temp;
        d %= n;
        for (int i = 0, j = d-1; i < j; ++i, --j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int i = d, j = n-1; i < j; ++i, --j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int i = 0, j = n-1; i < j; ++i, --j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}