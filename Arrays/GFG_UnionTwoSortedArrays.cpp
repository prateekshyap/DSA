/*
https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays/1#
Union of Two Sorted Arrays 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
    public:
    //arr1,arr2 : the arrays
    // n, m: size of arrays
    //Function to return a list containing the union of the two arrays. 
    vector<int> findUnion1(int arr1[], int arr2[], int n, int m)
    {
        //Your code here
        //return vector with correct order of elements
        vector<int> ans;
        int i=0, j=0, x=0,y=0;
        while(i<n && j<m)
        {
            x=arr1[i];
            y=arr2[j];
            if(x==y)
            {
              ans.push_back(x);
              while(i<n && arr1[i]==x) i++; // atleast one increament 
              while(j<m && arr2[j]==y) j++;
            }
            else if(x < y)
            {
                ans.push_back(x);
                while(i<n && arr1[i]==x) i++;
            }
            else
            {
                ans.push_back(y);
                while(j<m && arr2[j]==y) j++;
            }
            
        }
        
        while(i<n)
        {
          x = arr1[i];
          ans.push_back(x); 
          while(i<n && arr1[i]==x) i++;
        }
        while(j<m)
        {
          y=arr2[j];
          ans.push_back(arr2[j]); 
           while(j<m && arr2[j]==y) j++;
        }
        return ans;
    }
    vector<int> findUnion(int arr1[], int arr2[], int n, int m)
    {
        //Your code here
        //return vector with correct order of elements
        vector<int> ans;
        int i=0, j=0, x=0,y=0;
        while(i<n && j<m)
        {
            x=arr1[i];
            y=arr2[j];
            if(x<=y)
            {
              if(ans.empty() || ans[ans.size()-1] != x)
               ans.push_back(x);
              i++;
            }
            else
            {
                if(ans.empty() || ans[ans.size()-1] != y)
                ans.push_back(y);
                j++;
            }
            
        }
        
        while(i<n)
        {
          x = arr1[i];
          if(ans.empty() || ans[ans.size()-1] != x)
            ans.push_back(x);
          i++;
        }
        while(j<m)
        {
          y=arr2[j];
          if(ans.empty() || ans[ans.size()-1] != y)
                ans.push_back(y);
          j++;
        }
        return ans;
    }
};

// { Driver Code Starts.

int main() {
	
	int T;
	cin >> T;
	
	while(T--){
	    
	    
	    
	    int N, M;
	    cin >>N >> M;
	    
	    int arr1[N];
	    int arr2[M];
	    
	    for(int i = 0;i<N;i++){
	        cin >> arr1[i];
	    }
	    
	    for(int i = 0;i<M;i++){
	        cin >> arr2[i];
	    }
	    Solution ob;
	    vector<int> ans = ob.findUnion(arr1,arr2, N, M);
	    for(int i: ans)cout<<i<<' ';
	    cout << endl;
	    
	}
	
	return 0;
}  // } Driver Code Ends