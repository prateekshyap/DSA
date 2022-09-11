/*https://leetcode.com/problems/maximum-performance-of-a-team/*/

class Solution {
    private static final int m = (int)1e9+7;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; ++i)
        {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }
        Arrays.sort(engineers,(a,b)->(b[1]-a[1]));
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
        long maxPerformance = 0, speedSum = 0;
        for (int i = 0; i < n; ++i)
        {
            if (heap.size() >= k)
                speedSum -= heap.poll();
            heap.add(engineers[i][0]);
            speedSum += engineers[i][0];
            maxPerformance = Math.max(maxPerformance,(speedSum*engineers[i][1]));
        }
        return (int)(maxPerformance%m);
    }
}