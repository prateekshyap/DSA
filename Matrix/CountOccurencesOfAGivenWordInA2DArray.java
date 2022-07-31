/*https://practice.geeksforgeeks.org/problems/count-occurences-of-a-given-word-in-a-2-d-array/1/*/

class Solution
{
    int count, m, n;
    boolean[][] visited;
    int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int findOccurrence(char mat[][], String target)
    {
        // Write your code here
        count = 0;
        m = mat.length;
        n = mat[0].length;
        visited = new boolean[m][n];
        char[] arr = target.toCharArray();
        int i, j;
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                count += dfs(mat, arr, i, j, 0);
        return count;
    }
    private int dfs(char[][] mat, char[] str, int row, int col, int index)
    {
        int result = 0;
        
        if (row >=  0 && row < m && col >= 0 && col < n && !visited[row][col] && mat[row][col] == str[index])
        {    
            visited[row][col] = true;
        
            int i, r, c;
            if (index == str.length-1) result = 1;
            else
            {
                if (mat[row][col] == str[index])
                {
                    for (i = 0; i < 4; ++i)
                    {
                        r = row+pos[i][0];
                        c = col+pos[i][1];
                        result += dfs(mat, str, r, c, index+1);
                    }
                }
            }
        
            visited[row][col] = false;
        }
        return result;
    }
}