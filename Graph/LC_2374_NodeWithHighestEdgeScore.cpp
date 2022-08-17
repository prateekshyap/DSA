/*
2374. Node With Highest Edge Score

https://leetcode.com/problems/node-with-highest-edge-score/
*/

class Solution {
public:
    int edgeScore(vector<int>& edges) {
        int n = edges.size();
        // int ans=0;
//         unordered_map<int, long long> hash;
//         for(int i=0; i<n; i++) 
//             hash[edges[i]] += i; 
        
//         long long mx=0;
//         for(auto &x: hash)
//         {
//             if(x.second > mx)
//             {
//                 mx = x.second;
//                 ans = x.first;
//             }
//             else if(x.second == mx and x.first < ans)
//             {
//                 ans = x.first;
//             }
//             // cout<<x.first<<" "<<x.second<<endl;
//         }
         
//         return ans;
        vector<long long> score(n);
        for(int i=0; i<n; i++) 
            score[edges[i]] += i; 
        return max_element(score.begin(), score.end()) - score.begin();
    }
};