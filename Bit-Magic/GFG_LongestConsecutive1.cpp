/*
https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1
Longest Consecutive 1's 
https://binarysearch.com/problems/Longest-Consecutive-Run-of-1s-in-Binary
*/
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

/*  Function to calculate the longest consecutive ones
*   N: given input to calculate the longest consecutive ones
*/
class Solution
{
    public:
    int maxConsecutiveOnes(int N)
    {
        // code here
        int len = 0, max_len=0;
        
        while(N>0)
        {
            if(N&1 == 1)
                len++;
            else
            {    
                if(max_len < len)
                    max_len = len;
                len=0;
            }
            
            N>>=1;
        }
         if(max_len < len)
                max_len = len;
        return max_len;
    }
};


// { Driver Code Starts.

// Driver Code
int main() {
	int t;
	cin>>t;//testcases
	while(t--)
	{
		int n;
		cin>>n;//input n
		Solution obj;
		//calling maxConsecutiveOnes() function
		cout<<obj.maxConsecutiveOnes(n)<<endl;
	}
	return 0;
}  // } Driver Code Ends