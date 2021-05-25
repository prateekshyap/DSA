/*https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1*/

class Solution {

    public void merge(int arr1[], int arr2[], int n, int m) {
        //start from last index of 1st array and 1st index of 2nd array
        int i = n-1, j = 0;
        
        //till we reach the other end
        while(i >= 0 && j < m)
        {
            //if 1st array contains greater elements, then swap
            if (arr1[i] > arr2[j])
            {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            else
                //no need to check further
                break; 
            --i; ++j;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}