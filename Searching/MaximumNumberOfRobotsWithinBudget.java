/*https://leetcode.com/problems/maximum-number-of-robots-within-budget/*/

class Solution {
    int[] charge, run;
    double budget;
    int n;
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        this.n = chargeTimes.length;
        this.charge = chargeTimes;
        this.run = runningCosts;
        this.budget = (double)budget;
        int result = 0, low = 1, high = n, mid;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (possible(mid)) //if mid number of consecutive robots are possible
            {
                result = mid; //store mid in result
                low = mid+1; //move right to check for higher number of consecutive robots
            }
            else high = mid-1; //otherwise move left to check for lower number of consecutive robots
        }
        return result;
    }
    private boolean possible(int k)
    {
        boolean result = false;
        double chargeCost = 0, runCost = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>(); //double ended queue    
        
        //standard sliding window maximum approach
        for (int i = 0; i < k; ++i)
        {
            while (!deque.isEmpty() && charge[deque.peekFirst()] <= charge[i])
                deque.pollFirst();
            deque.addFirst(i);
            runCost += run[i];
        }
        chargeCost = charge[deque.peekLast()];
        if (chargeCost+(runCost*k) <= budget) return true;
        for (int i = k; i < n; ++i)
        {
            if (!deque.isEmpty() && deque.peekLast() == i-k) deque.pollLast();
            while (!deque.isEmpty() && charge[deque.peekFirst()] <= charge[i])
                deque.pollFirst();
            deque.addFirst(i);
            chargeCost = charge[deque.peekLast()];
            runCost = runCost-run[i-k];
            runCost = runCost+run[i];
            if (chargeCost+(runCost*k) <= budget) return true;
        }
        return false;
    }
}