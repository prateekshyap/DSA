/*
https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1#
Find Pair Given Difference 
*/

// { Driver Code Starts
#include<bits/stdc++.h>
 
using namespace std; 


bool findPair(int arr[], int size, int n);

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int l,n;
        cin>>l>>n;
        int arr[l];
        for(int i=0;i<l;i++)
            cin>>arr[i];
        if(findPair(arr, l, n))
            cout<<1<<endl;
        else cout<<"-1"<<endl;
    }
    
  
    return 0;
}// } Driver Code Ends


bool findPair(int arr[], int size, int n){
    
    unordered_map<int,int> um;
    
    for(int i=0; i<size; i++)
    {
        if(um.find(arr[i]+n) != um.end()) return true;
        if(um.find(arr[i]-n) != um.end()) return true;
        um.insert({arr[i], i});
    }
    
    return false;
    
} 

bool findPair_(int arr[], int size, int n){
    
    sort(arr, arr+size);
    
    int i=0, j=1, diff=0; //there is monotonicity that we are moving in only one direction in order to determine the answer.
    
    while(i<size && j<size)
    {
        if(i==j) j++;
        
        diff = arr[j]-arr[i];
        
        if(diff == n) return true;
        else if(diff > n) i++; //decrease the diff
        else
            j++;
    }
    
    return false;
    
}