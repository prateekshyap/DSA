/* https://practice.geeksforgeeks.org/problems/smallest-factorial-number5929/1
 * Given a number n. The task is to find the smallest number whose factorial contains at least n trailing zeroes.
 */

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution
{
public:
    int findNum(int n)
    {
        if(n==1) return 5; //5! = 120.

        int low = 0;
        int high = 5*n;

        // Binary Search.
        while (low<high)
        {
            int mid = (low + high) >> 1;

            if (num_of_zeroes(mid)>=n)
                high = mid;
            else
                low = mid+1;
        }

        return low;
    }

    //Trailing 0s in x!
    // = floor(x/5)+floor(x/25)+floor(x/125)+...
    int num_of_zeroes(int x){
        int f=5, cnt=0;
        while(f<=x){
            cnt = cnt + x/f;
            f = f*5;
        }
        return cnt;
    }
};

// { Driver Code Starts.


int main() {
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        Solution ob;
        cout <<ob.findNum(n) << endl;
    }
    return 0;
}  // } Driver Code Ends