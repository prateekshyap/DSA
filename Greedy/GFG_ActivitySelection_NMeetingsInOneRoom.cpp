/*
https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1/
N meetings in one room 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{
    public:
    static bool comp(const pair<int,int>& a, const pair<int,int>&b)
    {
        if(a.second == b.second) return a.first < b.first;
        else
            return a.second < b.second;
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    int maxMeetings(int start[], int end[], int n)
    {
        vector<pair<int,int>> meetings;
        
        for(int i=0; i<n ; i++)
        {
            meetings.push_back({start[i], end[i]});
        }
        
        sort(meetings.begin(), meetings.end(), comp);
        
        int totm=1;
        int prev=0;
        for(int i=1; i<n; i++)
        {
            if(meetings[prev].second < meetings[i].first)
            {
                totm++;
                prev = i;
            }
        }
        return totm;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int start[n], end[n];
        for (int i = 0; i < n; i++) cin >> start[i];

        for (int i = 0; i < n; i++) cin >> end[i];

        Solution ob;
        int ans = ob.maxMeetings(start, end, n);
        cout << ans << endl;
    }
    return 0;
}  // } Driver Code Ends