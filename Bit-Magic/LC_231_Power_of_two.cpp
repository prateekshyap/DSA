/* https://leetcode.com/problems/power-of-two/
 * Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.
 */
class Solution {
public:
    bool isPowerOfTwo(int n) {


        /************ using log2 if log2 value is integer or not
                        floor and ceil to check if it integer or not **********/
        // return ((n>0) && ceil(log2(n)) == floor(log2(n)) );

        /************ using All power of two numbers has only a one-bit set  4 ( 100) and 16(10000)
          n>0 bec negative number are also there  **********/
        return ((n>0) && (n & n-1) ==0);
    }
};