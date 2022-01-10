/* https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1#
 * Missing number in array
 * Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.
 */

// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;




// } Driver Code Ends
// User function template for C++

class Solution{
public:
    int MissingNumber(vector<int>& array, int n) {
        // Your code goes here

        /********* using sum of n numbers ***********/
        // int sum_of_n = (n*(n+1))/2;
        // int sum_of_arr = accumulate(array.begin(), array.end(),0);

        // return sum_of_n - sum_of_arr;

        /********* using xor ***********/
        int xor_sum=0;
        for (int e: array)
            xor_sum ^= e;
        for (int i=1; i<=n; i++)
            xor_sum ^= i;

        return xor_sum;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;

        vector<int> array(n - 1);
        for (int i = 0; i < n - 1; ++i) cin >> array[i];
        Solution obj;
        cout << obj.MissingNumber(array, n) << "\n";
    }
    return 0;
}  // } Driver Code Ends