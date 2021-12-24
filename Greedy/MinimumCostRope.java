/*https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1*/

class Solution
{
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        for (int i = 0; i < n; ++i)
            minHeap.add(arr[i]);
        long result = 0;
        while (minHeap.size() > 1)
        {
            long temp = minHeap.poll()+minHeap.poll();
            minHeap.add(temp);
            result += temp;
        }
        return result;
    }
}