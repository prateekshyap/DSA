/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
34. Find First and Last Position of Element in Sorted Array

*/
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        int left=-1;
        int right=-1;
        
        //linear approach
//         for(int i=0; i< nums.size(); i++){
            
//           if(nums[i]!=target) continue;
          
//           if(left==-1)
//               left=i;
              
//             right=i;
              
                
//         }
        
        //binary search approach
        // left = binary_left(nums, target);
        // right = binary_right(nums, target);
        
        // return {left,right};
        
        // cpp stl approach
        int itl = lower_bound(nums.begin(), nums.end(), target) - nums.begin();
        int itr = upper_bound(nums.begin(), nums.end(), target) - nums.begin() -1; //return value greater than target
        
        if( itr<itl) return vector<int> {-1,-1};
        
        return vector<int> {itl,itr};
        
    }//end
    
    int binary_left(vector<int>& nums, int target){
        int n = nums.size();
        int i=0;
        int j=n-1;
        int mid;
        int res=-1;
        while(i<=j){
            mid=i+(j-i)/2;
            if(nums[mid]<target)
                i=mid+1;
            else if(nums[mid]>target)
                j=mid-1;
            else
            {
                res=mid;
                j=mid-1;
            }
        }
        return res;
    }
    
    int binary_right(vector<int>& nums, int target){
        int n = nums.size();
        int i=0;
        int j=n-1;
        int mid;
        int res=-1;
        while(i<=j){
            mid=i+(j-i)/2;
            if(nums[mid]<target)
                i=mid+1;
            else if(nums[mid]>target)
                j=mid-1;
            else
            {
                res=mid;
                i=mid+1;
            }
        }
        return res;
    }
};