/*
https://practice.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1#
Pair with given sum in a sorted array 
*/
// { Driver Code Starts
#include <bits/stdc++.h>


using namespace std;




 // } Driver Code Ends

class Solution{
  public:
    int Countpair(int arr[], int n, int sum){
        
       unordered_map<int,int> um;
        int cnt_pairs=0;
        
        for(int i=0;i<n; i++)
        {
            int diff = sum-arr[i];
            if(um.find(diff) != um.end())
            {
                cnt_pairs+=um[diff];
            }
            
            um[arr[i]]++;
        }
        // for(auto x: um)
        //     cout<<"["<<x.first<<"|"<<x.second<<"], ";
            
        return cnt_pairs?cnt_pairs:-1;
    
        
    }
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
        int arr[n+1];
        
        for(int i=0;i<n;i++)
        cin>>arr[i];

        int sum;
        cin>>sum;
        Solution obj;
        cout << obj.Countpair(arr, n, sum) << endl;
        
    }
	return 0;
}
  // } Driver Code Ends