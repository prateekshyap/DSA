/*
https://practice.geeksforgeeks.org/problems/maximize-sum-after-k-negations1149/1#
Maximize sum after K negations 
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    long long int maximizeSum(long long int a[], int n, int k)
    {
        long long int sum = 0;
        sort(a, a+n);
        
        int j=0;
        while(k)
        {
            if(a[j]<=0)
            {
                a[j] = -a[j];
                k--;
                j++;
            }
            else if(k&1 && j!=0)
            {
                a[j-1] = -a[j-1];
                break;
            }
            else  if(k&1 && j==0)
            {
                a[j] = -a[j];
                break;
            }
            else if (k%2 == 0)
                    break;
                
        }
        
        return accumulate(a, a+n, 0);
    }
};

// { Driver Code Starts.
int main()
 {
     int t;
     cin>>t;
     while(t--)
     {
         int n, k;
         cin>>n>>k;
         long long int a[n+5];
         for(int i=0;i<n;i++)
         cin>>a[i];
         Solution ob;
         cout<<ob.maximizeSum(a, n, k)<<endl;
     }
	
	return 0;
}  // } Driver Code Ends