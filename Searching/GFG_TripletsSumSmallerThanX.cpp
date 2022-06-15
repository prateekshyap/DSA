/*
https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1#
Count triplets with sum smaller than X 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
	
	
	public:
	long long countTriplets(long long arr[], int n, long long sum)
	{
        sort(arr, arr+n);
        
        if(n<3) return 0;
        long long cnt = 0, min_sum;
        int l, r ;
        for(int i=0; i<n-2; i++)
        {
            l = i+1;
            r = n-1;
            while(l<r)
            {
                min_sum = arr[i]+arr[l]+arr[r];
                
                if(min_sum < sum) 
                {    
                    cnt+=r-l;
                    l++;
                }
                else //if(min_sum > sum)
                {
                    r--;
                }
                    
            }
        }//for i
            
        return cnt;
	}
		 

};

// { Driver Code Starts.

int main() 
{
  
   
   	int t;
    cin >> t;
    while (t--)
    {
    	int n;
    	long long sum;
        cin>>n>>sum;
        long long arr[n];
        for(int i=0;i<n;i++){
            cin>>arr[i];
        }
	    

       

        Solution ob;
        cout << ob.countTriplets(arr, n, sum) ;
	   
        
	    cout << "\n";
	     
    }
    return 0;
}

  // } Driver Code Ends