/*
https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1
Shop in Candy Store 
*/

// { Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
class Solution
{
public:
    vector<int> candyStore(int candies[], int N, int K)
    {
        int minc=0;
        int maxc=0;
        sort(candies, candies+N);
        int i=0;
        int j=N-1;
        
        while(i<=j)
        {
            minc += candies[i];
            i++;
            j = j-K;
        }
        
        i=0; j=N-1;
        while(i<=j)
        {
            maxc += candies[j];
            j--;
            i = i+K;
        }
        
        return {minc, maxc};
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N, K;
        cin >> N >> K;
        int candies[N];

        for (int i = 0; i < N; i++)
        {
            cin >> candies[i];
        }

        Solution ob;
        vector<int> cost = ob.candyStore(candies, N, K);
        cout << cost[0] << " " << cost[1] << endl;
    }
    return 0;
}  // } Driver Code Ends