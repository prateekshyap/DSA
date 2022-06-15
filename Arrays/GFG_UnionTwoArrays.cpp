/*
https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1#
Union of two arrays 
*/
// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template in C++

class Solution{
    public:
    //Function to return the count of number of elements in union of two arrays.
    int doUnion(int a[], int n, int b[], int m)  {
    //   int count=0;
       
       set<int> s;
       
    //   int len = min(m,n);
       
       for(int i=0; i<n; i++)
            s.insert(a[i]);
        for(int i=0; i<m; i++)
            s.insert(b[i]);
       
       return s.size();
    }
};

// { Driver Code Starts.

int main() {
	
	int t;
	cin >> t;
	
	while(t--){
	    
	    int n, m;
	    cin >> n >> m;
	    int a[n], b[m];
	   
	    for(int i = 0;i<n;i++)
	       cin >> a[i];
	       
	    for(int i = 0;i<m;i++)
	       cin >> b[i];
	    Solution ob;
	    cout << ob.doUnion(a, n, b, m) << endl;
	    
	}
	
	return 0;
}  // } Driver Code Ends
