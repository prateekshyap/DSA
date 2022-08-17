/*
https://practice.geeksforgeeks.org/problems/common-elements1132/1/#
.Common elements 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:    
       vector <int> commonElements_1 (int A[], int B[], int C[], int n1, int n2, int n3)
        {
            unordered_map<int,int> acnt, bcnt, ccnt;
            for(int i=0; i<n1; i++)
                acnt[A[i]]++;
            for(int i=0; i<n2; i++)
                bcnt[B[i]]++;
            for(int i=0; i<n3; i++)
                ccnt[C[i]]++; 
            
            vector<int> ans;     
            for(int i=0; i<n1; i++)
            {
                if(acnt[A[i]]>0 && bcnt[A[i]]>0 && ccnt[A[i]]>0)
                {
                    ans.push_back(A[i]);
                    acnt[A[i]]=0;
                }
            }
            return ans;
        }//
        
        vector <int> commonElements (int A[], int B[], int C[], int n1, int n2, int n3)
        {
            
            int i=0, j=0, k=0;
            vector<int> ans;     
            while(i<n1 and j<n2 and k<n3)
            {
                if(A[i] == B[j] and B[j] == C[k])
                {
                    ans.push_back(A[i]);
                    i++; j++; k++;
                }
                else if(A[i] < B[j])
                    i++;
                else if(B[j] < C[k])
                    j++;
                else 
                    k++;
                    // cout<<i<<" "<<j<<" "<<k<<endl;
                
                while(i-1>=0 && A[i] == A[i-1])
                    i++;
                while(j-1>=0 and B[j] == B[j-1])
                    j++;
                while(k-1>=0 and C[k] == C[k-1])
                    k++;
            }//while
            return ans;
            
        }//

};

// { Driver Code Starts.

int main ()
{
    int t; cin >> t;
    while (t--)
    {
        int n1, n2, n3; 
        cin >> n1 >> n2 >> n3;
        int A[n1];
        int B[n2];
        int C[n3];
        
        for (int i = 0; i < n1; i++) cin >> A[i];
        for (int i = 0; i < n2; i++) cin >> B[i];
        for (int i = 0; i < n3; i++) cin >> C[i];
        
        Solution ob;
        
        vector <int> res = ob.commonElements (A, B, C, n1, n2, n3);
        if (res.size () == 0) 
            cout << -1;
        for (int i = 0; i < res.size (); i++) 
            cout << res[i] << " "; 
        cout << endl;
    }
}  // } Driver Code Ends