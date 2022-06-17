/*
https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1#
Merge Without Extra Space 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++
class Solution{
public:
	void merge(int arr1[], int arr2[], int n, int m) {
	    
	    /*
	    int i=n-1;
	    int j=0;
	    
	    while(i>=0 && j<m)
	    {
	        if(arr1[i] > arr2[j] )
	            swap(arr1[i--], arr2[j++]);
	        else
	            break; //no need to check further 
	            // arr1_i will be smaller and arr2_j will be bigger
	       
	       // j++;
	       // i--;
	    }
	    
	    sort(arr1, arr1+n);
	    sort(arr2, arr2+m);
	    */
	    
	    /*  USING Insertion Sort
	    //TLE at 249th TestCase
	    int i,j=0, first;
	    for(int i=0; i<n; i++)
	    {
	        //take one by one each ele of arr1
	        if(arr1[i]>arr2[0])
	            swap(arr1[i], arr2[0]);
	        
	        //now sort the arr2 using insertion sort
	         first = arr2[0];
	        
	        for( j=1; j<m && first>arr2[j]; j++)
	            arr2[j-1] = arr2[j];
	       
	        arr2[j-1] = first;
	    }//end fun
	     */
	     
	   //  /*
	     //USING GAP
	     int gap = ceil((float)(n+m)/2);
	     
	     while(gap>0)
	     {
	         int i=0;
	         int j=gap;
	         
	         while(j < (n+m))
	         {
	             if(j<n && arr1[i] > arr1[j])
	                swap(arr1[i], arr1[j]);
	             else if(j>=n && i<n && arr1[i] > arr2[j-n])
	                swap(arr1[i], arr2[j-n]);
                else if(j>=n && i>=n && arr2[i-n] > arr2[j-n])
	                swap(arr2[i-n], arr2[j-n]);
               i++;
	           j++;
	         }//while j < n+m
	         
	        
	         
	         if(gap==1) 
	            gap=0;
	         else
	            gap = ceil((float)gap/2);
	     }//end while gap
	   // */
	}//end
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m, i;
        cin >> n >> m;
        int arr1[n], arr2[m];
        for (i = 0; i < n; i++) {
            cin >> arr1[i];
        }
        for (i = 0; i < m; i++) {
            cin >> arr2[i];
        }
        Solution ob;
        ob.merge(arr1, arr2, n, m);
        for (i = 0; i < n; i++) {
            cout << arr1[i] << " ";
        }
        for (i = 0; i < m; i++) {
            cout << arr2[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}  // } Driver Code Ends