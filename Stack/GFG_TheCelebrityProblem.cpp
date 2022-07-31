/*
https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1#
The Celebrity Problem 
*/

// { Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution 
{
    public:
    //Function to find if there is a celebrity in the party or not.
    int celebrity_(vector<vector<int> >& M, int n) 
    {
        vector<int> indeg(n,0);
        vector<int> outdeg(n,0);
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(M[i][j])
                {
                    outdeg[i]++;
                    indeg[j]++;
                }
            }
        }
        
        for(int i=0; i<n; i++)
        {
            if(indeg[i]==n-1 && outdeg[i]==0)
                return i;
        }
        return -1;
    }
    
    int celebrity(vector<vector<int> >& M, int n) 
    {
        
        stack<int> st;
        int a,b, ans;
        for(int i=0; i<n; i++)
            st.push(i);
        
        while(st.size()>1)
        {
            a = st.top(); st.pop();
            b = st.top(); st.pop();
            
            if(M[a][b]) st.push(b); // a to bilkul nhi he 
            else st.push(a); // b nhi ho skta
        }
        ans = st.top();
        int cntzero=0, cntone=0;
        for(int c=0; c<n; c++)
        {
            if(M[ans][c]==0) cntzero++;
            if(M[c][ans]==1) cntone++;
        }
        if(cntone == n-1 and cntzero == n) return ans;
        else return -1;
    }//end
    
};

// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        vector<vector<int> > M( n , vector<int> (n, 0));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cin>>M[i][j];
            }
        }
        Solution ob;
        cout<<ob.celebrity(M,n)<<endl;

    }
}
  // } Driver Code Ends