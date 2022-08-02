/*https://leetcode.com/problems/minimum-cost-to-hire-k-workers/*/

class Worker implements Comparable<Worker>
{
    public int quality, wage;
    public double ratio;
    public Worker(int q, int w)
    {
        quality = q;
        wage = w;
        ratio = (double)wage/(double)quality;
    }
    @Override
    public int compareTo(Worker other)
    {
        double result = this.ratio-other.ratio;
        if (result < 0) return -1;
        if (result > 0) return 1;
        return 0;
    }
}

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length, i;
        Worker[] workers = new Worker[n];
        for (i = 0; i < n; ++i)
            workers[i] = new Worker(quality[i],wage[i]);
        Arrays.sort(workers);
        double result = 1e9;
        int sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (Worker worker : workers)
        {
            heap.add(-worker.quality);
            sum += worker.quality;
            if (heap.size() > k)
                sum += heap.poll();
            if (heap.size() == k)
                result = Math.min(result,sum*worker.ratio);
        }
        
        return result;
    }
}