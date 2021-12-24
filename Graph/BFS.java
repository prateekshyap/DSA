/*https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1*/

class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[V];

        //add the source to the queue and mark it as visited
        queue.add(0);
        visited[0] = true;
        list.add(0);

        //till the queue has more nodes
        while (!queue.isEmpty())
        {
        	//remove the front node
            int currNode = queue.remove();

            //get all its adjacent nodes
            ArrayList<Integer> adjacentNodes = adj.get(currNode);
            
            //for each adjacent node
            for (Integer adjNode : adjacentNodes)
            {
            	//if it is not visited
                if (!visited[adjNode])
                {
                	//mark it as visited and add to the queue
                    visited[adjNode] = true;
                    queue.add(adjNode);
                    list.add(adjNode);
                }
            }
        }
        
        return list;
    }
}