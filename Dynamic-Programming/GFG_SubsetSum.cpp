/*
https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
Subset Sum Problem 
*/
// { Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
//User function template for C++

class Solution{   
public:
    vector<vector<int>> dp;
    
    bool isSubsetSum(vector<int>arr, int sum){
        
        // dp.resize(arr.size()+1, vector<int>(sum+1, -1));    
        // return subsetRec(arr, sum, arr.size());
        
        // vector<vector<bool>> tab(arr.size()+1, vector<bool>(sum+1));
        vector<vector<bool>> tab(arr.size()+1, vector<bool>(sum+1, false));
        
        for(int i=0; i<=arr.size(); i++)
            tab[i][0] = true;
        
        // for(int i=0; i<=sum; i++)
        //     tab[0][i] = false;
        
        for(int i=1; i<=arr.size(); i++)
        {
            for(int j=1; j<=sum; j++)
            {
                if(j < arr[i-1])
                    tab[i][j] = tab[i-1][j];
                else
                    tab[i][j] = tab[i-1][j] || tab[i-1][j-arr[i-1]] ;
            }
        }
        
        return tab[arr.size()][sum];
    }// end
    
    // memoization
    bool subsetRec(vector<int>& arr, int sum, int i)
    {
        // int val = arr[i];
        if (sum == 0) return 1; // if sum become zero then return true as we got our expected sum
        
        if(i <= 0) return 0; // if no item to take and sum not zero
        
        if(dp[i][sum] != -1) return dp[i][sum]; // if already calculated
        
        // if we can't take the item as its value greater than sum
        if(arr[i-1]>sum) return dp[i][sum] = subsetRec(arr, sum, i-1);
        
        return dp[i][sum] = subsetRec(arr, sum, i-1) || subsetRec(arr, sum-arr[i-1], i-1);
        
    }// end
    
};

// { Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N, sum;
        cin >> N;
        vector<int> arr(N);
        for(int i = 0; i < N; i++){
            cin >> arr[i];
        }
        cin >> sum;
        
        Solution ob;
        cout << ob.isSubsetSum(arr, sum) << endl;
    }
    return 0; 
} 
  // } Driver Code Ends