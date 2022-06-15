/*
https://practice.geeksforgeeks.org/problems/jump-game/1/#
Jump Game 
*/
// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int canReach(int A[], int N) {
        
        int pos=0;
        
        for(int i=0; i<N; i++)
        {
            if(pos>=i) // if we are at position >= current step
            pos = max(i + A[i], pos); // max jump ke piche agr pauche and udhar se fhir jump kra yaa purana max jump
            
            if(pos>=N-1) // if pos is last index
                return 1;
        }
        
        return 0;
    }// end
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin>>N;
        
        int A[N];
        
        for(int i=0; i<N; i++)
            cin>>A[i];

        Solution ob;
        cout << ob.canReach(A,N) << endl;
    }
    return 0;
}  // } Driver Code Ends