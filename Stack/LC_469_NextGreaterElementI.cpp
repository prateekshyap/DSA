/*
https://leetcode.com/problems/next-greater-element-i/
496. Next Greater Element I

*/

/***************** GFG ************************/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to find the next greater element for each element of the array.
    vector<long long> nextLargerElement(vector<long long> arr, int n){
        // Your code here
        
        vector<long long> ans(n,0);
        stack<long long> st;
        
        st.push(-1);
        
        for(int i =n-1; i >=0; i--)
        {
            while( (st.top() != -1) && (st.top() <= arr[i]) )
                st.pop();
            
            ans[i] = st.top();
            
            st.push(arr[i]);
        }
        
        return ans;
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
        vector<long long> arr(n);
        for(int i=0;i<n;i++)
            cin>>arr[i];
        
        Solution obj;
        vector <long long> res = obj.nextLargerElement(arr, n);
        for (long long i : res) cout << i << " ";
        cout<<endl;
    }
	return 0;
}  // } Driver Code Ends

/***************** LC ************************/
	 
class Solution {
public:
    
     vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        vector<int> ans;
        stack<int> st;
        unordered_map<int,int> umap;
        
         st.push(-1);
         
        for(int i = nums2.size()-1; i>=0; i--) // from last element to first
        {
         
            while(st.top() != -1 && st.top() <= nums2[i])
                st.pop();
            
            umap[nums2[i]] = st.top();
            
            st.push(nums2[i]);
        }
        
        for(int i: nums1)
            ans.push_back(umap[i]);
        
        return ans;
    }//end

//     vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        
//         vector<int> ans;
//         stack<int> st;
//         unordered_map<int,int> umap;
        
//         for(int i = nums2.size()-1; i>=0; i--) // from last element to first
//         {
//             if(st.empty()) umap[nums2[i]] = -1; // if stack is empty, that is no greater element exist till now
//             // if stack is not empty
//             else if(st.top() > nums2[i]) // if stack top is greater than current element, that is we have next greater element of curr element
//                 umap[nums2[i]] = st.top();
//             else if(st.top() <= nums2[i])
//             {
//                 while(!st.empty() && st.top() <= nums2[i])
//                     st.pop();
//                 if(st.empty()) umap[nums2[i]] = -1;
//                 else umap[nums2[i]] = st.top();
//             }
            
//             st.push(nums2[i]);
//         }
        
//         for(int i: nums1)
//             ans.push_back(umap[i]);
        
//         return ans;
//     }//end
    
    
//     vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        
        
//         vector<int> ans;
        
//          bool flageq = false, flagpush = false;
        
//         for(int i=0; i < nums1.size(); i++)
//         {
//             flageq = false;
//             flagpush = false;
            
//           for(int j=0; j<nums2.size(); j++)
//           {
//               if(flageq)
//               {
//                 if(nums1[i] < nums2[j])
//                 {    
//                     ans.push_back(nums2[j]);
//                     flagpush=true;
//                     break;
//                 }
//               }
//               if(nums1[i] == nums2[j])
//               {
//                   flageq = true;
//               }
             
//           } //for j
//             if(!flagpush) ans.push_back(-1); // for last case
            
//         }// for i
        
//         return ans;
//     }//end
};