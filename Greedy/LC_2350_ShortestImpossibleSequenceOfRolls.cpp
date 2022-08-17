/*
https://leetcode.com/problems/shortest-impossible-sequence-of-rolls/
2350. Shortest Impossible Sequence of Rolls

*/

class Solution {
public:
    int shortestSequence(vector<int>& rolls, int k) {
        int len = 1;
        unordered_set<int> s;
        
        for(int &x: rolls)
        {
            s.insert(x);
            if(s.size()==k)
            {
                len++;
                s.clear();
            }
        }
        
        return len;
    }
};