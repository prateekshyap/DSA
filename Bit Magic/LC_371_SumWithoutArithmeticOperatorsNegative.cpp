/* https://leetcode.com/problems/sum-of-two-integers/
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */
class Solution {
public:
    int getSum(int a, int b) {

        /*
            //Iterative APPROACH of ++ --
            if(b>0){
                while(b!=0){
                    a++;
                    b--;
                }
            }
            else if(b<0){
                while(b!=0){
                    a--;
                    b++;
                }
            }
            return a;

        */
        /*
        //HALF ADDER APPROACH and Bit Manipulation
            int sum, carry;
            while(b!=0){
                sum = a^b;          // sum without carries
                carry = a & b;      //shows each location where carry is needed
                a = sum;
                b = ((unsigned int)carry)<<1;   // shift the carry left one column for adding
            }//while loop

              return a;
       */
        //Power and LOG APPROACH
        if(a == 0)
            return b;
        if(b == 0)
            return a;

        const auto e_a = exp(a);
        const auto e_b = exp(b);
        const auto e_ab = e_a * e_b;
        return static_cast<int>(log(e_ab));



    }//end of getsum
};