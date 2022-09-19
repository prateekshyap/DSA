/*https://leetcode.com/problems/smallest-string-with-swaps/*/

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parents = IntStream.rangeClosed(0, n-1).toArray();
        int[] rank = new int[n];
        
        for (List<Integer> pair : pairs)
            union(parents,rank,pair.get(0),pair.get(1));
        
        boolean[] visited = new boolean[n];
        char[] arr = s.toCharArray();
        Map<Integer,List<Integer>> components = new HashMap<Integer,List<Integer>>();
        for (int i = 0; i < n; ++i)
        {
            int parent = find(parents,i);
            components.putIfAbsent(parent,new ArrayList<Integer>());
            components.get(parent).add(i);
        }
        for (Map.Entry entry : components.entrySet())
        {
            List<Integer> component = (List)entry.getValue();
            int[] freqs = new int[26];
            for (Integer node : component)
                ++freqs[arr[node]-'a'];
            int index = 0;
            while (freqs[index] == 0) ++index;
            for (Integer node : component)
            {
                // System.out.println(index+" "+node);
                arr[node] = (char)(index+'a');
                --freqs[index];
                while (index < 26 && freqs[index] == 0) ++index;
            }
        }
        return new String(arr);
    }
    private void union(int[] p, int[] r, int x, int y)
    {
        int px = find(p,x);
        int py = find(p,y);
        
        if (px != py)
        {
            if (r[px] > r[py])
                p[py] = px;
            else
            {
                p[px] = py;
                if (r[px] == r[py])
                    ++r[py];
            }
        }
    }
    private int find(int[] p, int x)
    {
        if (p[x] == x) return x;
        p[x] = find(p,p[x]);
        return p[x];
    }
}

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
        for (List<Integer> pair : pairs)
        {
            int x = pair.get(0), y = pair.get(1);
            graph.putIfAbsent(x,new ArrayList<Integer>());
            graph.putIfAbsent(y,new ArrayList<Integer>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> components = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i)
            if (!visited[i])
            {
                List<Integer> component = new ArrayList<Integer>();
                dfs(graph,visited,component,i);
                Collections.sort(component);
                components.add(component);
            }
        // System.out.println(components);
        char[] arr = s.toCharArray();
        for (List<Integer> component : components)
        {
            int[] freqs = new int[26];
            for (Integer node : component)
                ++freqs[arr[node]-'a'];
            int index = 0;
            while (freqs[index] == 0) ++index;
            for (Integer node : component)
            {
                // System.out.println(index+" "+node);
                arr[node] = (char)(index+'a');
                --freqs[index];
                while (index < 26 && freqs[index] == 0) ++index;
            }
        }
        return new String(arr);
    }
    
    private void dfs(Map<Integer,List<Integer>> graph, boolean[] visited, List<Integer> component, int src)
    {
        visited[src] = true;
        component.add(src);
        
        for (Integer adjNode : graph.getOrDefault(src,new ArrayList<Integer>()))
            if (!visited[adjNode])
                dfs(graph,visited,component,adjNode);
    }
}