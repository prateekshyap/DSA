/*https://leetcode.com/problems/shortest-bridge/*/

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int firstX = -1, firstY = -1;
        
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (grid[i][j] == 1)
                {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }
        
        List<int[]> landQueue = new ArrayList<>();
        List<int[]> waterQueue = new ArrayList<>();
        landQueue.add(new int[]{firstX, firstY});
        waterQueue.add(new int[]{firstX, firstY});
        grid[firstX][firstY] = 2;
        
        while (!landQueue.isEmpty())
        {
            List<int[]> newLandQueue = new ArrayList<>();
            for (int[] cell : landQueue)
            {
                int x = cell[0];
                int y = cell[1];
                for (int[] next : new int[][]{{x+1,y},{x-1,y},{x,y+1},{x,y-1}})
                {
                    int currX = next[0];
                    int currY = next[1];
                    if (currX >= 0 && currX < n && currY >= 0 && currY < n && grid[currX][currY] == 1)
                    {
                        newLandQueue.add(new int[]{currX, currY});
                        waterQueue.add(new int[]{currX, currY});
                        grid[currX][currY] = 2;
                    }
                }
            }
            landQueue = newLandQueue;
        }
        
        int distance = 0;
        while (!waterQueue.isEmpty())
        {
            List<int[]> newWaterQueue = new ArrayList<>();
            for (int[] cell : waterQueue)
            {
                int x = cell[0];
                int y = cell[1];
                for (int[] next : new int[][]{{x+1,y},{x-1,y},{x,y+1},{x,y-1}})
                {
                    int currX = next[0];
                    int currY = next[1];
                    if (currX >= 0 && currX < n && currY >= 0 && currY < n)
                    {
                        if (grid[currX][currY] == 1)
                            return distance;
                        else if (grid[currX][currY] == 0)
                        {
                            newWaterQueue.add(new int[]{currX, currY});
                            grid[currX][currY] = -1;
                        }
                    }
                }
            }
            waterQueue = newWaterQueue;
            ++distance;
        }
        
        return distance;
    }
}