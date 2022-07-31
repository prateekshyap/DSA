/*https://practice.geeksforgeeks.org/problems/number-of-provinces/1*/
/*https://leetcode.com/problems/number-of-provinces/*/

//simple BFS
//adj is not adjacency list, it is adjacency matrix
class Solution {
    static boolean[] visited;
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        visited = new boolean[V];
        int counter = 0, currNode = -1, j = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < V; ++i)
        {
            if (!visited[i])
            {
                ++counter;
                queue.add(i);
                while (!queue.isEmpty())
                {
                    currNode = queue.poll();
                    if (visited[currNode]) continue;
                    visited[currNode] = true;
                    for (j = 0; j < V; ++j)
                    {
                        if (currNode != j && (Integer)adj.get(currNode).get(j) == 1 && !visited[j])
                            queue.add(j);
                    }
                }
            }
        }
        return counter;
    }
};

//disjoint set solution
class Solution {
    HashSet<Integer> set;
    public int findCircleNum(int[][] isConnected) {
        int i, j, V = isConnected.length;
        int[] parent = new int[V];
        set = new HashSet<Integer>();
        for (i = 0; i < V; ++i)
        {
            parent[i] = i;
            set.add(i);
        }
        
        for (i = 0; i < V; ++i)
            for (j = 0; j < V; ++j)
                if (i != j && isConnected[i][j] == 1)
                    unionAndFind(parent, i, j);
        
        return set.size(); //return the remaining number of parents
    }
    public void unionAndFind(int[] parent, int x, int y)
    {
        int parentX = find(parent,x);
        int parentY = find(parent,y);
        
        if (parentX == parentY) return;
        
        parent[parentX] = parentY; //if parent is changing
        set.remove(parentX); //remove the old parent from the set
    }
    public int find(int[] parent, int node)
    {
        if (parent[node] == node) return node;
        parent[node] = find(parent,parent[node]);
        return parent[node];
    }
}