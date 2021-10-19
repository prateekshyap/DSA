/* 
 	https://leetcode.com/problems/rotate-array/
*/

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(k==0) return;            // if k==0, no rotation, return normal
        int n = nums.size();        //length,size of array.
        if(k>n && n>0)              // if k greater than length of array
            k = k % n;
        
        //left rotate         <------               1 2 3 4 5 6 7, k=2  
       // reverse(nums.begin(), nums.begin()+k);    2 1               
       // reverse(nums.begin()+k, nums.end());      2 1 7 6 5 4 3   
       // reverse(nums.begin(), nums.end());        3 4 5 6 7 1 2
        //right rotate          ---->
        reverse(nums.begin(), nums.end());      //  7 6 5 4 3 2 1   
        reverse(nums.begin(), nums.begin()+k);  //  6 7 
        reverse(nums.begin()+k, nums.end());    //  6 7 1 2 3 4 5
    }
    
    /* Custom Function to reverse arr[] from index start to end*/
    void reverseArray(int arr[], int s, int e)
    {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
}
};
