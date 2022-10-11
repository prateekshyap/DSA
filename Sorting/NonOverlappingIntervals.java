/*https://leetcode.com/problems/non-overlapping-intervals/*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 0;
        Arrays.sort(intervals,(a,b)->(a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
        int count = 0, currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i)
        {
            if (intervals[i][0] >= currEnd)
                currEnd = intervals[i][1];
            else
            {
                ++count;
                currEnd = Math.min(currEnd,intervals[i][1]);
            }
        }
        return count;
    }
}

