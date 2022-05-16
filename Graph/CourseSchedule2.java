/*https://leetcode.com/problems/course-schedule-ii/*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int i, j, indegrees, k;
        for (i = 0; i < numCourses; ++i) graph.add(new ArrayList<Integer>());

        //create a graph for the given prerequisites
        for (i = 0; i < prerequisites.length; ++i)
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);

        //store all the indegrees
        int[] map = new int[numCourses];
        for (ArrayList<Integer> edges : graph)
            for (Integer destination : edges)
                ++map[destination];
        
        int[] result = new int[numCourses];
        int index = 0;
        boolean found = true;
        
        for (i = 0; i < numCourses; ++i) //for n times
        {
            found = false; //mark found as false
            for (j = 0; j < numCourses; ++j) //for each course
            {
                if (map[j] == 0) //if there is any vertex whose indegree is 0
                {
                    found = true; //mark found as true
                    map[j] = -1; //store -1 in that place to avoid reconsideration of the same vertex
                    result[index++] = j; //store the vertex in result
                    for (Integer dest : graph.get(j)) //for each vertex in the destinations list
                        --map[dest]; //reduce the indegree by 1
                    break;
                }
            }
            if (!found) return new int[0]; //if no vertices found, return empty array
        }
        
        return result;
    }
}