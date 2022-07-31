/*https://leetcode.com/problems/course-schedule/*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
                    for (Integer dest : graph.get(j)) //for each vertex in the destinations list
                        --map[dest]; //reduce the indegree by 1
                    break;
                }
            }
            if (!found) return false; //if no vertices found, return false
        }
        
        return true;
    }
}

/*Simple cycle finding*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){//T = O(n)
            courses.add(new ArrayList<>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){//T = O(p)
            courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int[] visited = new int[numCourses];//0 = has not been visited yet | 1 = has been visited | 2 = currently being visited
        
        for(int i = 0; i < numCourses; i++){//T is not O(n*p) cuz we loop only once through n and p
            if(visited[i] == 0){//0 = has not been visited yet. So need to confirm if possible to take this course, otherwise we can assume we already checked that it is possible. If 2, we would have already returned false.
                if(!dfs(courses, visited, i)) return false;//T = O(n): calls function max n times(if no course has prerequisites)
            }
        }
        
        return true;
    }
    
    public boolean dfs(List<List<Integer>> courses, int[] visited, int currCourse){//T = O(p): recurses max p times cuz it stops if visited before
        if(visited[currCourse] == 2) return false;
        
        visited[currCourse] = 2;//2 = currently being visited to check if possible to take course
        for(int i = 0; i < courses.get(currCourse).size(); i++){//checking if current course prerequisites are takeable
            if(visited[courses.get(currCourse).get(i)] != 1){//Check only if not 1 because we know 1 is possible from previous visit
                if(!dfs(courses, visited, courses.get(currCourse).get(i))) return false;
            }
        }
        visited[currCourse] = 1;//1 = has been visited
        
        return true;
    }
}