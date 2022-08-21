/*https://leetcode.com/problems/pacific-atlantic-water-flow/*/

//BFS
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int R = heights.length, C = heights[0].length, r, c, d, row, col;
        int[][] oceanCount = new int[R][C];
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] cell;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //add cells for pacific ocean
        for (r = 0; r < R; ++r)
            queue.add(new int[]{r,0});
        for (c = 0; c < C; ++c)
            queue.add(new int[]{0,c});
        
        while (!queue.isEmpty())
        {
            cell = queue.poll();
            row = cell[0];
            col = cell[1];
            if (oceanCount[row][col] == 1) continue;
            oceanCount[row][col] = 1;
            for (d = 0; d < 4; ++d)
            {
                r = row+dirs[d][0];
                c = col+dirs[d][1];
                
                if (r >= 0 && r < R && c >= 0 && c < C && oceanCount[r][c] == 0 && heights[r][c] >= heights[row][col])
                    queue.add(new int[]{r,c});
            }
        }
        
        //add cells for atlantic ocean
        for (r = 0; r < R; ++r)
            queue.add(new int[]{r,C-1});
        for (c = 0; c < C; ++c)
            queue.add(new int[]{R-1,c});
        
        while (!queue.isEmpty())
        {
            cell = queue.poll();
            row = cell[0];
            col = cell[1];
            oceanCount[row][col] = oceanCount[row][col] == 1 ? 2 : -1;
            if (oceanCount[row][col] == 2)
                result.add(Arrays.asList(row,col));
            for (d = 0; d < 4; ++d)
            {
                r = row+dirs[d][0];
                c = col+dirs[d][1];
                
                if (r >= 0 && r < R && c >= 0 && c < C && (oceanCount[r][c] == 0 || oceanCount[r][c] == 1) && heights[r][c] >= heights[row][col])
                    queue.add(new int[]{r,c});
            }
        }
        
        return result;
    }
}

//DFS
class Solution {
    int[][] heights, oceanCount;
    int R, C;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    List<List<Integer>> result;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r, c, d, row, col;
        R = heights.length; C = heights[0].length;
        oceanCount = new int[R][C];
        this.heights = heights;
        result = new ArrayList<List<Integer>>();
        
        //add cells for pacific ocean
        for (r = 0; r < R; ++r)
            dfsFromPacificOcean(r,0);
        for (c = 0; c < C; ++c)
            dfsFromPacificOcean(0,c);
        
        //add cells for atlantic ocean
        for (r = 0; r < R; ++r)
            dfsFromAtlanticOcean(r,C-1);
        for (c = 0; c < C; ++c)
            dfsFromAtlanticOcean(R-1,c);
        
        return result;
    }
    private void dfsFromPacificOcean(int row, int col)
    {
        int r, c;
        oceanCount[row][col] = 1;
        for (int d = 0; d < 4; ++d)
        {
            r = row+dirs[d][0];
            c = col+dirs[d][1];

            if (r >= 0 && r < R && c >= 0 && c < C && oceanCount[r][c] == 0 && heights[r][c] >= heights[row][col])
                dfsFromPacificOcean(r,c);
        }
    }
    private void dfsFromAtlanticOcean(int row, int col)
    {
        int r, c;
        oceanCount[row][col] = oceanCount[row][col] == 1 ? 2 : -1;
        if (oceanCount[row][col] == 2)
            result.add(Arrays.asList(row,col));
        for (int d = 0; d < 4; ++d)
        {
            r = row+dirs[d][0];
            c = col+dirs[d][1];

            if (r >= 0 && r < R && c >= 0 && c < C && (oceanCount[r][c] == 0 || oceanCount[r][c] == 1) && heights[r][c] >= heights[row][col])
                dfsFromAtlanticOcean(r,c);
        }
    }
}

//single DFS