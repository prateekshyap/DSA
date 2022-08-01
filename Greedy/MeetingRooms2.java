/*https://www.lintcode.com/problem/919*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int count = 0, i, prev, n = intervals.size(), scheduledCount = 0;
        Collections.sort(intervals,(a,b)->(a.end == b.end ? a.start-b.start : a.end-b.end));
        boolean[] scheduled = new boolean[n];

        while (scheduledCount != n)
        {
            ++count;
            prev = Integer.MAX_VALUE;
            for (i = intervals.size()-1; i >= 0; --i)
            {
                if (intervals.get(i).end <= prev && !scheduled[i])
                {
                    scheduled[i] = true;
                    ++scheduledCount;
                    prev = intervals.get(i).start;
                }
            }
        }

        return count;
    }
}