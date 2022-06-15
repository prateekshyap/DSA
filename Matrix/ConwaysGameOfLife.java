/*https://binarysearch.com/problems/Conway's-Game-of-Life*/

import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        //Queue<Ind> queue = new LinkedList<Ind>();
        int i, j, k, iNeigh, jNeigh, m = matrix.length, n = matrix[0].length, live = 0, dead = 0;
        int[][] result = new int[m][n];
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                live = dead = 0;

                //either this
                /*for (k = 0; k < 8; ++k)
                {
                    iNeigh = i+directions[k][0];
                    jNeigh = j+directions[k][1];
                    if (iNeigh >= 0 && iNeigh < m && jNeigh >= 0 && jNeigh < n)
                    {
                        if (matrix[iNeigh][jNeigh] == 1) ++live; else ++dead;
                    }
                }*/

                //or this
                if (i+1 < m) if (matrix[i+1][j] == 1) ++live; else ++dead;
                if (j+1 < n) if (matrix[i][j+1] == 1) ++live; else ++dead;
                if (i-1 >= 0) if (matrix[i-1][j] == 1) ++live; else ++dead;
                if (j-1 >= 0) if (matrix[i][j-1] == 1) ++live; else ++dead;
                if (i+1 < m && j+1 < n) if (matrix[i+1][j+1] == 1) ++live; else ++dead;
                if (i-1 >= 0 && j+1 < n) if (matrix[i-1][j+1] == 1) ++live; else ++dead;
                if (i-1 >= 0 && j-1 >= 0) if (matrix[i-1][j-1] == 1) ++live; else ++dead;
                if (i+1 < m && j-1 >= 0) if (matrix[i+1][j-1] == 1) ++live; else ++dead;
                //till this
                
                if ((live == 3 || live == 2) && matrix[i][j] == 1) result[i][j] = 1;
                else if (matrix[i][j] == 0 && live == 3) result[i][j] = 1;
                else result[i][j] = 0;
            }
        }
        return result;
    }
}