/*https://practice.geeksforgeeks.org/problems/number-of-provinces/1*/

//simple BFS
//adj is not adjacency list, it is adjacency matrix
class Solution {
    static boolean[] visited;
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        visited = new boolean[V];
        int counter = 0, currNode = -1, j = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < V; ++i)
        {
            if (!visited[i])
            {
                ++counter;
                queue.add(i);
                while (!queue.isEmpty())
                {
                    currNode = queue.poll();
                    if (visited[currNode]) continue;
                    visited[currNode] = true;
                    for (j = 0; j < V; ++j)
                    {
                        if (currNode != j && (Integer)adj.get(currNode).get(j) == 1 && !visited[j])
                            queue.add(j);
                    }
                }
            }
        }
        return counter;
    }
};