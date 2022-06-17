/*https://leetcode.com/problems/find-eventual-safe-states/*/

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < N; ++i)
            if (dfs(i, color, graph))
                ans.add(i);
        return ans;
    }

    public boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0)
            return color[node] == 2; //if 2, no cycle, so return true

        color[node] = 1; // entry color is 1
        for (int nei: graph[node]) { //for each neighbour of the current node
            if (color[nei] == 2) //if color is 2
                continue; //continue
            if (color[nei] == 1 || !dfs(nei, color, graph)) //if color is 1 or dfs from neighbour is false, return false
                return false;
        }

        color[node] = 2; //exit color is 2
        return true;
    }
}