/*
https://leetcode.com/problems/subarray-product-less-than-k/
713. Subarray Product Less Than K

https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1#
*/

class Solution {
public:
    int numSubarrayProductLessThanK_(vector<int>& nums, int k) {
        if(k<=1) return 0;
        int count=0;
        double logK = log(k);
        int n = nums.size();
        
        vector<double> prefix(n+1, 0.0);
        for(int i=0; i<n; i++)
        {
            prefix[i+1] = prefix[i] + log(nums[i]);
            // cout<<prefix[i]<<" ";
        }
         // cout<<prefix[n]<<" "<<endl;
        for(int j=0; j<n; j++)
        {
           
            /*
            int c;
            int lo = j+1;
            int hi = prefix.size();
            
            while(lo < hi)
            {
                int mi = lo + (hi-lo)/2;
                if(prefix[mi] < prefix[j] + logK)
                    lo = mi+1;
                else
                    hi = mi;
            }
            c = lo;
            */
            
            int c = lower_bound(prefix.begin()+j+1, prefix.end(), prefix[j]+logK) - prefix.begin();
            // cout<<prefix[j]+logK<<" "<<c<<" "<<j<<") ";
            count += (c - j -1);
        }
        
        
        return count;
        
    }
    
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        if(k<=1) return 0;
        int count=0;
        int i=0, j=0;
        unsigned long long prod =1;
        int n = nums.size();
        
        while(j<n)
        {
            prod *= nums[j];
            
            while(prod >= k)
                prod = prod / nums[i++];
            
            // if(prod < k)
                count += (j-i+1);
            j++;
        }
        
        
        return count;
    }
};



// GFG------------------------------------------
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;



 // } Driver Code Ends


class Solution{
  public:

    int countSubArrayProductLessThanK(const vector<int>& a, int n, long long k) {
        
        int count=0;
        int i=0, j=0;
        unsigned long long prod =1;
        
        while(j<n)
        {
            prod *= a[j];
            
            while(prod >= k)
                prod = prod / a[i++];
            
            // if(prod < k)
                count += (j-i+1);
            j++;
        }
        
        
        return count;
    }
    
    
    int countSubArrayProductLessThanK_TLEat90thCase(const vector<int>& a, int n, long long k) {
        
        int ans=0;
        
        for(int i=0; i<n; i++)
        {
            int prod = a[i];
            if(prod < k)
                ans++;
                
            for(int j = i+1; j<n; j++)
            {
                prod *= a[j];
                if(prod < k)
                    ans++;
                else
                    break;
            }
        }
        
        
        return ans;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        long long int k;
        cin >> n >> k;
        vector<int> arr(n);
        for (i = 0; i < n; i++) cin >> arr[i];
        Solution obj;
        cout << obj.countSubArrayProductLessThanK(arr, n, k) << endl;
    }
    return 0;
}
  // } Driver Code Ends