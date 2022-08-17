/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
1010. Pairs of Songs With Total Durations Divisible by 60

*/


class Solution {
public:
    /*
    int numPairsDivisibleBy60(vector<int>& time) {
       
        int ans=0;
        int n = time.size();
        vector<int> rem(60, 0);
        
        for(int t: time)
        {
            t = t%60;
            ans+= rem[(60-t)%60]; //60-0 => 60%60 => 0
            rem[t]++;
        }
        
        return ans;
    }//
    */
    
    int numPairsDivisibleBy60(vector<int>& time) {
       
        int pairs=0;
        long rem[60] = {0};
        
        for(int t: time)
            rem[t%60]++;
        
        pairs += rem[0]*(rem[0]-1)/2;
        pairs += rem[30]*(rem[30]-1)/2;
        
        for(int i=1; i<30; i++)
            pairs+=rem[i]*rem[60-i];
        
        return pairs;
    }//
};