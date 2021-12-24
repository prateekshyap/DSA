/*https://www.hackerrank.com/challenges/journey-to-the-moon/problem*/

class Result {
    static boolean[] visited;
    static int visitCount;
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
    	//create a graph from the given astronaut data
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        for (List<Integer> edge : astronaut)
        {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        //find the sizes of the connected components
        visited = new boolean[n];
        visitCount = 0;
        ArrayList<Integer> components = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                int prevCount = visitCount;
                visited[i] = true;
                ++visitCount;
                runDFS(graph,i);
                components.add(visitCount-prevCount);
            }
        }

        /*
		The whole idea is- 
        since we cannot add the edges from the same component
		i.e. we cannot send two astronauts from the same country
		so if we can find out the number of edges
        that belong to the same country
		and subtract that number from
        the total possible number of edges for n astronauts
        the remaining number will be the total number of edges
        that cross through the components, which is the answer
        */
        int sumEdges = 0;
        for (int i = 0; i < components.size(); ++i)
        {
            int size = (Integer)components.get(i);
            sumEdges += size*(size-1)/2;
        }
        return ((long)n*(long)(n-1)/2)-sumEdges;
    }

    public static void runDFS(ArrayList<ArrayList<Integer>> graph, int src)
    {
        for (Integer adjacentNode : graph.get(src))
        {
            if (!visited[adjacentNode])
            {
                visited[adjacentNode] = true;
                ++visitCount;
                runDFS(graph,adjacentNode);
            }
        }
    }
}