/*https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/*/

//articulation point on a newly built graph
class Solution {
    int timer, R, C;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[] disc, low;
    boolean[] isArticulationPoint;
    int index;
    Map<String,Integer> map;
    public int minDays(int[][] grid) {
        int i, j, count = 0;
        R = grid.length;
        C = grid[0].length;
        index = 0;
        map = new HashMap<String,Integer>();
        for (i = 0; i < R; ++i) //for each row
            for (j = 0; j < C; ++j) //for each column
                if (grid[i][j] == 1) //if cell is a land
                {
                    if (count == 1) return 0; //if another island already found, return 0
                    dfs(grid,i,j); //run dfs
                    ++count; //increment island count
                }
        if (count == 0) return 0; //if no islands found, return 0
        // System.out.println(map);
        Map<Integer,Set<Integer>> graph = new HashMap<Integer,Set<Integer>>();
        
        int row, col, r, c;
        String key;
        StringBuilder adjKey;
        Integer value, adjValue;
        String[] tokens;
        for (Map.Entry entry : map.entrySet()) //for each entry in the map
        {
            key = (String)entry.getKey();
            value = (Integer)entry.getValue();
            tokens = key.split("[,]");
            row = Integer.parseInt(tokens[0]); //row value
            col = Integer.parseInt(tokens[1]); //column value
            if (!graph.containsKey(value))
                graph.put(value,new HashSet<Integer>());
            for (i = 0; i < 4; ++i) //for each direction
            {
                r = row+dirs[i][0];
                c = col+dirs[i][1];
                if (r >= 0 && r < R && c >= 0 && c < C && grid[r][c] == 2) //if adjacent node is feasible
                {
                	//build key
                    adjKey = new StringBuilder("");
                    adjKey.append(r);
                    adjKey.append(",");
                    adjKey.append(c);
                    // adjKey = r+","+c;
                    adjValue = map.get(adjKey.toString()); //get node index
                    if (!graph.containsKey(adjValue))
                        graph.put(adjValue,new HashSet<Integer>());
                    //add edge to graph
                    graph.get(value).add(adjValue);
                    graph.get(adjValue).add(value);
                }
            }
        }
        // System.out.println(graph);
        int N = graph.size();
        disc = new int[N];
        low = new int[N];
        isArticulationPoint = new boolean[N];
        timer = 1;
        findArticulationPoints(graph,0,-1); //find all articulation points
        for (boolean found : isArticulationPoint)
            if (found)
                return 1;
        // for (i = 0; i < N; ++i)
        //     System.out.println(i+" "+disc[i]+" "+low[i]+" "+isArticulationPoint[i]);
        return 2;
    }
    private void findArticulationPoints(Map<Integer,Set<Integer>> graph, int src, int parent) //standard function to find articulation points
    {
        disc[src] = timer++;
        low[src] = disc[src];
        int children = 0;
        
        for (Integer adjNode : graph.get(src))
        {
            if (disc[adjNode] == 0)
            {
                ++children;
                findArticulationPoints(graph,adjNode,src);
                low[src] = Math.min(low[src],low[adjNode]);
                if (parent != -1 && low[adjNode] >= disc[src])
                    isArticulationPoint[src] = true;
            }
            else if (parent != -1)
                low[src] = Math.min(low[src],disc[adjNode]);
        }
        
        if (parent == -1 && children != 1)
            isArticulationPoint[src] = true;
    }
    private void dfs(int[][] grid, int row, int col) //standard function for dfs
    {
        grid[row][col] = 2; //mark cell as visited
        //build a key
        StringBuilder key = new StringBuilder("");
        key.append(row);
        key.append(",");
        key.append(col);
        map.put(key.toString(),index++); //add a new node index to the cell
        int r, c;
        for (int i = 0; i < 4; ++i) //for each direction
        {
            r = row+dirs[i][0];
            c = col+dirs[i][1];
            if (r >= 0 && r < R && c >= 0 && c < C && grid[r][c] == 1) //if adjacent node is feasible
                dfs(grid,r,c); //run dfs
        }
    }
}

//articulation point on the same matrix
class Solution {
    int timer, R, C;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][] disc, low;
    boolean[][] isArticulationPoint;
    int index;
    Map<String,Integer> map;
    public int minDays(int[][] grid) {
        int i, j, count = 0;
        R = grid.length;
        C = grid[0].length;
        index = 0;
        map = new HashMap<String,Integer>();
        for (i = 0; i < R; ++i)
            for (j = 0; j < C; ++j)
                if (grid[i][j] == 1)
                {
                    if (count == 1) return 0;
                    dfs(grid,i,j);
                    ++count;
                }
        if (count == 0) return 0;

        disc = new int[R][C];
        low = new int[R][C];
        isArticulationPoint = new boolean[R][C];
        timer = 1;
        boolean done = false;
        for (i = 0; i < R; ++i)
            for (j = 0; j < C; ++j)
                if (grid[i][j] == 2)
                {
                    if (findArticulationPoints(grid,i,j,-1,-1)) return 1;
                    else return 2;
                }
        return 2;
    }
    private boolean findArticulationPoints(int[][] graph, int row, int col, int parRow, int parCol)
    {
        int r, c;
        disc[row][col] = timer++;
        low[row][col] = disc[row][col];
        int children = 0;
        
        for (int i = 0; i < 4; ++i)
        {
            r = row+dirs[i][0];
            c = col+dirs[i][1];
            if (r >= 0 && r < R && c >= 0 && c < C && graph[r][c] == 2 && disc[r][c] == 0)
            {
                ++children;
                if (findArticulationPoints(graph,r,c,row,col)) return true;
                low[row][col] = Math.min(low[row][col],low[r][c]);
                if (parRow != -1 && low[r][c] >= disc[row][col])
                    return true;
            }
            else if (r >= 0 && r < R && c >= 0 && c < C && graph[r][c] == 2 && disc[r][c] != 0 && parRow != -1)
                low[row][col] = Math.min(low[row][col],disc[r][c]);
        }
        
        if (parRow == -1 && children != 1)
            return true;
        return false;
    }
    private void dfs(int[][] grid, int row, int col)
    {
        grid[row][col] = 2;
        int r, c;
        for (int i = 0; i < 4; ++i)
        {
            r = row+dirs[i][0];
            c = col+dirs[i][1];
            if (r >= 0 && r < R && c >= 0 && c < C && grid[r][c] == 1)
                dfs(grid,r,c);
        }
    }
}