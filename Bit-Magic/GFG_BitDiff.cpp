/*
https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1
Bit Difference 
*/
// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution{
     public:
    // Function to find number of bits needed to be flipped to convert A to B
    int countBitsFlip(int a, int b){
        
       int N = a xor b;
       int len=0;
       while(N>0)
       {
        //  if(N&1 == 1 )
        //       len++;
        //  N>>=1; //left shift by 1 bit
         
         N=N&(N-1);
         len++;
       }
       return len;
    }
};

// { Driver Code Starts.

// Driver Code
int main()
{
	int t;
	cin>>t;// input the testcases
	while(t--) //while testcases exist
	{
		int a,b;
		cin>>a>>b; //input a and b

        Solution ob;
		cout<<ob.countBitsFlip(a, b)<<endl;
	}
	return 0;
}  // } Driver Code Ends