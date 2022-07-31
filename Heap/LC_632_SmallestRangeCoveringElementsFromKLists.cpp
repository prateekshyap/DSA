/*
https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
632. Smallest Range Covering Elements from K Lists

https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1
Smallest range in K lists 
*/


class Solution {
public:
    class node{
        public:
        int val;
        int row;
        int col;
        node(int v, int r, int c)
        {
            val = v;
            row = r;
            col = c;
        }
        
    };
    
    class compare{
        public:
        bool operator()(node &a,node &b){
            // if(a[0] == b[0])
            return a.val>b.val;
        }
    };
    
    vector<int> smallestRange_PQ(vector<vector<int>>& nums) 
    {
        int k = nums.size();
        
        priority_queue<vector<int>, vector<vector<int>>, greater<>> pq;
          
          int maxe = INT_MIN;
          int mine;
          
          for(int r=0; r<k; r++)
          {
              pq.push({nums[r][0], r, 0});
              maxe = max(maxe, nums[r][0]);
          }
          
          int start = pq.top()[0]; // min ele in col
          int end = maxe; // max ele in col
          int row, col;
          
          while(!pq.empty())
          {
             mine = pq.top()[0]; // cur min ele
             row = pq.top()[1];
             col = pq.top()[2]; 
             pq.pop();
             
            //  cout<<"["<<row<<","<<col<<"] "<<mine<<" "<<maxe<<" ["<<start<<", "<<end<<"]"<<endl;
             
             if((maxe - mine) < (end - start))
             {
                 start = mine;
                 end = maxe;
             }
             
             if((col + 1) < nums[row].size() )
             {
                //  col = col+1;
                 pq.push({nums[row][col+1], row, col+1});
                 maxe = max(maxe, nums[row][col+1]);
             }
             else
                break;
             
          }//while
          
          
          
        return {start, end};
    }
    
    vector<int> smallestRange_(vector<vector<int>>& nums) 
    {
        // return smallestRange_PQ(nums);
        int k = nums.size();
        if(k==1)
            return {nums[0][0],nums[0][0]};
        
        vector<pair<int,int>> v;
        
        for(int r=0; r<k; r++)
            for(int &val: nums[r])
                v.push_back({val, r});
        
        sort(v.begin(), v.end());
        
        // for(auto x: v)
            // cout<<"("<<x.first<<", "<<x.second<<") ";
        // cout<<endl;
        
        int i=0, j=0;
        unordered_map<int,int> mp;
        vector<int> ans;
        int mine = INT_MAX;
        
        while(j<v.size())
        {
            mp[v[j].second]++; // count unique rows
            while(i<j && mp.size() == k) // if element from all k rows have been considered
            {
                // cout<<i<<" "<<j<<"] ["<<mp[v[j].second]<<" "<<mp.size()<<" "<<mine<<endl;
                if(v[j].first - v[i].first < mine)
                {
                    mine = v[j].first - v[i].first;
                    ans = {v[i].first , v[j].first};
                }
                if(mp[v[i].second] == 1)
                    mp.erase(v[i].second);
                else
                    mp[v[i].second]--;
                i++;
            }
            j++;
        }
        return ans;
    }//
    
    vector<int> smallestRange(vector<vector<int>>& nums) 
    {
        // return smallestRange_PQ(nums);
        int k = nums.size();
        if(k==1)
            return {nums[0][0],nums[0][0]};
        
        vector<pair<int,int>> v;
        
        for(int r=0; r<k; r++)
            for(int &val: nums[r])
                v.push_back({val, r});
        
        sort(v.begin(), v.end());
        
        // for(auto x: v)
            // cout<<"("<<x.first<<", "<<x.second<<") ";
        // cout<<endl;
        
        int i=0, j=0;
        // unordered_map<int,int> mp;
        int totalRows=0;
        vector<int> mp(k,0);
        vector<int> ans;
        int mine = INT_MAX;
        
        while(j<v.size())
        {
            mp[v[j].second]++; // count unique rows
            if(mp[v[j].second]==1) totalRows++;
            
            while(i<j && totalRows == k) // if element from all k rows have been considered
            {
                // cout<<i<<" "<<j<<"] ["<<mp[v[j].second]<<" "<<mp.size()<<" "<<mine<<endl;
                if(v[j].first - v[i].first < mine)
                {
                    mine = v[j].first - v[i].first;
                    ans = {v[i].first , v[j].first};
                }
                if(mp[v[i].second] == 1)
                    totalRows--;
   
                mp[v[i].second]--;
                i++;
            }
            j++;
        }
        return ans;
    }//
};


// GFG---------------------------------------------------------------
