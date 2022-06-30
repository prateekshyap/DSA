/*https://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1/*/

class Solution
{
    int findMin(int arr[], int n)
    {
        //complete the function here
        int low = 0, high = n-1, mid;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (mid == 0 || arr[mid] < arr[mid-1]) return arr[mid];
            if (arr[mid] < arr[high]) high = mid-1;
            else if (arr[mid] > arr[high]) low= mid+1;
        }
        return -1;
    }
}
