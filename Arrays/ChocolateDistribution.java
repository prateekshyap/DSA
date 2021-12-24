/*https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1*/

class Solution
{
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        Collections.sort(a); //merge or quick
        int windowStart = 0, windowEnd = (int)m-1;
        long minDiff = a.get(windowEnd) - a.get(windowStart);
        for (int i = 1; i <= n-m; ++i)
        {
            windowStart = i;
            windowEnd = windowStart+(int)m-1;
            long currDiff = a.get(windowEnd) - a.get(windowStart);
            if (currDiff < minDiff)
                minDiff = currDiff;
        }
        return minDiff;
    }
}