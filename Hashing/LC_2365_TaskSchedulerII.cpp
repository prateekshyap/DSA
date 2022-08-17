/*
https://leetcode.com/problems/task-scheduler-ii/
2365. Task Scheduler II

*/

class Solution {
public:
//     long long taskSchedulerII(vector<int>& tasks, int space) { 
//         long long days=0; 
//         unordered_map<long long,long long> um; //stores the last day the task was executed
//         for(int t: tasks)
//         {
//             days++;
//             // cout<<days<<" ";
//             if(um.find(t) == um.end()) 
//                 um[t] = days;
//             else
//             {
//                 long long oldday = um[t];
//                 if(oldday + space + 1 <= days)  {
//                     um[t] = days;
//                 }
//                 else {
//                     um[t] = days = oldday + space +1;
//                 }
//             }
//             // cout<<t<<" "<<um[t]<<endl;
//         }
//         return days;
//     }
    
    long long taskSchedulerII_(vector<int>& tasks, int space) { 
        long long days=0; 
        unordered_map<int,long long> hash;  //hashmap to store previous day on which task occured
        for(int t: tasks)
        {
            // days++;
            // if(hash.count(t) and days - hash[t] <= space)
            //     days += space - (days-hash[t]) + 1;
            // hash[t] = days;
            if(hash.count(t))
                hash[t] = days = max(days, hash[t] + space)+1;
            else
                hash[t] = days = days+1;
            
            // cout<<days<<" ";
            // cout<<t<<" "<<hash[t]<<endl;
        }
        return days;
    }
    
    long long taskSchedulerII(vector<int>& tasks, int space) { 
        long long days=0; 
        unordered_map<int,long long> next;  //hashmap to store previous day on which task occured
        for(int t: tasks)
        {
            if(next.count(t))
                days = max(days, next[t]);
            next[t] = days+space+1;
            days+=1;
            // cout<<days<<"= ";
            // cout<<t<<"-> "<<next[t]<<endl;
        }
        return days;
    }
};