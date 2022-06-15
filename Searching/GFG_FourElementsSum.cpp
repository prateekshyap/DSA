/*
https://practice.geeksforgeeks.org/problems/four-elements2452/1#
Four Elements 
*/

// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

bool find4Numbers(int A[], int n, int X);

int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        int n, i, x;
        cin >> n;
        int a[n];
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        cin>>x;
        cout << find4Numbers(a, n, x) << endl;

    }
    return 0;
}// } Driver Code Ends


//User function Template for C++

bool find4Numbers(int A[], int n, int X)  
{
    sort(A, A+n);
    int l,r, sum, T;
    for(int i=0; i<n-3; i++)
    {
        for(int j=i+1; j<n-2; j++)
        {
            sum = A[i]+A[j];
            if(sum > X) break;
            T = X-sum;
            
            l = j+1;
            r = n-1;
            while(l<r)
            {
                sum = A[l]+A[r];
                if(sum == T) return true;
                else if(sum > T) r--;
                else
                    l++;
            }
        }
    }
    return false;
}