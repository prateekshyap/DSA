/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
33. Search in Rotated Sorted Array
*/
class Solution {
public:
    int search(vector<int>& nums, int target) {
       
        int n = nums.size();
        
        if(n == 0) return -1;
        
        // if array is already sorted without rotation
        if(nums[0]<=nums[n-1])
            return binary_search(nums, 0, n-1, target);
        
        int pivot_index = findPivotElementIndex(nums, 0, n-1);
        
        if(nums[pivot_index]==target) 
            return pivot_index; // if pivot index element itself is the target
        // else if (target > nums[pivot_index] && target <=nums[n-1])
        //     return binary_search(nums, pivot_index+1, n-1, target); // search in right array
        // else 
        //     return binary_search(nums,     0,        pivot_index-1, target); // search in left array
        
        int i =0;
        int j = n-1;
        
        if (target > nums[pivot_index] && target <=nums[n-1])
            i = pivot_index+1;
        else{
            j=pivot_index-1;
        }
        
         int mid = -1;
        while(i<=j)
        {
            mid = i + (j-i)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid] < target)
                i=mid+1;
            else 
                j=mid-1;
        }
        return -1;
        
    }// end
    
    int binary_search(vector<int>&nums, int i, int j, int target){
         int mid = -1;
        while(i<=j)
        {
            mid = i + (j-i)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid] < target)
                i=mid+1;
            else 
                j=mid-1;
        }
        return -1;
    }
    
    int findPivotElementIndex(vector<int>& nums, int i, int j){
        
        int  mid = -1;
        
        while(i<j)
        {
            mid = i + (j-i)/2;
            // [4,5,6,7,0,1,2] // first IF find index 4, second IF index 4
            // [0,1,2,4,5,6,7]  // IF index 6, second IF index 0
            // if(nums[0]<=nums[mid]) 
            if(nums[mid] > nums[j]) // finding smallest element in the array index
                i=mid+1;
            else
                j=mid;
            
            // cout<<" i"<<i<<" ,j"<<j<<": ";
        }
        return i;
        
        
    }//end
};