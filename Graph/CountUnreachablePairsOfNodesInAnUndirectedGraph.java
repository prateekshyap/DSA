/*https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/*/

//dfs approach
class Solution {
    boolean[] visited;
    List<List<Integer>> components;
    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];
        components = new ArrayList<List<Integer>>();
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        int i;
        for (i = 0; i < n; ++i) graph.add(new ArrayList<Integer>());
        for (int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for (i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                Set<Integer> newComponent = new HashSet<Integer>();
                dfs(graph,i,newComponent);
                components.add(new ArrayList<>(newComponent));
            }
        }
        long[] pre = new long[components.size()];
        pre[0] = components.get(0).size();
        for (i = 1; i < pre.length; ++i) pre[i] = pre[i-1]+components.get(i).size();
        long result = 0;
        for (i = 0; i < pre.length-1; ++i)
            result += pre[i]*components.get(i+1).size();
        return result;
    }
    public void dfs(List<List<Integer>> graph, int src, Set<Integer> component)
    {
        visited[src] = true;
        component.add(src);
        
        for (Integer adjNode : graph.get(src))
            if (!visited[adjNode])
                dfs(graph,adjNode,component);
    }
}

//disjoint set solution
class Solution {
    boolean[] visited;
    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];
        DSU dsu = new DSU(n);
        for (int[] edge: edges) {
            dsu.union(edge[0], edge[1]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(dsu.find(i));
        }
        List<Integer> list = new ArrayList<>();
        for (int root: set) {
            list.add(dsu.getComponentSize(root));
        }
        long sum = list.get(0);
        long res = 0;
        for (int i = 1; i < list.size(); i++) {
            res += list.get(i) * sum;
            sum += list.get(i);
        }
        return res;
    }
    public void dfs(List<List<Integer>> graph, int src, Set<Integer> component)
    {
        visited[src] = true;
        component.add(src);
        
        for (Integer adjNode : graph.get(src))
        {
            if (!visited[adjNode])
            {
                dfs(graph,adjNode,component);
            }
        }
    }
}

class DSU {
    private int[] parent;
    private int[] capacity;
    
    public DSU(int n) {
        this.parent = new int[n];
        this.capacity = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            capacity[i] = 1;
        }
    }
    
    public int find(int a) {
        int root = parent[a];
        while (root != parent[root]) root = parent[root];
        while (a != parent[a]) {
            a = parent[a];
            parent[a] = root;
        }
        return root;
    }
    
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        
        if (capacity[rootA] >= capacity[rootB]) {
            capacity[rootA] += capacity[rootB];
            parent[rootB] = rootA;
        } else {
            capacity[rootB] += capacity[rootA];
            parent[rootA] = rootB;
        }
    }
    
    public int getComponentSize(int root) {
        return this.capacity[root];
    }
}