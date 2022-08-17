/*
https://practice.geeksforgeeks.org/problems/pairs-with-specific-difference1533/1#
Pairs with specific difference 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

class Solution{
    public:
    int maxSumPairWithDifferenceLessThanK_1(int arr[], int N, int K)
    {
        sort(arr, arr+N);
        int sum=0;
        
        int i=N-2;
        int j=N-1;
        
        while(i>=0)
        {
          if(arr[j] - arr[i] < K)
          {
            //   cout<<"["<<arr[i]<<", "<<arr[j]<<"]"<<endl;
              sum+= arr[i] + arr[j]; 
              j=j-2;
              i=i-2;
          }
          else //if(arr[i] - arr[j] > K)
          {
              j=j-1;
              i= i-1;
          }
             
        }
        
        return sum;
    }//end
    
    int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K)
    {
        sort(arr, arr+N);
        int sum=0;
        
        int j=N-1;
        
        while(j>=1)
        {
          if(arr[j] - arr[j-1] < K)
          {
            //   cout<<"["<<arr[i]<<", "<<arr[j]<<"]"<<endl;
              sum+= arr[j-1] + arr[j]; 
              j=j-2;
          }
          else
              j=j-1;
             
        }
        
        return sum;
    }//end
};

// { Driver Code Starts.
int main() {
	int t;
	cin>>t;
	while(t--)
	{
		int N;
		cin>>N;
		int arr[N];
		for(int i=0;i<N;i++)
		cin>>arr[i];

		int K;
		cin>>K;
        Solution ob;
		cout<<ob.maxSumPairWithDifferenceLessThanK(arr,N,K)<<endl;
	}
	return 0;
}
  // } Driver Code Ends