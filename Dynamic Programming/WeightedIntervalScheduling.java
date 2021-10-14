/*https://leetcode.com/problems/maximum-profit-in-job-scheduling/*/

/*Prateekshya*/

class Job
{
    int start, end;
    int profit;
    Job(int s, int e, int p)
    {
        start = s;
        end = e;
        profit = p;
    }
}

class Solution {
    int[] table;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[profit.length];
        for (int i = 0; i < profit.length; ++i)
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        Arrays.sort(jobs,new Comparator<Job>(){
            public int compare(Job j1, Job j2)
            {
                return j1.start-j2.start;
            }
        });
        table = new int[profit.length];
        for (int i = 0; i < table.length; ++i)
            table[i] = -1;
        return recur(0,jobs);
    }
    public int recur(int index, Job[] jobs)
    {
        if (index >= jobs.length) return 0;
        
        if(table[index] != -1) return table[index];

        int low = index+1; 
        int high = jobs.length; 
        
        while(low < high)
        {
            int mid = (low+high)/2;
            if (jobs[mid].start < jobs[index].end)
                low = mid+1;
            else
                high = mid;
        }
                
        table[index] = Math.max(recur(index+1,jobs), jobs[index].profit+recur(low,jobs));
        
        return table[index];
    }
}