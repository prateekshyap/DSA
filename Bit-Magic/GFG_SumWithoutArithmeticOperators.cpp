/* https://practice.geeksforgeeks.org/problems/sum-of-two-numbers-without-using-arithmetic-operators/1/#
 * Given two integers a and b. Find the sum of two numbers without using arithmetic operators.
 */

// { Driver Code Starts
//Initial Template for C++
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution
{
public:
    int sum(int a , int b)
    {
        //iterative approach of ++ -- won't work here
        //using HALF ADDER APPROACH and Bit Manipulation
        int sum, carry;
        while(b!=0){
            sum = a^b;          // sum without carries
            carry = a & b;      //shows each location where carry is needed
            a = sum;
            b = carry<<1;   // shift the carry left one column for adding
        }//while loop
        /*
             * a = 10 = 00001010
             * b = 30 = 00011110
             *
             * a = 00010100 (20)
             * carry = 00001010 (10)
             * b = carry<<1 = 00010100 (20)
             *
             * a = 00000000 (20)
             * carry = 00010100 (20)
             * b = carry<<1 = 00101000 (40)
             *
             * a = 00101000 (40)
             * carry = 00000000 (0)
             * b = carry<<1 = 00000000 (0)
             */

        return a; // return final sum

    }//sum
};

// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int a,b;
        cin >> a>>b;

        Solution ob;
        cout<< ob.sum(a,b) <<"\n";

    }
    return 0;
}
// } Driver Code Ends