/*https://leetcode.com/problems/similar-string-groups/*/

class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        /*
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; ++i)
        {
            for (int j = i+1; j < n; ++j)
            {
                if (isSimilar(strs[i], strs[j]))
                {
                    graph.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                    graph.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (!visited[i])
            {
                // dfs(i, graph, visited);
                bfs(i, graph, visited);
                ++count;
            }
        */
        int count = n;
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) parent[i] = i;
        int[] rank = new int[n];
        for (int i = 0; i < n; ++i)
        {
            for (int j = i+1; j < n; ++j)
            {
                if (isSimilar(strs[i], strs[j]) && find(i, parent, rank) != find(j, parent, rank))
                {
                    --count;
                    union(i, j, parent, rank);
                }
            }
        }
        return count;
    }
    public int find(int x, int[] parent, int[] rank)
    {
        if (parent[x] != x)
             parent[x] = find(parent[x], parent, rank);
        return parent[x];
    }
    public void union(int x, int y, int[] parent, int[] rank)
    {
        int xSet = find(x, parent, rank), ySet = find(y, parent, rank);
        if (xSet == ySet) return;
        else if (rank[xSet] < rank[ySet])
            parent[xSet] = ySet;
        else if (rank[xSet] > rank[ySet])
            parent[ySet] = xSet;
        else
        {
            parent[ySet] = xSet;
            ++rank[xSet];
        }
    }
    public void bfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty())
        {
            node = queue.poll();
            if (!graph.containsKey(node))
                continue;
            for (int neighbor : graph.get(node))
                if (!visited[neighbor])
                {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
        }
    }
    public void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited)
    {
        visited[node] = true;
        if (!graph.containsKey(node))
            return;
        
        for (int neighbor : graph.get(node))
        {
            if (!visited[neighbor])
            {
                visited[neighbor] = true;
                dfs(neighbor, graph, visited);
            }
        }
    }
    public boolean isSimilar(String a, String b)
    {
        int diff = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) != b.charAt(i))
                ++diff;
        return diff == 0 || diff == 2;
    }
}

class Solution {
    public int numSimilarGroups(String[] strs) {
        int ans = 0;
    boolean[] seen = new boolean[strs.length];

    for (int i = 0; i < strs.length; ++i)
      if (!seen[i]) {
        dfs(strs, i, seen);
        ++ans;
      }

    return ans;
        
    }

    private void dfs(final String[] strs, int i, boolean[] seen) {
    seen[i] = true;
    for (int j = 0; j < strs.length; ++j)
      if (!seen[j] && isSimilar(strs[i], strs[j]))
        dfs(strs, j, seen);
  }

  private boolean isSimilar(final String X, final String Y) {
    int diff = 0;
    for (int i = 0; i < X.length(); ++i)
      if (X.charAt(i) != Y.charAt(i) && ++diff > 2)
        return false;
    return true;
  }
}