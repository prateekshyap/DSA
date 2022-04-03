 /*
	https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
	Triplet Sum in Array 
*/

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
    public:
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    bool find3Numbers(int A[], int n, int X)
    {

        sort(A, A+n);
    
        int l=0, r=0, s=0;
        for(int i=0; i<n-2; i++)
        {
            l = i+1;
            r = n-1;
            while(l<r)
            {
                s=A[i] + A[l] + A[r];
                if(s == X)
                    return true;
                else if(s<X)
                    l++;
                else
                    r--;
            }
        }
    
        return false;
    }

};

// { Driver Code Starts.

int main()
{
	int T;
	cin>>T;
	while(T--)
	{
		int n,X;
		cin>>n>>X;
		int i,A[n];
		for(i=0;i<n;i++)
			cin>>A[i];
		Solution ob;
        cout <<  ob.find3Numbers(A, n, X) << endl;
    }
}
  // } Driver Code Ends