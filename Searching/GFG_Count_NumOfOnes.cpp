/*
https://practice.geeksforgeeks.org/problems/count-the-zeros2550/1
*/
/* Return counts of 1's in arr[low..high].  The array is
   assumed to be sorted in non-increasing order */

#include <bits/stdc++.h>

using namespace std;



int binary_left_right_bound(vector<int> &nums, int target)
{
    int n = nums.size();
    int i=0, j = n-1, mid=-1;
    while(i<=j){
        mid = i + (j-i)/2;
        if(target>nums[mid]) j =mid-1;
        else if (target<nums[mid]) i=mid+1;
        else{
            if(mid == n-1 || nums[mid+1] != target)
                return mid+1; // as it is sorted return mid +1 (index from 0)
            else
                i=mid+1; // find rightmost target index

        }
    }
}
int countOnesInArray(vector<int> &nums, int target){

    /**** Approach 1 USING Binary Search *****/
    return binary_left_right_bound(nums, target);
}

int main()
{
    vector<int> arr = { 1, 1, 0, 0, 0, 0,0};
    cout << "Count of 1's in given array is "
         << countOnesInArray(arr, 1);
    return 0;
}