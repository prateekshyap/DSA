/*
https://practice.geeksforgeeks.org/problems/reverse-bits-1611130171/1/
Reverse Bits 
https://leetcode.com/problems/reverse-bits/
190. Reverse Bits

*/
//LC
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        
        uint32_t ans;
        
        for(int i=0; i<32; i++)
        {
            ans<<=1;
            ans |= (n&1);
            n>>=1;
        }
        
        return ans;
    }//end
};

// GFG
#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
//User function Template for C++

class Solution
{
    public:
    unsigned int reverseBits(unsigned int n)
    {
       unsigned int a=0;
       
       while(n>0)
       {
        //   unsigned int bit = n&1;
           a<<=1;
           a|=(n&1);
           n>>=1;
       }
       
       return a;
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin >> N;
        
        Solution ob;
        cout<< ob.reverseBits(N) <<"\n";
        
    }
    return 0;
}
  // } Driver Code Ends