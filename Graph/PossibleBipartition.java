/*https://leetcode.com/problems/possible-bipartition/*/

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int i, j, currNode;
        for (i = 0; i < n; ++i) graph.add(new ArrayList<Integer>());
        for (int[] dislike : dislikes)
        {
            graph.get(dislike[0]-1).add(dislike[1]-1);
            graph.get(dislike[1]-1).add(dislike[0]-1);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] colors = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(colors,-1);
        for (i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                queue.add(i);
                colors[i] = 1;
                while (!queue.isEmpty())
                {
                    currNode = queue.poll();
                    if (visited[currNode]) continue;
                    visited[currNode] = true;
                    for (Integer adjNode : graph.get(currNode))
                    {
                        if (colors[currNode] == colors[adjNode]) return false;
                        colors[adjNode] = 1-colors[currNode];
                        queue.add(adjNode);
                    }
                }
            }
        }
        return true;
    }
}