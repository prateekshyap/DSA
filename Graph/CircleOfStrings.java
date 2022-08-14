/*https://practice.geeksforgeeks.org/problems/circle-of-strings4530/1*/

class Solution
{
    static int isCircle(int N, String A[])
    {
        int m = 26;
        boolean mark[] = new boolean[m];
        int in[] = new int[26];
        int out[] = new int[26];
         
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < m; i++)
            graph.add(new ArrayList<>());
             
        // Process all strings one by one
        for(int i = 0; i < N; i++)
        {
             
            // Find first and last characters
            int f = (int)(A[i].charAt(0)-'a');
            int l = (int)(A[i].charAt(A[i].length()-1)-'a');
             
            // Mark the characters
            mark[f] = mark[l] = true;
             
            // Increase indegree and outdegree count
            ++in[l];
            ++out[f];
             
            // Add an edge in graph
            graph.get(f).add(l);
        }
         
        // If for any character indegree is not equal to
        // outdegree then ordering is not possible
        for(int i = 0; i < m; i++)
        {
            if (in[i] != out[i])
                return 0;
        }

        return isConnected(graph, mark, A[0].charAt(0)-'a') ? 1 : 0;
    }
    public static boolean isConnected(ArrayList<ArrayList<Integer>> graph, boolean[] mark, int src)
    {
        boolean visited[] = new boolean[26];
         
        // Perform a dfs from src
        dfs(graph, visited, src);

        for(int i = 0; i < 26; i++)
        {
         
            /*
            i character is marked (i.e. it was first or
            last character of some string) then it should
            be visited in last dfs (as for looping, graph
            should be strongly connected)
            */
            if (mark[i] && !visited[i])
                return false;
        }
         
        // If we reach here that means graph is connected
        return true;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int src)
    {
        visited[src] = true;
        for(int i = 0; i < graph.get(src).size(); i++)
            if (!visited[graph.get(src).get(i)])
                dfs(graph, visited, graph.get(src).get(i));
    }
}

class Solution
{
    static int[] parent;
    static int[] rank;
    static int isCircle(int N, String A[])
    {
        // code here
        int i;
        parent = new int[26];
        for (i = 0; i < 26; ++i)
            parent[i] = i;
        rank = new int[26];
        int[] in = new int[26], out = new int[26];
        
        for (String s : A)
        {
            ++in[s.charAt(0)-'a'];
            ++out[s.charAt(s.length()-1)-'a'];
            union(s.charAt(0)-'a',s.charAt(s.length()-1)-'a');
        }
        for (i = 0; i < 26; ++i)
            if (in[i] != out[i])
                return 0;
            
        int count = 0;
        for (i = 0; i < 26; ++i)
            if (in[i] != 0 && out[i] != 0 && parent[i] == i)
                ++count;
                
        return count > 1 ? 0 : 1;
    }
    private static void union(int i, int j)
    {
        int pi = find(i);
        int pj = find(j);
        
        if (pi != pj)
        {
            if (rank[pi] > rank[pj])
            {
                int temp = pi;
                pi = pj;
                pj = temp;
            }
            parent[pi] = pj;
            if (rank[pi] == rank[pj])
                ++rank[pj];
        }
    }
    private static int find(int i)
    {
        if (parent[i] == i) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }
}