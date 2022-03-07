/*
https://practice.geeksforgeeks.org/problems/counting-sort/1
Counting Sort

*/
// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;
#define RANGE 255


 // } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    string countSort(string arr){
        // code here
        int k =26;
        int C[k] = {0};
        
        int n = arr.length(), ind =-1;
        string ans(n,'x');
        
        for(int i=0; i<n; i++)
        {
             ind = arr[i]-97;
            C[ind] = C[ind]+1; // number of elements equal to i;
        }
        
        for(int i=1; i<k; i++)
        {
            C[i] = C[i] + C[i-1]; // number of elements less than or equal to i
        }
        
        for(int j=n-1; j>=0; j--)
        {
            ind = arr[j]-97;
            ans[C[ind]-1] = arr[j];
            C[ind] = C[ind]-1;
        }
        return ans;
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
        string arr;
        cin>>arr;
        Solution obj;
        cout<<obj.countSort(arr)<<endl;
    }
    return 0;
}
  // } Driver Code Ends