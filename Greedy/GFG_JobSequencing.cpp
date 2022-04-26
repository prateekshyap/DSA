/*
Job Sequencing Problem 
https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
*/
// Program to find the maximum profit job sequence from a given array 
// of jobs with deadlines and profits 
#include<bits/stdc++.h>
using namespace std; 

// A structure to represent a job 
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
}; 


 // } Driver Code Ends
/*
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
};
*/

class Solution 
{
    public:
    // decreasing order of profit
    static bool compare(const Job& a, const Job& b)
    {
        return a.profit > b.profit;
    }
    //Function to find the maximum profit and the number of jobs done.
    vector<int> JobScheduling1(Job arr[], int n) 
    { 
        sort(arr, arr+n, compare);
        
        int maxProfit =0;
        int maxDeadline =0;
        int jobCount =0;
        
        for(int i=0; i<n; i++)
        {
            if(maxDeadline < arr[i].dead)
                maxDeadline = arr[i].dead;
        }
        
        vector<int> jobSequence(maxDeadline+1, -1);
        
        for(int i=0; i<n; i++)
        {
            for(int d=arr[i].dead; d>=1; d--)
            {
                if(jobSequence[d]==-1)
                {
                    jobSequence[d] = arr[i].id;
                    maxProfit += arr[i].profit;
                    jobCount++;
                    break;
                }
            }
        }
        
        return {jobCount, maxProfit};
    } 
    
    struct JobCompare
    {
        bool operator()(const Job& a, const Job& b)
        {
            return a.profit < b.profit;
        }
    };
    
    vector<int> JobScheduling(Job arr[], int n) 
    { 
        // sort(arr, arr+n, compare);
        priority_queue<Job, vector<Job>, JobCompare> pq(arr, arr+n);
        
        int maxProfit =0;
        int maxDeadline =0;
        int jobCount =0;
        
        // for(int i=0; i<n; i++)
        // {
        //     if(maxDeadline < arr[i].dead)
        //         maxDeadline = arr[i].dead;
        // }
        
        vector<int> jobSequence(100+1, -1);
        
        while(!pq.empty())
        {
            Job j = pq.top(); pq.pop();
            
            for(int d=j.dead; d>=1; d--)
            {
                if(jobSequence[d]==-1)
                {
                    jobSequence[d] = j.id;
                    maxProfit += j.profit;
                    jobCount++;
                    break;
                }
            }
        }
        
        return {jobCount, maxProfit};
    } 
};

// { Driver Code Starts.
// Driver program to test methods 
int main() 
{ 
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        Job arr[n];
        
        //adding id, deadline, profit
        for(int i = 0;i<n;i++){
                int x, y, z;
                cin >> x >> y >> z;
                arr[i].id = x;
                arr[i].dead = y;
                arr[i].profit = z;
        }
        Solution ob;
        //function call
        vector<int> ans = ob.JobScheduling(arr, n);
        cout<<ans[0]<<" "<<ans[1]<<endl;
    }
	return 0; 
}


  // } Driver Code Ends