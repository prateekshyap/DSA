/*https://leetcode.com/problems/network-delay-time/*/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> graph = new ArrayList<List<List<Integer>>>();
        int[] pathCosts = new int[n];
        boolean[] checkedVertices = new boolean[n];
        int i;
        for (i = 0; i < n; ++i)
            graph.add(new ArrayList<List<Integer>>());
        for (i = 0; i < times.length; ++i)
        {
            List<Integer> edge = new ArrayList<Integer>();
            edge.add(times[i][1]-1);
            edge.add(times[i][2]);
            graph.get(times[i][0]-1).add(edge);
        }
        
        //initialize all path costs to infinity except the source
        for (i = 0; i < n; ++i)
            if (i != k-1)
                pathCosts[i] = Integer.MAX_VALUE;
                
        for (int count = 1; count < n; ++count)
        {
            //extract minimum from the unchecked vertices and mark it checked
            int minVertex = getMinVertex(pathCosts, checkedVertices, n);
            if (minVertex == -1) break;
            checkedVertices[minVertex] = true;

            //get the adjacent nodes
            List<List<Integer>> adjacentNodes = graph.get(minVertex);
            
            //relax all the adjacent edges
            for (List<Integer> edge : adjacentNodes)
                pathCosts = relaxEdge(pathCosts, minVertex, (Integer)edge.get(0), (Integer)edge.get(1));
        }
        int max = 0;
        for (i = 0; i < n; ++i)
            if (pathCosts[i] > max)
                max = pathCosts[i];
        return max == Integer.MAX_VALUE ? -1 : max;
    }
    
    public int getMinVertex(int[] costs, boolean[] checked, int V)
    {
        int minValue = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < V; ++i)
            if (!checked[i] && costs[i] < minValue)
            {
                minValue = costs[i];
                index = i;
            }
        return index;
    }
    
    public int[] relaxEdge(int[] pathCosts, int source, int destination, int weight)
    {
    	//update the path cost
        if (pathCosts[destination] > pathCosts[source]+weight)
            pathCosts[destination] = pathCosts[source]+weight;
        return pathCosts;
    }
}