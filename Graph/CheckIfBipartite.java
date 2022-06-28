/*https://practice.geeksforgeeks.org/problems/bipartite-graph/1*/
/*https://leetcode.com/problems/is-graph-bipartite/*/

class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
    	//create a queue and two sets
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> first = new HashSet<Integer>();
        HashSet<Integer> second = new HashSet<Integer>();
        boolean[] visited = new boolean[v];
        
        //for every vertex
        for (int i = 0; i < v; ++i)
        {
        	//if the vertex is not yet visited
            if (!visited[i])
            {
            	//add it to the first set and queue, mark it as visited
                first.add(i);
                visited[i] = true;
                queue.add(i);

                //till the queue becomes empty
                while (!queue.isEmpty())
                {
                	//remove front
                    int curr = queue.remove();

                    //get the adjacent nodes
                    ArrayList<Integer> adjacentNodes = adj.get(curr);
                    
                    //for every adjacent node
                    for (Integer adjacentNode : adjacentNodes)
                    {
                    	//if first set contains the current node
                        if (first.contains(curr))
                        {
                        	//and first set also contains the adjacent node
                            if (first.contains(adjacentNode))
                                return false; //graph is not bipartite

                            //add the adjacent node to the second set
                            second.add(adjacentNode);

                            //mark as visited and add to queue
                            if (!visited[adjacentNode])
                            {
                                visited[adjacentNode] = true;
                                queue.add(adjacentNode);
                            }
                        }

                        //if the second set contains the current node
                        else if (second.contains(curr))
                        {
                        	//and second set also contains the adjacent node
                            if (second.contains(adjacentNode))
                                return false; //graph is not bipartite

                            //add the adjacent node to the first set
                            first.add(adjacentNode);

                            //mark as visited and add to queue
                            if (!visited[adjacentNode])
                            {
                                visited[adjacentNode] = true;
                                queue.add(adjacentNode);
                            }
                        }
                    }
                }
            }
        }

        //if loop uninterrupted, graph is bipartite
        return true;
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length, i;
        int[] color = new int[N];
        
        for (i = 0; i < N; ++i) color[i] = -1;
        
        for (i = 0; i < N; ++i)
            if (color[i] == -1)
                if (!DFS(graph,color,i))
                    return false;
        
        return true;
    }
    boolean DFS (int[][] graph, int[] color, int node)
    {
        if (color[node] == -1) color[node] = 1;
        for (int a: graph[node])
        {
            if (color[a] == -1)
            {
                color[a] = 1-color[node];
                if (!DFS(graph,color,a)) return false;
            }
            else if(color[a] == color[node]) return false;
        }
        return true;
    }
}