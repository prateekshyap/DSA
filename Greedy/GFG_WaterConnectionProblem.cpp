/*
https://practice.geeksforgeeks.org/problems/water-connection-problem5822/1#
Water Connection Problem 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{
    public:
    vector<vector<int>> solve(int n,int p,vector<int> a,vector<int> b,vector<int> d)
    {
        vector<vector<int>> ans;
        
        vector<int> incoming(n+1, -1);
        vector<int> outgoing(n+1, -1);
        
        for(int pipe=0; pipe<p; pipe++)
        {
            incoming[b[pipe]] = pipe; // kind of index for a[], b[]
            outgoing[a[pipe]] = pipe;
        }
        
        int mindiam; //minimum diameter
        int endhouse; // end house of house h
        for(int h=1; h<=n; h++)
        {
            if(incoming[h] == -1 && outgoing[h] != -1)// jiska koi incoming nhi he.
            {
                mindiam = INT_MAX;
                endhouse = h;
                
                while(outgoing[endhouse] != -1)
                {
                    mindiam = min(mindiam, d[outgoing[endhouse]]);
                    endhouse = b[outgoing[endhouse]]; // it gives pipe index then b array index
                }
                // if(endhouse != h)// if some house has no connection
                    ans.push_back({h, endhouse, mindiam});
                
            }//incoming
        }//for
        
        
        return ans;
    }
};


// { Driver Code Starts.
int main()
{
	int t,n,p;
	cin>>t;
	while(t--)
    {
        cin>>n>>p;
        vector<int> a(p),b(p),d(p);
        for(int i=0;i<p;i++){
            cin>>a[i]>>b[i]>>d[i];
        }
        Solution obj;
        vector<vector<int>> answer = obj.solve(n,p,a,b,d);
        cout<<answer.size()<<endl;
        for(auto i:answer)
        {
            cout<<i[0]<<" "<<i[1]<<" "<<i[2]<<endl;
        }
        
    }
	return 0;
}  // } Driver Code Ends