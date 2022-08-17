/*
https://leetcode.com/problems/sliding-window-maximum/
239. Sliding Window Maximum

https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1#
Maximum of all subarrays of size k 

https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/#
*/

// LC ------------------------------------------------------------------

class Solution {
public:
    vector<int> maxSlidingWindow_(vector<int>& nums, int k) {
        vector<int> ans;
        multiset<int> ms;
        int i=0, j=0;
        
        while(j<k)
            ms.insert(nums[j++]);
        ans.push_back(*ms.rbegin());
        while(j<nums.size())
        {
            ms.erase(ms.find(nums[i]));
            ms.insert(nums[j]);
            ans.push_back(*ms.rbegin());
            i++; j++;
        }
        
        return ans;
    }//end
    
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        list<int> dq;
        int i=0, j=0;
        
        
        while(j<nums.size())
        {
           while(!dq.empty() && nums[j] > nums[dq.back()])
               dq.pop_back();
           
           dq.push_back(j);
            
           if(j-i+1 < k){
               j++;
               continue;
           }
            ans.push_back(nums[dq.front()]);
            if(i == dq.front())
                dq.pop_front();
            i++;
            j++;
            
        }
        
        return ans;
    }//end
};

//GFG -----------------------------------------------------------
// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++

class Solution
{
  public:
    //Function to find maximum of each subarray of size k.
    //TLE
    vector <int> max_of_subarrays_TLE(int *arr, int n, int k)
    {
        vector<int> ans;
        int mx = 0;
        
        
        for(int i=0; i<n-k+1; i++)
        {
            mx = arr[i];
            for(int j=i; j<i+k; j++)
                mx = max(mx, arr[j]);
            ans.push_back(mx);
        }
        
        return ans;
    }
    
    //using multiset
    vector <int> max_of_subarrays_(int *arr, int n, int k)
    {
        vector<int> ans;
        multiset<int> ms;
        int i=0, j=0;
        
        while(j<k)
            ms.insert(arr[j++]);
        
        ans.push_back(*ms.rbegin());
        
        while(j<n)
        {
            ms.erase(ms.find(arr[i])) ;//a.erase(a.find()) – Remove only one instance of element from multiset having same value
            ms.insert(arr[j]);
            ans.push_back(*ms.rbegin());
            j++;
            i++;
        }
        
        return ans;
    }
    
    vector <int> max_of_subarrays(int *arr, int n, int k)
    {
        vector<int> ans;
        list<int> dq;
        int i=0, j=0;
        
        while(j<n)
        {
           while(!dq.empty() && arr[j] > dq.back())
                dq.pop_back();
            dq.push_back(arr[j]);
            
            if(j-i+1 < k)
            {
                j++;
                continue;
            }
            
            //j-i+1 == k
            ans.push_back(dq.front());
            if(arr[i] == dq.front())
                dq.pop_front();
            j++;
            i++;
        }
        
        return ans;
    }
};

// { Driver Code Starts.

int main() {
	
	int t;
	cin >> t;
	
	while(t--){
	    
	    int n, k;
	    cin >> n >> k;
	    
	    int arr[n];
	    for(int i = 0;i<n;i++) 
	        cin >> arr[i];
	    Solution ob;
	    vector <int> res = ob.max_of_subarrays(arr, n, k);
	    for (int i = 0; i < res.size (); i++) 
	        cout << res[i] << " ";
	    cout << endl;
	    
	}
	
	return 0;
}  // } Driver Code Ends