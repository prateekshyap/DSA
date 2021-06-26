/*https://practice.geeksforgeeks.org/problems/strongly-connected-component-tarjanss-algo-1587115621/1/*/

class Solution
{
    int[] discovery, low;
    boolean[] added;
    Stack<Integer> stack;
    ArrayList<ArrayList<Integer>> result;
    int timer = 1;
    
    public void runDFS(int i, ArrayList<ArrayList<Integer>> adj)
    {
        discovery[i] = timer++;
        low[i] = discovery[i];
        added[i] = true;
        stack.push(i);

        //for all the adjacent nodes
        for (Integer adjacentNode : adj.get(i))
        {
            //if the node is not visited
            if (discovery[adjacentNode] == 0)
            {
                //run DFS
                runDFS(adjacentNode,adj);

                //set the low value
                low[i] = Math.min(low[i],low[adjacentNode]);
            }

            //otherwise set the low value
            else if (added[adjacentNode])
            {
                low[i] = Math.min(low[i],discovery[adjacentNode]);
            }
        }
        
        //make the current component list, sort and add it to the result
        int popped = -1; 
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (low[i] == discovery[i])
        {
            while (popped != i)
            { 
                popped = (int)stack.pop();
                list.add(popped);
                added[popped] = false;
            }
            Collections.sort(list);
            result.add(list);
        }
    }
    
    public ArrayList<ArrayList<Integer>> tarjans(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        //initialization
        discovery = new int[v];
        low = new int[v];
        added = new boolean[v];
        stack = new Stack<Integer>();
        result = new ArrayList<ArrayList<Integer>>();
        
        //run DFS for every unvisited vertex
        for (int i = 0; i < v; ++i)
        {
            if (discovery[i] == 0)
                runDFS(i,adj);
        }
        
        //sort and return the result
        Collections.sort(result,new Comparator<ArrayList<Integer>>()
        {
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2)
            {
                return l1.get(0)-l2.get(0);
            }
        });
        return result;
    }
}