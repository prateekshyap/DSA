/*
https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1#
Move all negative elements to end 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    void segregateElements1(int arr[],int N)
    {
        int pos[N];
        int neg[N];
        int p=0;
        int n=0;
        for(int i=0; i<N; i++)
        {
            if(arr[i] > 0)
                pos[p++]=arr[i];
            else
                neg[n++]=arr[i];
        }
        
        for(int i=0; i<p; i++)
        {
            arr[i]=pos[i];
        }
         for(int i=0; i<n; i++)
        {
            arr[i+p]=neg[i];
        }
        
    }//end
    void segregateElements(int arr[],int N)
    {
        int newarr[N];
        int p=0;
        int n=N-1;
        int i=0, j=N-1;
        while(i<N && j>=0)
        {
            if(arr[i] > 0)
                newarr[p++] = arr[i];
            i++;
            
            if(arr[j] < 0)
                newarr[n--] = arr[j];
            j--;
        }
        
        for(int i=0; i<N; i++)
        {
            arr[i]=newarr[i];
        }
        
    }//end
};

// { Driver Code Starts.
int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int a[n];
		for(int i=0;i<n;i++)
		cin>>a[i];
		Solution ob;
		ob.segregateElements(a,n);
		
        for(int i=0;i<n;i++)
        cout<<a[i]<<" ";
		cout<<endl;
	}
}
  // } Driver Code Ends