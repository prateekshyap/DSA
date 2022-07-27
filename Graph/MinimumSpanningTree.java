/*https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1*/

class Solution
{
    static int getMinKeyVertex(int[] key, boolean[] mstSet, int V)
    {
        int minKey = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < V; i++)
        {
            if (!mstSet[i] && key[i] < minKey)
            {
                minKey = key[i];
                index = i;
            }
        }
        return index;
    }

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int result = 0;
        int[] parent = new int[V]; //stores mst
        int[] key = new int[V]; //stores key values for each vertex
        boolean[] mstSet = new boolean[V]; //keeps track of the vertices added to the mst
        
        //initializing all keys to inifinite except 0
        for (int i = 1; i < V; ++i)
            key[i] = Integer.MAX_VALUE;

        parent[0] = -1; //0th vertex included to the mst
        int minKeyVertex;

        //for all vertices
        for (int count = 1; count < V; ++count)
        {
            minKeyVertex = getMinKeyVertex(key,mstSet,V);//find the minimum key which is not added to the mst yet
            mstSet[minKeyVertex] = true; //add it to the mst
            ArrayList<ArrayList<Integer>> adjacentNodes = adj.get(minKeyVertex); //get the adjacent vertices

            //for all the edges from that vertex
            for (ArrayList<Integer> edges : adjacentNodes)
            {
            	//if it is not added to the mst and edge weight is smaller than the current key
                if (!mstSet[(Integer)edges.get(0)] && edges.get(1) < key[(Integer)edges.get(0)])
                {
                	//update the value and the parent
                    parent[(Integer)edges.get(0)] = minKeyVertex;
                    key[(Integer)edges.get(0)] = edges.get(1);
                }
            }
        }

        //add all the values and return
        for (int i = 0; i < key.length; ++i)
            result += key[i];
        return result;
    }
}

class Solution
{
    static int V;
    static int[] costs;
    static boolean[] visited;
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        V = v;
        costs = new int[V];
        int[] parents = new int[V];
        visited = new boolean[V];
        Arrays.fill(costs,5000000);
        costs[0] = 0;
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
        heap.add(new Pair(0,0));
        Pair p;
        while (!heap.isEmpty())
        {
            p = heap.poll();
            if (visited[p.j]) continue;
            visited[p.j] = true;
            costs[p.j] = p.wt;
            for (ArrayList<Integer> adjNode : adj.get(p.j))
            {
                if (!visited[adjNode.get(0)])
                {
                    heap.add(new Pair(adjNode.get(0),adjNode.get(1)));
                }
            }
        }
        
        return sum(costs);
    }
    
    private static int sum(int[] c)
    {
        int result = 0;
        for (int val : c)
            result += val;
        return result;
    }
}

class Pair implements Comparable<Pair>
{
    int j;
    int wt;
    Pair(int j, int wt)
    {
        this.j = j;
        this.wt = wt;
    }
    
    @Override
    public int compareTo(Pair p)
    {
        return this.wt-p.wt;
    }
}
