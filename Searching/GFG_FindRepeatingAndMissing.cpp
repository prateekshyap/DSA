/*
https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1#
Find Missing And Repeating 
*/

// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

 // } Driver Code Ends
class Solution{
public:
    int *findTwoElement_1(int *arr, int n) {
        int *ans = new int[2]{-1};
        
        int val=0;
        int ele=0;
        
        for(int i=0; i<n; i++)
        {
            val = abs(arr[i]); // value of arr i
            ele = arr[val-1]; // zero indexing, value of val
            if(ele>0)
                arr[val-1] = -ele;
            else
                ans[0] = val;
        }
        
        for(int i=0; i<n; i++)
        {
            if(arr[i]>0)
            {
                ans[1] = i+1;
                break;
            }
                
        }
        
        // for(int i=0; i<n; i++)
        //     cout<<i<<" "<<arr[i]<<", ";
        
        return ans;
    }
    
    int *findTwoElement(int *arr, int n) {
        int *ans = new int[2]{-1};
        
        int xr=0;
        
        for(int i=0; i<n; i++)
        {
            xr ^= arr[i];
            xr ^= (i+1);
        }
        
        int firstSetBit = xr & ~(xr-1); //rightmost set bit
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<n; i++)
        {
            if(arr[i] & firstSetBit)
                num1 ^= arr[i];
            else
                num2 ^= arr[i];
            
            if((i+1) & firstSetBit)
                num1 ^= (i+1);
            else
                num2 ^= (i+1);
        }
        
         for(int i=0; i<n; i++)
            if(num2 == arr[i])
                {
                    swap(num1,num2);
                    break;
                }
        
        ans[0]=num1;
        ans[1]=num2;
        // for(int i=0; i<n; i++)
        //     cout<<i<<" "<<arr[i]<<", ";
        
        return ans;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findTwoElement(a, n);
        cout << ans[0] << " " << ans[1] << "\n";
    }
    return 0;
}  // } Driver Code Ends