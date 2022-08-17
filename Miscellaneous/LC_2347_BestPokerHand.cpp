/*
https://leetcode.com/problems/best-poker-hand/
2347. Best Poker Hand

*/

class Solution {
public:
    string bestHand(vector<int>& ranks, vector<char>& suits) {
        sort(suits.begin(), suits.end());
        if(suits[0] == suits[4]) return "Flush";
        
        vector<int> freq_rank(14, 0);
        for(int i=0 ; i<5; i++)
        {
            freq_rank[ranks[i]]++;
        }
        sort(freq_rank.begin(), freq_rank.end(), greater<>());
        if(freq_rank[0] >= 3 )
            return "Three of a Kind";
        if(freq_rank[0] == 2 )
            return "Pair";
        return "High Card";
    }
};