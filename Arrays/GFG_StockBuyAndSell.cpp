/*
https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1#
Stock Buy and Sell
*/
// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++

class Solution{
public:
    //Function to find the days of buying and selling stock for max profit.
    vector<vector<int> > stockBuySell(vector<int> A, int n){
       
       vector<vector<int>> ans;
       
       int min_buy = 0;
       int max_pft = 0, diff=0;
       bool flag = false;
       int i=0;
       int j=1;
       
       for(int k=1; k<A.size(); k++)
       {
          if(A[k] > A[k-1])
            ans.push_back({k-1, k});
       }
    //   while(j<A.size())
    //   {
    //       if(A[j] > A[i])
    //       {    
    //           j++;
    //           flag = true;
    //       }
    //       else
    //       {
    //           diff = A[j] - A[i];
    //           if(flag)
    //           {
    //               flag=0;
    //               ans.push_back({i, j-1});
    //           }
    //             i=j;
    //             j++;
    //       }
    //   }
       
    //   if(flag)
    //   {
    //       flag=0;
    //       ans.push_back({i, j-1});
    //   }
       
       
    //   for(auto x: ans)
    //   {
    //       cout<<x[0]<<" "<<x[1]<<endl;
    //   }
       
       return ans;
    }//
};

// { Driver Code Starts.

int check(vector<vector<int>> ans, vector<int> A, int p)
{
    int c = 0;
    for(int i=0; i<ans.size(); i++)
        c += A[ans[i][1]]-A[ans[i][0]];
    return (c==p) ? 1 : 0;
}

int main()
{   
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        vector<int> A(n);
        for (int i=0; i<n; ++i){
            cin>>A[i];
        }
        Solution ob;
        vector<vector<int> > ans = ob.stockBuySell(A, n);
        int p = 0;
        for(int i=0; i<n-1; i++)
        {
            int x = A[i+1]-A[i];
            if(x>0)
                p += x;
        }
        if(ans.size()==0)
            cout<<"No Profit";
        else{
            cout<<check(ans,A,p);
        }cout<<endl;
    }
    return 0;
}

  // } Driver Code Ends