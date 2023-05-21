/*https://leetcode.com/problems/largest-color-value-in-a-directed-graph/*/

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int N = colors.length();
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges)
            graph.computeIfAbsent(edge[0],k->new ArrayList<Integer>()).add(edge[1]);
        int[][] count = new int[N][26];
        boolean[] visited = new boolean[N], inStack = new boolean[N];
        int result = 0;
        for (int i = 0; i < N; ++i)
            result = Math.max(result,dfs(i, colors, graph, count, visited, inStack));
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    private int dfs(int node, String colors, Map<Integer, List<Integer>> graph,
                    int[][] count, boolean[] visited, boolean[] inStack)
    {
        if (inStack[node]) return Integer.MAX_VALUE; // Cycle
        
        if (visited[node]) return count[node][colors.charAt(node)-'a'];
        
        visited[node] = true;
        inStack[node] = true;
        
        if (graph.containsKey(node))
        {
            for (Integer neighbor : graph.get(node))
            {
                if (dfs(neighbor, colors, graph, count, visited, inStack) == Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                for (int i = 0; i < 26; ++i)
                    count[node][i] = Math.max(count[node][i],count[neighbor][i]);
            }
        }
        
        ++count[node][colors.charAt(node)-'a'];
        inStack[node] = false;
        return count[node][colors.charAt(node)-'a'];
    }
}

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int N = colors.length();
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[N];
        for (int[] edge : edges)
        {
            graph.computeIfAbsent(edge[0],k->new ArrayList<Integer>()).add(edge[1]);
            ++indegree[edge[1]];
        }
        int[][] count = new int[N][26];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < N; ++i)
            if (indegree[i] == 0)
                queue.offer(i);
        int result = 1, nodesSeen = 0;
        while (!queue.isEmpty())
        {
            int node = queue.poll();
            result = Math.max(result,++count[node][colors.charAt(node)-'a']);
            ++nodesSeen;
            if (!graph.containsKey(node)) continue;
            for (int neighbor : graph.get(node))
            {
                for (int i = 0; i < 26; ++i)
                    count[neighbor][i] = Math.max(count[neighbor][i],count[node][i]);
                --indegree[neighbor];
                if (indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        return nodesSeen < N ? -1 : result;
    }
}