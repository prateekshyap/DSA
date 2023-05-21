/*https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/*/

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<>());
        for (int[] road : roads)
        {
            graph.get(road[0]-1).add(Arrays.asList(road[1]-1,road[2]));
            graph.get(road[1]-1).add(Arrays.asList(road[0]-1,road[2]));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        int minEdge = Integer.MAX_VALUE;
        while (!queue.isEmpty())
        {
            int node = queue.poll();
            if (visited[node]) continue;
            visited[node] = true;
            for (List<Integer> adjNode : graph.get(node))
            {
                if (!visited[adjNode.get(0)])
                {
                    minEdge = Math.min(minEdge,adjNode.get(1));
                    queue.add(adjNode.get(0));
                }
            }
        }
        return minEdge;
    }
}