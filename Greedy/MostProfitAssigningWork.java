/*https://leetcode.com/problems/most-profit-assigning-work/*/

class Job implements Comparable<Job>
{
    int difficulty;
    int profit;
    Job(int d, int p)
    {
        difficulty = d;
        profit = p;
    }
    @Override
    public int compareTo(Job j)
    {
        return j.profit-this.profit;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int totalProfit = 0;
        int D = difficulty.length, W = worker.length, i, j;
        PriorityQueue<Job> jobExtractor = new PriorityQueue<Job>();
        for (i = 0; i < D; ++i)
            jobExtractor.add(new Job(difficulty[i],profit[i]));
        Job job = null;
        job = jobExtractor.poll();
        Arrays.sort(worker);
        for (i = W-1; i >= 0; --i)
        {
            while (!jobExtractor.isEmpty() && job.difficulty > worker[i]) job = jobExtractor.poll();
            if (job.difficulty > worker[i]) break;
            totalProfit += job.profit;
        }
        return totalProfit;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int max = 0, i, D = difficulty.length;
    for (int d : difficulty) if (d > max) max = d;
    int[] dp = new int[max+1];
    for (i = 0; i < D; ++i)
        dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
    for (i = 1; i < max+1; ++i)
        dp[i] = Math.max(dp[i], dp[i-1]);
    int sum = 0;
    for (int w : worker) if (w > max) sum += dp[max]; else sum += dp[w];    
    return sum;
    }
}