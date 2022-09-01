/*https://leetcode.com/problems/trapping-rain-water-ii/*/

class Solution {
    
    
    final int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    
    public int trapRainWater(int[][] heightMap) {
        int waterCount = 0;
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        //Stores x,y coordinates in a min Heap sorted by height
        Queue<int[]> outerWall = new PriorityQueue<>((a,b) -> 
                                heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]);
        boolean[][] visited = new boolean[rows][cols];
        
        //Add all boundary points. Basically build the boundary wall
        for (int col = 0; col < cols; col++) {
            outerWall.offer(new int[]{0, col});
            outerWall.offer(new int[]{rows-1, col});
            visited[0][col] = true;
            visited[rows-1][col] = true;
        }
        
        for (int row = 0; row < rows; row++) {
            outerWall.offer(new int[]{row, 0});
            outerWall.offer(new int[]{row, cols-1});
            visited[row][0] = true;
            visited[row][cols-1] = true;
        }
        
        int minOfBoundary = Integer.MIN_VALUE; //In the future heights may be negative
        while (!outerWall.isEmpty()) {
            int[] current = outerWall.poll();
            minOfBoundary = Integer.max(minOfBoundary, heightMap[current[0]][current[1]]);
            //If current call has max, it will be leaked. Else the diff is trapped
            waterCount += minOfBoundary - heightMap[current[0]][current[1]];
            for (int[] dir: dirs) {
                int curx = current[0] + dir[0];
                int cury = current[1] + dir[1];
                if (curx >= 0 && curx < rows && cury >=0 
                   && cury < cols && !visited[curx][cury]) {
                    visited[curx][cury] = true;
                    outerWall.offer(new int[]{curx, cury});
                }
            }
        }                                                        
        return  waterCount;          
    }                                               
}