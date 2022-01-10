/* https://leetcode.com/problems/number-of-1-bits/
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 */
class Solution {
public:
    int hammingWeight(uint32_t n) {

        /**************   *****************/
        // unsigned int count=0;
        // while(n)
        // {
        //     count = count + (n & 1);
        //     n >>=1;
        // }
        // return count;

        /**************   *****************/
        return __builtin_popcount(n);
    }// func int hammingWeight
};