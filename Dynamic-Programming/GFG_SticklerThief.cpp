/*
Stickler Thief
https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
*/

class Solution
{
    public:
    //Function to find the maximum money the thief can get.
    int FindMaxSum(int arr[], int n)
    {
        if(n==1) return arr[0];
        int prev1=0, prev2=0, cur;
        for(int i=0; i<n; i++)
        {
             cur = max(prev1, prev2+arr[i]);
             prev2 = prev1;
             prev1 = cur;
        }
        return cur;
    }
};

class Solution
{
    public:
    //Function to find the maximum money the thief can get.
    int FindMaxSum(int a[], int n)
    {
        // USING DYNAMIC PROGRAMMING
        // if(n==1) return a[0];
        // else if(n==2) return a[1];
        
        // int t[n];
        // t[0] = a[0];
        // t[1] = max(a[0], a[1]);
        // for(int i=2; i<n; i++){
        //     t[i] = max( t[i-1], (a[i]+t[i-2]) );
        // }
        // return t[n-1];
        
        // NON-DP
        // include, execulde
        int prev_inc = a[0], prev_exe = 0;
        int curr_inc = a[0], curr_exe = 0;
        
        for(int i=1; i<n; i++){
            
            curr_inc = a[i]+prev_exe;
            curr_exe = max(prev_inc, prev_exe);
            
            prev_inc = curr_inc;
            prev_exe = curr_exe;
        }
        return max(curr_inc, curr_exe);
        
    }
};