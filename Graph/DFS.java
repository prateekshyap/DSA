/*https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1*/

class Solution
{
    boolean[] visited;
    int v;
    ArrayList<Integer> list;
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        this.visited = new boolean[V];
        this.v = V;
        this.list = new ArrayList<Integer>();

        //mark the source as visited and run the revursion
        visited[0] = true;
        list.add(0);
        runDFS(0,adj);
        return list;
    }
    public void runDFS(int currNode, ArrayList<ArrayList<Integer>> graph)
    {
    	//get the adjacent nodes of the current node
        ArrayList<Integer> adjacentNodes = graph.get(currNode);
        
        //for every adjacent node
        for (Integer adjNode : adjacentNodes)
        {
        	//if it is not visited
            if (!visited[adjNode])
            {
            	//mark it as visited and recur
                visited[adjNode] = true;
                list.add(adjNode);
                runDFS(adjNode,graph);
            }
        }
    }
}