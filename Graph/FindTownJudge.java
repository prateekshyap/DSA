/*https://leetcode.com/problems/find-the-town-judge/*/

//adjacency matrix
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] graph = new int[n][n];
        for (int[] edge : trust)
            graph[edge[0]-1][edge[1]-1] = 1;
        int result = -1;
        for (int i = 0; i < n; ++i)
        {
            boolean findJudge = true;
            for (int j = 0; j < n; ++j)
                if (i != j && graph[j][i] == 0)
                    findJudge = false;
            if (findJudge)
            {
                boolean verify = true;
                for (int j = 0; j < n; ++j)
                    if (graph[i][j] == 1)
                        verify = false;
                if (verify) return i+1;
            }
        }
        return -1;
    }
}

//adjacency list
class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>> in = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; ++i)
        {
            in.add(new ArrayList<Integer>());
            out.add(new ArrayList<Integer>());
        }
        for (int[] edge : trust)
        {
            in.get(edge[0]-1).add(edge[1]-1);
            out.get(edge[1]-1).add(edge[0]-1);
        }
        for (int i = 0; i < n; ++i)
        {
            ArrayList<Integer> findJudge = out.get(i);
            ArrayList<Integer> verify = in.get(i);
            if (findJudge.size() == n-1 && verify.size() == 0)
                return i+1;
        }
        return -1;
    }
}