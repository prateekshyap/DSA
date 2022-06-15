/*
https://practice.geeksforgeeks.org/problems/3d27d4683c121c1f152ee8f41279255dc4430cf6/1/#
Searching an element in a sorted array (Ternary Search) 
*/
// { Driver Code Starts
#include <bits/stdc++.h> 
using namespace std;

 // } Driver Code Ends

class Solution{
    public:
    // Function to find element in sorted array
    // arr: input array
    // N: size of array
    // K: element to be searche
    int ternarySearch(int arr[], int N, int K) 
    { 
       int mid1, mid2;
       int l=0, r = N-1;
       
       while(l<=r)
       {
           mid1 = l+(r-l)/3;
           mid2 = r-(r-l)/3;
           
           if(arr[mid1]==K)return true;
           if(arr[mid2]==K)return true;
           
           if(K<arr[mid1])
                r = mid1-1;
            else if(K>arr[mid2])
                l = mid2+1;
            else
                {
                    l = mid1+1;
                    r = mid2-1;
                }
       }
       return -1;
    }
};

// { Driver Code Starts.
int main(void) 
{ 
    
    int t;
    cin >> t;
    while(t--){
        int N, K;
        cin >> N >> K;
        
        int arr[N];
        
        for(int i = 0;i<N;i++){
            cin >> arr[i];
        }
        Solution ob;
        cout << ob.ternarySearch(arr, N, K) << endl;

    }

	return 0; 
} 
  // } Driver Code Ends