/*https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1/*/

class ProfitComparator implements Comparator<Job>
{
    public int compare(Job j1, Job j2)
    {
        if (j1.profit < j2.profit) return 1;
        if (j1.profit > j2.profit) return -1;
        return 0;
    }
}

class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
        //add everything to minheap and find out the maximum deadline possible
        int maxDeadline = Integer.MIN_VALUE;
        PriorityQueue<Job> pq = new PriorityQueue<Job>(new ProfitComparator());
        for (int i = 0; i < n; ++i)
        {
            pq.add(arr[i]);
            if (arr[i].deadline > maxDeadline) maxDeadline = arr[i].deadline;
        }

        int[] result = new int[2];
        int[] timeline = new int[maxDeadline];

        //till we have more elements
        while (!pq.isEmpty())
        {
            //remove the root
            Job job = pq.poll();

            int iterator = job.deadline-1;

            //traverse the timeline in reverse direction
            while (iterator >= 0)
            {
                //when a space is found
                if (timeline[iterator] == 0)
                {
                    //store the job
                    timeline[iterator] = job.id;
                    
                    //increment the count
                    ++result[0];

                    //increase the profit
                    result[1] += job.profit;

                    //stop the loop
                    break;
                }

                --iterator;
            }

            //when the timeline is full, stop the loop
            if (result[0] == timeline.length) break;
        }
        
        return result;
    }
}