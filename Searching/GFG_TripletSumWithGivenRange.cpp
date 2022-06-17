/*
https://practice.geeksforgeeks.org/problems/triplets-with-sum-with-given-range/1/#
Triplets with sum with given range 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int countTriplets(int Arr[], int N, int L, int R) {
        sort(Arr, Arr+N);
        
        if(N<3) return 0;
        int low, high, cnt;
        
         function<int(int)> count_diff = [&](int T)->int{
            cnt=0;
            
            for(int i=0; i<N-2; i++)
            {
                low = i+1;
                high = N-1;
                while(low<high)
                {
                    if(Arr[i]+Arr[low]+Arr[high] > T)
                        high--;
                    else
                        cnt += high-low, low++;
                }
            }
            
            return cnt;
        };
            
        return count_diff(R)-count_diff(L-1);
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        int Arr[N];
        for (int i = 0; i < N; i++) cin >> Arr[i];
        int L, R;
        cin >> L >> R;
        Solution obj;
        cout << obj.countTriplets(Arr, N, L, R) << endl;
    }
    return 0;
}  // } Driver Code Ends