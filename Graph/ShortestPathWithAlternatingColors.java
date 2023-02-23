/*https://leetcode.com/problems/shortest-path-with-alternating-colors/*/

class Path
{
    int node;
    int edgeColor; //0 = red, 1 = blue, 2 = nothing
    Path(int node, int color)
    {
        this.node = node;
        this.edgeColor = color;
    }
    @Override
    public String toString()
    {
        return "("+this.node+" "+this.edgeColor+")";
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] result = new int[n];
        Arrays.fill(result,-1);
        
        List<List<Path>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<Path>());
        for (int[] edge : redEdges)
            graph.get(edge[0]).add(new Path(edge[1],0));
        for (int[] edge : blueEdges)
            graph.get(edge[0]).add(new Path(edge[1],1));
        
        // System.out.println(graph);
        boolean[][] visited = new boolean[2][n];
        Queue<int[]> queue = new LinkedList<>(); // node, edge color, steps
        queue.add(new int[]{0,2,0});
        visited[0][0] = visited[1][0] = true;
        result[0] = 0;
        while (!queue.isEmpty())
        {
            int[] node = queue.poll();
            for (Path adjNode : graph.get(node[0]))
            {
                if (node[1] != 0 && visited[0][adjNode.node] == false && adjNode.edgeColor == 0)
                {
                    queue.add(new int[]{adjNode.node,0,node[2]+1});
                    if (result[adjNode.node] == -1) result[adjNode.node] = node[2]+1;
                    visited[0][adjNode.node] = true;
                }
                else if (node[1] != 1 && visited[1][adjNode.node] == false && adjNode.edgeColor == 1)
                {
                    queue.add(new int[]{adjNode.node,1,node[2]+1});
                    if (result[adjNode.node] == -1) result[adjNode.node] = node[2]+1;
                    visited[1][adjNode.node] = true;
                }
            }
        }
        return result;
    }
}