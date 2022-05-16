/*https://leetcode.com/problems/course-schedule-iii/*/

class Solution {
    public int scheduleCourse(int[][] courses) {
        int i, n = courses.length, result = 0, currTime = 0;
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)->b-a);
        int[] course;
        
        for (i = 0; i < n; ++i)
        {
            course = courses[i];
            if (currTime+course[0] <= course[1])
            {
                queue.add(course[0]);
                currTime += course[0];
            }
            else if (!queue.isEmpty() && queue.peek() > course[0])
            {
                currTime += course[0]-queue.poll();
                queue.add(course[0]);
            }
        }
        return queue.size();
    }
}