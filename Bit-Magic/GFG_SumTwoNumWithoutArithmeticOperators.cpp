/*
https://practice.geeksforgeeks.org/problems/sum-of-two-numbers-without-using-arithmetic-operators/1/#
Sum of two numbers without using arithmetic operators 
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
        // return a+b;
        
        
        // for(int i=1; i<=b; i++)
        //     a++;
        // return a;
        
        
        //USING 
        
        int sum=0;
        int carry = b;
        
        while(carry>0)
        {
            sum = a ^ b; // sum of bits of a and b where atleast one is not set
            carry = a & b; // common set bits of a and b
            
            carry <<=1; // shift carry one bit to add with
            a = sum;
            b = carry;
        }
        return sum;
    }
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