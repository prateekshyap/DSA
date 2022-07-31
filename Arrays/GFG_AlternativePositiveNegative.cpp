/*
https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1#
Alternate positive and negative numbers 
*/

// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

 // } Driver Code Ends
//User function template for C++
class Solution{
public:

	void rearrange(int arr[], int n) {
	    /*
	    int pi=0;
	    int ni=0;
	    int *pa = new int[n];
	    int *na = new int[n];
	    for(int i=0; i<n; i++)
	    {
	        if(arr[i]>=0)
	            pa[pi++] = arr[i];
	        else
	            na[ni++] = arr[i];
	    }
	    
	    int pit=0;
	    int nit=0;
	    for(int i=0; i<n;)
	    {
	        if(pit<pi)
	            arr[i++] = pa[pit++];
	        if(nit<ni)
	            arr[i++] = na[nit++];
	    }
	   */
	   vector<int> pa;
	   vector<int> na;
	   for(int i=0; i<n; i++)
	   {
	       if(arr[i]>=0)
	            pa.push_back(arr[i]);
	       else
	            na.push_back(arr[i]);
	   }
	   int pi=0, ni=0;
	   int i=0;
	   while(i<n)
	   {
	       if(pi<pa.size())
	        arr[i++] = pa[pi++];
	       if(ni<na.size())
	        arr[i++] = na[ni++];
	   }
	}//
	
	void rightRotate(int *arr, int n, int outofplace, int idx)
	{
	    int temp = arr[idx];
	    for(int i=idx; i>outofplace; i--)
	        arr[i] = arr[i-1];
	    arr[outofplace] = temp;
	}
	
	void rearrange_1(int arr[], int n) {
	    
	    int outofplace = -1;
	    for(int i=0; i<n; i++)
	    {
	        if(outofplace>=0)
	        {
	            if((arr[i]>=0 && arr[outofplace]<0)||(arr[i]<0 && arr[outofplace]>=0))
	            {
	                rightRotate(arr, n, outofplace, i);
	                if(i - outofplace >= 2)
	                    outofplace +=2;
	                else
	                    outofplace = -1;
	            }
	            
	        }
	        
	        if(outofplace == -1)
	        {
	            if((arr[i] >=0 && i%2 != 0)||(arr[i] < 0 && i%2 == 0 )) // positive but not correct index
	                outofplace = i;
	        }
	    }//for
	    
	}
	
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        int arr[n];
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        ob.rearrange(arr, n);
        for (i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}
  // } Driver Code Ends