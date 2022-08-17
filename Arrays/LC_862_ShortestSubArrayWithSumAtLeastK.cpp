/*
https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
862. Shortest Subarray with Sum at Least K

*/

class Solution {
public:
    int shortestSubarray_TLE(vector<int>& nums, int k) {
        int i=0, j=0;
        int cursum =0 ;
        int len=INT_MAX;
        while(j<nums.size())
        {
            cursum += nums[j];
            int left = i, delsum = cursum;
            while(left < j)
            {
                delsum -= nums[left];
                left++;
                if(delsum >= k)
                {
                    cursum = delsum;
                    i=left;
                }
            }
            
            while(cursum>=k)
            {
                len = min(len, j-i+1);
                cursum -= nums[i];
                // cout<<cursum<<" ";
                i++;
            }
            j++;
        }
        
        return len == INT_MAX ? -1: len;
    }
    
    int shortestSubarray(vector<int>& nums, int k) {
        int n = nums.size();
        int len = INT_MAX;
        
        deque<int> dq;
        vector<long> ps(n, 0);
        ps[0] = nums[0];
        // cout<<ps[0]<<" ";
        for(int i=1; i<n; i++)
        {
            ps[i] = ps[i-1] + nums[i];
            // cout<<ps[i]<<" ";
        }
        // cout<<"\n";
        
        for(int i=1; i<n; i++)
        {
            if(ps[i] >= k)
                len = min(len, i+1);
            // cout<<i<<" ";
            // showdq(dq);
            while(!dq.empty() && ps[i] - ps[dq.front()] >= k)
            {
                len = min(len, i-dq.front());
                dq.pop_front();
            }
            // cout << '\t';
            // showdq(dq);
            while(!dq.empty() && ps[i]<=ps[dq.back()])
                dq.pop_back();
            
            dq.push_back(i);
            //  cout << '\t';
            // showdq(dq);
            //  cout << '\n';
        }
        
        return len == INT_MAX ? -1: len;
    }
    
    void showdq(deque<int> g)
    {
        deque<int>::iterator it;
        for (it = g.begin(); it != g.end(); ++it)
            cout << ' ' << *it;
       
    }
};