/* https://leetcode.com/problems/product-of-array-except-self/
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
 */
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        int right_product=1;
        vector<int> ans(n);

        for(int i=0; i<n; i++){
            right_product*=nums[i];
            ans[i]=right_product;
        }

        int left_product=1;
        for(int i=n-1; i>0; i--){
            ans[i] = ans[i-1]*left_product;
            left_product*=nums[i];
        }

        ans[0] = left_product;

        return ans;

    }
};