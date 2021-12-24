/*https://practice.geeksforgeeks.org/problems/topological-sort/1*/

class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
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
}
