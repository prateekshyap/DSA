/*
https://leetcode.com/problems/task-scheduler/
621. Task Scheduler

*/

class Solution {
public:
    int leastInterval_1(vector<char>& tasks, int d) {
        if(d==0)
            return tasks.size();
        
        int freq[26] = {0};
        
        for(char &t: tasks)
            freq[t-'A']++;
        
        const int maxFreq = *max_element(freq, freq+26);
        const int numMaxFreqEle = count(freq, freq+26, maxFreq);
        //slots of d+1 size, 
        const int maxFreqTaskOccupy = (maxFreq-1)*(d+1); 
        
        return max(static_cast<int>(tasks.size()), maxFreqTaskOccupy + numMaxFreqEle);
        
    }//end
    
    int leastInterval(vector<char>& tasks, int d) {
        if(d==0)
            return tasks.size();
        
        int freq[26] = {0};
        
        for(char &t: tasks)
            freq[t-'A']++;
        
        sort(freq, freq+26);
        
        int max_val = freq[25]-1;
        int idle_slots = max_val * d;
        
        for(int i=24; i>=0; i--)
            idle_slots -= min(freq[i], max_val);
        
        return idle_slots>0 ? idle_slots+tasks.size(): tasks.size();
        
        
    }//end
    
};