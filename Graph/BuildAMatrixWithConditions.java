/*https://leetcode.com/problems/build-a-matrix-with-conditions/*/

class Solution {
    int[] color;
    int V;
    
    // Function to detect cycle in a directed graph.
    private boolean isCyclic(int V, ArrayList<LinkedHashSet<Integer>> adj)
    {
        // code here
        color = new int[V];
        this.V = V;
        for (int i = 0; i < V; ++i) if (color[i] == 0 && dfs(adj, i)) return true;
        return false;
    }
    
    private boolean dfs(ArrayList<LinkedHashSet<Integer>> graph, int src)
    {
        color[src] = 1;
        
        for (int adjNode : graph.get(src))
        {
            if (color[adjNode] == 1)
                return true;
            if (color[adjNode] == 0)
                if (dfs(graph,adjNode))
                    return true;
        }
        
        color[src] = 2;
        return false;
    }
    private int[] topoSort(int V, ArrayList<LinkedHashSet<Integer>> adj) 
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] hash = new int[V];
        int[] result = new int[V];
        int index = 0;

        //for every vertex
        for (int i = 0; i < V; ++i)
        {
        	//for every edge starting from the ith vertex
            for (Integer dest : adj.get(i))
            	//increment the counter at destination
                ++hash[dest];
        }

        //find the vertex which has count 0 and add to the queue
        for (int i = 0; i < V; ++i)
            if (hash[i] == 0)
                queue.add(i);

        //till exhausted
        while (!queue.isEmpty())
        {
        	//remove the front and store in the result
            result[index] = queue.remove();

            //for every destination of the removed vertex
            for (Integer dest : adj.get(result[index]))
            {
            	//decrement the count
                --hash[dest];

                //if count becomes 0, add it to the queue
                if (hash[dest] == 0)
                    queue.add(dest);
            }

            ++index;
        }
        
        return result;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<LinkedHashSet<Integer>> upDown = new ArrayList<>(), leftRight = new ArrayList<>();
        int i;
        for (i = 0; i <= k; ++i)
        {
            upDown.add(new LinkedHashSet<Integer>());
            leftRight.add(new LinkedHashSet<Integer>());
        }
        int[][] result = new int[k][k];
        for (int[] row : rowConditions)
            upDown.get(row[0]).add(row[1]);
        for (int[] col : colConditions)
            leftRight.get(col[0]).add(col[1]);
        boolean isCyclePresent = isCyclic(k+1,upDown);
        if (isCyclePresent) return new int[0][0];
        isCyclePresent |= isCyclic(k+1,leftRight);
        if (isCyclePresent) return new int[0][0];
        int[] upDownTopoSort = topoSort(k+1,upDown);
        int[] leftRightTopoSort = topoSort(k+1,leftRight);
        int[] hash = new int[k+1];
        for (i = 1; i <= k; ++i)
            result[0][i-1] = leftRightTopoSort[i];
        for (i = 0; i < k; ++i)
            hash[result[0][i]] = i;
        int row = k-1, index;
        for (i = k; i >= 1; --i)
        {
            index = hash[upDownTopoSort[i]];
            result[0][index] = 0;
            result[row][index] = upDownTopoSort[i];
            --row;
        }
        return result;
    }
}

