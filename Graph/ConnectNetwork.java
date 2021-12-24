/*https://leetcode.com/problems/number-of-operations-to-make-network-connected/*/

//Depth First Traversal technique
class Solution {
    boolean[] visited;
    int visitCount = 0;
    int n;
    public int makeConnected(int n, int[][] connections) {
    	//if there are less than required wires, return -1
        if (connections.length < n-1) return -1;

        //build a graph from the given data
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < connections.length; ++i)
        {
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }
        
        //initialization
        int connectedComponents = 0;
        this.visited = new boolean[n];
        this.n = n;
        this.visitCount = 0;

        //until all vertices are visited
        while (visitCount != n)
        {
        	//increase the number of connected components
            ++connectedComponents;

            //get the next unvisited vertex
            int unvisited = getUnvisitedVertex();

            //mark it visited and increment the visit count
            visited[unvisited] = true;
            ++visitCount;

            //run DFS
            runDFS(graph,unvisited);
        }

        //return 
        return connectedComponents-1;
    }

    //standard DFS method
    public void runDFS(ArrayList<ArrayList<Integer>> graph, int currVertex)
    {
        ArrayList<Integer> adjacentVertices = graph.get(currVertex);
        for (int adjacentVertex : adjacentVertices)
        {
            if (!visited[adjacentVertex])
            {
                visited[adjacentVertex] = true;
                ++visitCount;
                runDFS(graph,adjacentVertex);
            }
        }
    }
    public int getUnvisitedVertex()
    {
        for (int i = 0; i < n; ++i)
            if (!visited[i])
                return i;
        return -1;
    }
}

//incomplete disjoint set technique
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) return -1;

        //store all the representatives
        int[] rep = new int[n];
        for (int i = 0; i < n; i++)
            rep[i] = i;

        //for each edge, call union
        for (int[] connection : connections)
            union(rep, connection[0], connection[1]);
        
        //count all the representatives, which gives the number of connected components
        int connectedComponents = 0;
        for (int i = 0; i < n; i++) {
            if (rep[i] == i) {
                connectedComponents++;
            }
        }
        return connectedComponents-1;
    }

    private void union(int[] rep, int x, int y) {
        int repX = find(x, rep);
        int repY = find(y, rep);

        //if both the representatives are equal, return
        if (repX == repY) {
            return;
        }

        //otherwise update one of them
        rep[repX] = repY;
    }

    private int find(int x, int[] rep) {
        //if x is representative, return x, otherwise recur on the representative of x
        return rep[x] == x ? x : (rep[x] = find(rep[x], rep));
    }
}