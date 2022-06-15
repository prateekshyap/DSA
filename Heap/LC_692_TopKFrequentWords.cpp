/*
https://leetcode.com/problems/top-k-frequent-words/
692. Top K Frequent Words

*/

 struct Comparator_2{
        bool operator()(pair<int,string> &a, pair<int, string> &b)
        {
            if(a.first == b.first)
                return a.second > b.second;
            return a.first < b.first;
        }
};

class Solution {
public:
   
    vector<string> topKFrequent_2(vector<string>& words, int k) {
        
        vector<string> ans;
        priority_queue<pair<int,string>, vector<pair<int,string>>, Comparator_2> pq;
        unordered_map<string, int> freq;
        
        for(string s: words)
            freq[s]++;
        for(auto x: freq)
            pq.push({x.second, x.first});

        while(k--) {
            // cout<<pq.top().second<<" "<<pq.top().first<<endl;
            ans.push_back(pq.top().second);
            pq.pop();
        }
        
        return ans;
    }
    
    static bool mycmp(pair<int,string> &a, pair<int, string> &b)
        {
            if(a.first == b.first)
                return a.second < b.second;
            return a.first > b.first;
        }
    
    vector<string> topKFrequent(vector<string>& words, int k) {
        
        vector<string> ans;
        vector<pair<int,string>> vec;
        unordered_map<string, int> freq;
        
        for(string s: words)
            freq[s]++;
        for(auto x: freq)
            vec.push_back({x.second, x.first});

        sort(vec.begin(), vec.end(), mycmp);
        
        int i=0;
        while(k-- && i<vec.size()) {
            ans.push_back(vec[i++].second);
        }
        
        return ans;
    }
    
    
    
    
};