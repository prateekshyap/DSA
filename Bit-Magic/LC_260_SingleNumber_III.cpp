/*
 	https://leetcode.com/problems/single-number-iii/
	260. Single Number III
 Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
 You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
*/

class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {

        /******* using xor **************/
        // long long xor_all=0;
        int xor_all=0;

        for(int x: nums)
            xor_all ^= x; //now xor contains only xor of two odd occuring numbers, and duplicates are removed.

        // get the rightmost set bit
        // int right_set_bit = xor_all & (-xor_all);
        int right_set_bit = 1;
        while ((xor_all & right_set_bit) == 0) right_set_bit <<= 1;

        int num1=0, num2=0;
        for(int x: nums){
            if(right_set_bit & x)
                num1 ^= x;
            else
                num2 ^= x;

        }
        return {num1, num2};

        /******* using set **************/
//         set<int> s;

//         for(int x:nums)
//         {
//             if(s.count(x))
//                 s.erase(x);
//             else
//                 s.insert(x);
//         }
//         return vector<int>(s.begin(),s.end());

    }
};