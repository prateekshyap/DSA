/*https://leetcode.com/problems/find-closest-node-to-given-two-nodes/*/

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
    	//build the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int n = edges.length, i, max = 0;
        for (i = 0; i < n; ++i)
        {
            if (edges[i] > max) max = edges[i];
            if (i > max) max = i;
        }
        n = max+1;
        for (i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        for (i = 0; i < edges.length; ++i)
            if (edges[i] != -1)
                graph.get(i).add(edges[i]);

        HashMap<Integer,Integer> dists = new HashMap<Integer,Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        //BFS
        queue.add(node1); //add 1st node to queue
        boolean[] visited = new boolean[n]; //reinitialize visited
        int node, distance = 0, len;
        while (!queue.isEmpty()) //till queue becomes empty
        {
            len = queue.size(); //get the queue size
            for (i = 0; i < len; ++i) //for each node in queue
            {
                node = queue.poll(); //get the node
                if (visited[node]) continue; //if already visited, continue
                visited[node] = true; //mark as visited
                dists.put(node,distance); //add the distance from node1 to current node in map
                for (Integer adjNode : graph.get(node)) //for each adjacent node of current node
                    queue.add(adjNode); //add to queue
            }
            ++distance; //increment distance for next level
        }

        //BFS again
        visited = new boolean[n]; //reinitialize visited
        distance = 0; //reset distance
        int min = Integer.MAX_VALUE, minNode = -1, dist1, dist2;
        queue.add(node2); //add 2nd node to queue
        while (!queue.isEmpty()) //till queue becomes empty
        {
            len = queue.size(); //get the queue size
            for (i = 0; i < len; ++i) //for each node in queue
            {
                node = queue.poll(); //get the node
                if (visited[node]) continue; //if already visited, continue
                visited[node] = true; //mark as visited
                for (int adjNode : graph.get(node)) //for each adjacent node of current node
                    queue.add(adjNode); //add to queue
                if (!dists.containsKey(node)) continue; //if map doesn't contain the current node, continue
                dist1 = dists.get(node); //distance of current node from node1
                dist2 = distance; //distance of current node from node2
                if (Math.max(dist1,dist2) < min) //if their maximum is less than the result
                {
                    min = Math.max(dist1,dist2); //update result
                    minNode = node; //update resulting node
                }
                else if (Math.max(dist1,dist2) == min) //if their maximum is same as result
                {
                    minNode = Math.min(minNode,node); //update resulting node
                }
            }
            ++distance; //increment distance
        }
        return minNode; //return resulting node
    }
}

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] arr1 = fillDist(edges, node1);
        int[] arr2 = fillDist(edges, node2);
        
        int result = -1;
        int max = edges.length;
        int val;
        
        for (int i = 0; i < arr1.length; ++i)
        {
           if (arr1[i] == -1 || arr2[i] == -1)
               continue;
            
            val = Math.max(arr1[i], arr2[i]);
            
            if (val < max )
            {
                result = i;
                max = val;
            }
        }
        
        return result;
    }
    
    private int[] fillDist(int[] edges, int node)
    {
        int[] result = new int[edges.length];
        
        Arrays.fill(result, -1);
        
        int current = node;
        int count = 0;
        
        while (current != -1 && result[current] == -1)
        {
            result[current] = count++;
            current = edges[current];
        }
        
        return result;
    }
}