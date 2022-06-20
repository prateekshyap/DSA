/*https://leetcode.com/problems/all-paths-from-source-to-target/*/

class Solution {
    List<List<Integer>> list;
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        list = new ArrayList<List<Integer>>();
        dfs(graph,0,new ArrayList<Integer>());
        return list;
    }
    public void dfs(int[][] graph, int source, List<Integer> currPath)
    {
        currPath.add(source);
        if (graph[source].length == 0)
        {
            List<Integer> temp = new ArrayList<Integer>(currPath);
            if (temp.get(0) == 0 && temp.get(temp.size()-1) == n-1) list.add(temp);
            currPath.remove(currPath.size()-1);
            return;
        }
        for (int adjNode : graph[source])
            dfs(graph,adjNode,currPath);
        if (currPath.get(0) == 0 && currPath.get(currPath.size()-1) == n-1) list.add(new ArrayList<Integer>(currPath));
        currPath.remove(currPath.size()-1);
    }
}