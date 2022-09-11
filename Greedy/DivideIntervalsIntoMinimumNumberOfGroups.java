/*https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/*/

class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[][] times = new int[n*2][2];
        for (int i = 0, j = 0; i < n && j < 2*n; ++i, j += 2)
        {
            times[j] = new int[]{intervals[i][0],1};
            times[j+1] = new int[]{intervals[i][1]+1,-1};
        }
        Arrays.sort(times,(a,b)->(a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
        int sum = 0, max = 0;
        for (int i = 0; i < 2*n; ++i)
        {
            sum += times[i][1];
            max = Math.max(sum,max);
        }
        return max;
    }
}

class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1]-b[1]);
        
        int group = 0;
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && pq.peek()[1] < interval[0])
                pq.poll();
            pq.add(interval);
            group = Math.max(group, pq.size());
        }
        return group;
    }
}