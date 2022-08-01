/*https://www.lintcode.com/problem/850/*/

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
     * @param schedule: a list schedule of employees
     * @return: Return a list of finite intervals 
     */
    public List<Interval> employeeFreeTime(int[][] schedules) {
       List<List<Integer>> points = new ArrayList<>();
       int start = 0, end = 0;
       for (int[] schedule : schedules) {
           for (int i = 0; i < schedule.length / 2; i++) {
               start = schedule[i * 2];
               end = schedule[i * 2 + 1];
               points.add(new ArrayList<Integer>(Arrays.asList(start, 1)));
               points.add(new ArrayList<Integer>(Arrays.asList(end, -1)));
           }
       }
       points.sort(
           (List<Integer> point1, List<Integer> point2) -> point1.get(0).compareTo(point2.get(0))
       );
       int lastPosition = 0, busy = 0;
       List<Interval> result = new ArrayList<>();
       for (List<Integer> _point : points) {
           int position = _point.get(0);
           if (busy == 0 && lastPosition != 0 && position != lastPosition) {
               result.add(new Interval(lastPosition, position));
           }
           busy += _point.get(1);
           lastPosition = position;
       }
       return result;
    }
}