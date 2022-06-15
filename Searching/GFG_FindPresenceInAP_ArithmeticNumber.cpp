/*
https://practice.geeksforgeeks.org/problems/arithmetic-number2815/1#
Arithmetic Number 
*/

// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int inSequence(int A, int B, int C){
        if(A==B) return 1;
        if(C==0) return A==B;
        
        double n = (double)(B-A)/C ; //(B-A)/C+1
        return (n>0 && n == (int)n);
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int A, B, C;
        cin>>A>>B>>C;
        
        Solution ob;
        cout<<ob.inSequence(A, B, C)<<endl;
    }
    return 0;
}  // } Driver Code Ends