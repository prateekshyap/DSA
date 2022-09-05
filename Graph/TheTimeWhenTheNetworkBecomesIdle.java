/*https://leetcode.com/problems/the-time-when-the-network-becomes-idle/*/

class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int N = patience.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; ++i)
            graph.add(new ArrayList<Integer>());
        for (int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // System.out.println(graph);
        int[] shortestPaths = new int[N];
        Arrays.fill(shortestPaths,(int)1e5+1);
        shortestPaths[0] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        boolean[] visited = new boolean[N];
        while (!queue.isEmpty())
        {
            int qLen = queue.size();
            while (qLen-- > 0)
            {
                int node = queue.poll();
                visited[node] = true;
                for (Integer adjNode : graph.get(node))
                {
                    if (!visited[adjNode])
                    {
                        shortestPaths[adjNode] = Math.min(shortestPaths[adjNode],shortestPaths[node]+1);
                        queue.add(adjNode);
                    }
                }
            }
        }
        
        int maxTime = 0;
        for (int i = 1; i < N; ++i)
        {
            shortestPaths[i] *= 2;
            int messages= shortestPaths[i]%patience[i] == 0 ? shortestPaths[i]/patience[i] : shortestPaths[i]/patience[i]+1;
            if (messages > 1)
            {
                int lastgentime = patience[i]*(messages-1);
                int lastrectime = lastgentime+shortestPaths[i];
                maxTime = Math.max(maxTime,lastrectime);
            }
            else
                maxTime = Math.max(maxTime,shortestPaths[i]);
        }
        return maxTime+1;
    }
}