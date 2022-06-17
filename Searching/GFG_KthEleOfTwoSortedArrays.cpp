/*
https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1#
K-th element of two sorted Arrays 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
    public:
    int kthElement_1(int arr1[], int arr2[], int n, int m, int k)
    {
        int ind=0; 
        int i=0, j=0;
        while(i<n && j<m)
        {
            if(arr1[i] < arr2[j])
            {
                ind++;
                if(ind==k)return arr1[i];
                i++;   
            }
            else
            {
                ind++;
                if(ind==k)return arr2[j];
                j++;   
            }
        }
        while(i<n)
        {
            ind++;
            if(ind==k)return arr1[i];
            i++;  
        }
        while(j<m)
        {
            ind++;
            if(ind==k)return arr2[j];
            j++;   
        }
    }
    
    int kthElement_2(int arr1[], int arr2[], int n, int m, int k)
    {
        int low = min(arr1[0], arr2[0]);
        int high = max(arr1[n-1], arr2[m-1]);
        int mid, count, x, y;
        
        while(low<=high)
        {
            mid = low+(high-low)/2;
            x= upper_bound(arr1, arr1+n, mid)-arr1;
            y = upper_bound(arr2, arr2+m, mid)-arr2;
            count =  x+y;
                        
            // cout<<"("<<low<<","<<high<<","<<mid<<") ["<<x<<","<<y<<","<<count<<"] ";
            if(count <= k-1) 
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
    
    int kthElement(int arr1[], int arr2[], int n, int m, int k)
    {
        
        if(n>m)return kthElement(arr2, arr1, m, n, k);
        // if(n==0) return arr2[k-1];
        // if(k==1) return min(arr1[0], arr2[0]);
        
        int s = max(0, k-m); //k<n<m , n<m<k
        int e = min(n,k); //k<n<m, n<k<m
        int cut1, cut2;
        int l1 ,l2, r1, r2;
        
        while(s<=e)
        {
            cut1 = s+(e-s)/2; //some #mid elements from first arr1
            cut2 = k - cut1;  // remaining ele from arr2
            l1 = cut1==0 ? INT_MIN : arr1[cut1-1];
            l2 = cut2==0 ? INT_MIN : arr2[cut2-1];
            r1 = cut1==n ? INT_MAX : arr1[cut1];
            r2 = cut2==m ? INT_MAX : arr2[cut2];  
            
            // cout<<"("<<l1<<","<<r1<<","<<cut1<<") ["<<l2<<","<<r2<<","<<cut2<<"] ";
           
            if(l1<=r2 && l2<=r1)
                return max(l1, l2);
            else if(l1>r2) //deleting the right space of smaller arr
                e = cut1-1;
            else        //l2>r1 add left space of smaller arr
                s = cut1+1;  
        }
        return -1;
    }
};

// { Driver Code Starts.
 
// Driver code
int main()
{
	int t;
	cin>>t;
	while(t--){
		int n,m,k;
		cin>>n>>m>>k;
		int arr1[n],arr2[m];
		for(int i=0;i<n;i++)
			cin>>arr1[i];
		for(int i=0;i<m;i++)
			cin>>arr2[i];
		
		Solution ob;
        cout << ob.kthElement(arr1, arr2, n, m, k)<<endl;
	}
    return 0;
}  // } Driver Code Ends