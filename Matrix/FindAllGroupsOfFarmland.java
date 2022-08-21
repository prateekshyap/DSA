/*https://leetcode.com/problems/find-all-groups-of-farmland/*/

class Solution {
    public int[][] findFarmland(int[][] land) {
        int R = land.length, C = land[0].length, r, c, i, j, m, n, x, y;
        List<int[]> list = new ArrayList<int[]>();
        
        for (i = 0; i < R; ++i)
        {
            for (j = 0; j < C; ++j)
            {
                if (land[i][j] == 1)
                {
                    r = x = i;
                    c = y = j;
                    while (x < R && land[x][y] == 1) ++x; --x;
                    while (y < C && land[x][y] == 1) ++y; --y;
                    list.add(new int[]{r,c,x,y});
                    for (m = r; m <= x; ++m)
                        for (n = c; n <= y; ++n)
                            land[m][n] = 0;
                }
            }
        }
        
        int[][] result = new int[list.size()][4];
        for (i = 0; i < result.length; ++i)
            result[i] = list.get(i);
        return result;
    }
}

class Solution {
    public int[][] findFarmland(int[][] land) {
	    List<int[]> resultList = new ArrayList<>();
	    for (int i=0;i<land.length;i++) 
		    for (int j=0;j<land[0].length;j++)
			    if (land[i][j]==1 && (i==0||land[i-1][j]==0) && (j==0 ||land[i][j-1]==0)) {
				    int i2 = i, j2 = j;
				    while (i2<land.length && land[i2][j] == 1) 
                        i2++;
				    while (j2<land[0].length && land[i][j2] == 1) 
                        j2++;
				    resultList.add(new int[]{i,j,i2-1,j2-1});
			    }
	    return resultList.toArray(new int[0][]);
    }
}