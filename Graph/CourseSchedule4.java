/*https://leetcode.com/problems/course-schedule-iv/*/

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int i, j, k;
        for (i = 0; i < numCourses; ++i) graph.add(new ArrayList<Integer>());

        //create a graph for the given prerequisites
        boolean[][] reachable = new boolean[numCourses][numCourses];
        for (i = 0; i < prerequisites.length; ++i)
            reachable[prerequisites[i][0]][prerequisites[i][1]] = true;
        for (i = 0; i < numCourses; ++i)
        {
            for (j = 0; j < numCourses; ++j)
            {
                for (k = 0; k < numCourses; ++k)
                {
                    if (!reachable[j][k] && reachable[j][i] && reachable[i][k])
                        reachable[j][k] = true;
                }
            }
        }
        
        List<Boolean> result = new ArrayList<Boolean>();
        for (int[] q : queries) result.add(reachable[q[0]][q[1]]);
        
        return result;
    }
}