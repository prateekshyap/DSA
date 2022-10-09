/*https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/*/

class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int start = 0, duration = 0, max = 0, emp = 0;
        for (int i = 0; i < logs.length; ++i)
        {
            duration = logs[i][1]-start;
            start = logs[i][1];
            if (duration > max)
            {
                max = duration;
                emp = logs[i][0];
            }
            else if (duration == max)
            {
                emp = Math.min(emp,logs[i][0]);
            }
        }
        return emp;
    }
}