/*https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/*/

class Solution {
    public boolean isPossible(int N, int[][] prerequisites)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] hash = new int[N];
        int[] result = new int[N];
        int index = 0;
        
        //create a graph from the given data
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; ++i)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; ++i)
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);

        //for every vertex
        for (int i = 0; i < prerequisites.length; ++i)
        	//increment the counter at destination
            ++hash[prerequisites[i][0]];

        //find the vertex which has count 0 and add to the queue
        for (int i = 0; i < N; ++i)
            if (hash[i] == 0)
                queue.add(i);

        //till exhausted
        while (!queue.isEmpty())
        {
        	//remove the front and store in the result
            result[index] = queue.remove();

            //for every destination of the removed vertex
            for (Integer dest : graph.get(result[index]))
            {
            	//decrement the count
                --hash[dest];

                //if count becomes 0, add it to the queue
                if (hash[dest] == 0)
                    queue.add(dest);
            }
            
            ++index;
        }
        
        return index == result.length ? true : false;
    }
}