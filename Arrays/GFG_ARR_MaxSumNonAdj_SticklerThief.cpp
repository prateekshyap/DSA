/* https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1#
 * Stickler the thief wants to loot money from a society having n houses in a single line.
 * He is a weird person and follows a certain rule when looting the houses.
 * According to the rule, he will never loot two consecutive houses.
 * At the same time, he wants to maximize the amount he loots.
 * The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy.
 * He asks for your help to find the maximum money he can get if he strictly follows the rule.
 * Each house has a[i] amount of money present in it.
 */

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;

// } Driver Code Ends
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

// { Driver Code Starts.
int main()
{
    //taking total testcases
    int t;
    cin>>t;
    while(t--)
    {
        //taking number of houses
        int n;
        cin>>n;
        int a[n];

        //inserting money of each house in the array
        for(int i=0;i<n;++i)
            cin>>a[i];
        Solution ob;
        //calling function FindMaxSum()
        cout<<ob.FindMaxSum(a,n)<<endl;
    }
    return 0;
}
// } Driver Code Ends