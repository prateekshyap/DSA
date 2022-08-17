/*
https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1#
Maximum Product Subarray 

https://leetcode.com/problems/maximum-product-subarray/
*/

class Solution {
public:
    int maxProduct_PS(vector<int>& nums) {
       int maxans=INT_MIN;
	   int n = nums.size();
	   int pref=1;
	   int suff=1;
	   
	   for(int i=0; i<n; i++)
	   {
	       pref *= nums[i];
	       suff *= nums[n-1-i];
	       
	       maxans = max({maxans, pref, suff});
	       if(pref == 0) pref =1;
	       if(suff == 0) suff = 1;
	       //cout<<"("<<pref<<","<<suff<<")";
	   }
	   
	   return maxans;
    }
    
    int maxProduct(vector<int>& nums) {
       
	   int n = nums.size();
	   
        int maxans=nums[0];
	   int max_endhere = maxans; // max positive product ending at current position
	   int min_endhere = maxans; // min negative product ending at the current position
	   
	   for(int i=1; i<n; i++)
	   {
           /*
	       int mxend = nums[i]*max_endhere;
	       int mnendh = nums[i]*min_endhere;
	       max_endhere = max({ nums[i], mxend, mnendh});
	       min_endhere = min({ nums[i], mxend, mnendh});
	       maxans = max({maxans, max_endhere, min_endhere});
           */
           if(nums[i]<0)
               swap(max_endhere, min_endhere);
           max_endhere = max( nums[i], nums[i]*max_endhere);
	       min_endhere = min( nums[i], nums[i]*min_endhere);
           maxans = max(maxans, max_endhere);
	       //cout<<"("< <max_endhere<<","<<min_endhere<<")";
	   }
	   
	   return maxans;
	}
};

//GFG-----------------------------------------------------------
// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

 // } Driver Code Ends
//User function template for C++
class Solution{
public:

	// Function to find maximum product subarray
	long long maxProduct_TLE(vector<int> arr, int n) {
	   long long maxans=INT_MIN;
	   
	   for(int i=0; i<n; i++)
	   {
	       long long prod = 1;
	       for(int j=i; j<n; j++)
	       {
	           prod *= arr[j];
	           maxans = max(maxans, prod);
	       }
	   }
	   
	   
	   return maxans;
	}
	
	//using prefix and suffix 
	#define ll long long
	long long maxProduct_PS(vector<int> arr, int n) {
	   
	   ll maxans=INT_MIN;
	   
	   ll pref=1;
	   ll suff=1;
	   
	   for(int i=0; i<n; i++)
	   {
	       pref *= arr[i];
	       suff *= arr[n-1-i];
	       
	       maxans = max({maxans, pref, suff});
	       if(pref == 0) pref =1;
	       if(suff == 0) suff = 1;
	       //cout<<"("<<pref<<","<<suff<<")";
	   }
	   
	   return maxans;
	}
	
	long long maxProduct(vector<int> arr, int n) {
	   
	   ll maxans=arr[0];
	   
	   ll max_endhere = arr[0]; // max positive product ending at current position
	   ll min_endhere = arr[0]; // min negative product ending at the current position
	   
	   for(int i=1; i<n; i++)
	   {
	       ll mxend = arr[i]*max_endhere;
	       ll mnendh = arr[i]*min_endhere;
	       max_endhere = max({ (long long)arr[i], mxend, mnendh});
	       min_endhere = min({ (long long)arr[i], mxend, mnendh});
	       
	       
	       maxans = max({maxans, max_endhere, min_endhere});
	       //cout<<"("<<max_endhere<<","<<min_endhere<<")";
	   }
	   
	   return maxans;
	}
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        vector<int> arr(n);
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.maxProduct(arr, n);
        cout << ans << "\n";
    }
    return 0;
}  // } Driver Code Ends