/* https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1#
 * Given a number N and a bit number K, check if Kth bit of N is set or not.
 * A bit is called set if it is 1.
 * Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number.
 */

// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++


class Solution
{
public:
    // Function to check if Kth bit is set or not.
    bool checkKthBit(int n, int k)
    {
        // Your code here
        // It can be a one liner logic!! Think of it!!

        // not k-1 as k value already start from zero
        // return ( n & (1 << k)); // left shift operator
        return ( (n>>k) & 1);
    }
};

// { Driver Code Starts.

// Driver Code
int main()
{
    int t;
    cin>>t;//taking testcases
    while(t--)
    {
        long long n;
        cin>>n;//input n
        int k;
        cin>>k;//bit number k
        Solution obj;
        if(obj.checkKthBit(n, k))
            cout << "Yes" << endl;
        else
            cout << "No" << endl;
    }
    return 0;
}  // } Driver Code Ends