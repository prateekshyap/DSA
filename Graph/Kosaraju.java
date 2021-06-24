/*https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1/*/

class Solution
{
    Stack<Integer> stack;
    boolean[] visited;
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        stack = new Stack<Integer>();
        visited = new boolean[v];

        //run standard DFS with TRUE indicator
        for (int i = 0; i < v; ++i)
            if (!visited[i])
            {
                visited[i] = true;
                runDFS(adj,i,true);
            }

        //reverse all the edges
        ArrayList<ArrayList<Integer>> revAdj = reverseEdges(adj,v);

        visited = new boolean[v];
        int count = 0;
        
        //till the stack has more nodes
        while (!stack.isEmpty())
        {
            //if the node is already visited then skip
            int node = stack.pop();
            if (visited[node]) continue;

            //increment the components count
            ++count;

            //run standard DFS with FALSE indicator
            visited[node] = true;
            runDFS(revAdj,node,false);
        }

        return count;
    }

    public ArrayList<ArrayList<Integer>> reverseEdges(ArrayList<ArrayList<Integer>> adj, int v)
    {
        //create a new adjacency list
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<ArrayList<Integer>>();
        
        //add blank lists
        for (int i = 0; i < v; ++i)
            revAdj.add(new ArrayList<Integer>());
        
        //for every source vertex
        for (int i = 0; i < v; ++i)
        {
            //get the destinations
            ArrayList<Integer> old = adj.get(i);
            /*
            add the source as the destinations for all destinations
            this ensures that the edges are reversed*/
            for (int j = 0; j < old.size(); ++j)
                revAdj.get(old.get(j)).add(i);
        }

        return revAdj;
    }

    public void runDFS(ArrayList<ArrayList<Integer>> adj, int src, boolean stackOp)
    {
        for (Integer adjacentNode : adj.get(src))
        {
            if (!visited[adjacentNode])
            {
                visited[adjacentNode] = true;
                runDFS(adj,adjacentNode,stackOp);
            }
        }
        /*
        if the indicator is true then only add the node to stack
        this ensures finish time insertion order*/
        if (stackOp) stack.push(src);
    }
}