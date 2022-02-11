/*
https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
Triplet Sum in Array

*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

  

 // } Driver Code Ends
// Function to find square root
// x: element to find square root
class Solution{
  public:
  int x;
    long long int floorSqrt(long long int x) 
    {
        // Your code goes here   
        if(x==0 || x ==1) return x;
        
        // /**** Recursive Binary Search ******/
        // this->x = x;
        // return SqrtRec(1, x/2 );
        
        /**** Linear Binary Search ******/
        unsigned int i=1, j = x/2, mid=-1;
        int ans=-1;
        while(i<=j){
            mid = i + (j-i)/2;
            
            if(mid == x/mid)
                return mid;
            
            if(mid < x/mid)
            {
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        
        return j;
        
    }
    
    long long int SqrtRec(long long int i, long long int j)
    {
        if(i>j) return j;
        
        int mid = i + (j-i)/2;
        if(mid == x/mid) return mid;
        if (mid<x/mid) return SqrtRec(mid+1, j);
        else return SqrtRec(i, mid-1);
    }
};

// { Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		long long n;
		cin>>n;
		Solution obj;
		cout << obj.floorSqrt(n) << endl;
	}
    return 0;   
}
  // } Driver Code Ends

// LC
class Solution {
public:
    int x;
    int mySqrt(int x) {
        // return pow(x,0.5);
        
        if(x==0 || x ==1) return x;
        
        /**** Linear Way ******/
//         unsigned int i=1;
//         for(; i*i<=x; i++)
//         {
            
//         }
//         return i-1;
        
        /**** Recursive Binary Search ******/
        // this->x = x;
        // return SqrtRec(1, x/2 );
        
        /**** Linear Binary Search ******/
        unsigned int i=1, j = x/2, mid=-1;
        int ans=-1;
        while(i<=j){
            mid = i + (j-i)/2;
            
            if(mid == x/mid)
                return mid;
            
            if(mid < x/mid)
            {
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        
        return j;
    }//end
    
    int SqrtRec(int i, int j)
    {
        if(i>j) return j;
        
        int mid = i + (j-i)/2;
        if(mid == x/mid) return mid;
        if (mid<x/mid) return SqrtRec(mid+1, j);
        else return SqrtRec(i, mid-1);
    }
    
};