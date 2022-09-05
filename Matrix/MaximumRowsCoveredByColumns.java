/*https://leetcode.com/problems/maximum-rows-covered-by-columns/*/

class Solution {
    int M, N;
    int[] ones;
    int max;
    public int maximumRows(int[][] mat, int cols) {
        if (cols == mat[0].length) return mat.length;
        M = mat.length;
        N = mat[0].length;
        max = 0;
        ones = new int[M];
        for (int i = 0; i < M; ++i)
            for (int j = 0; j < N; ++j)
                ones[i] += mat[i][j]; //count the number of 1's for each row
        recur(mat,cols,0,ones,0);
        return max;
    }
    private void recur(int[][] mat, int cols, int col, int[] ones, int rows)
    {
        if (col == N) //if traversed all columns
        {
            max = Math.max(max,rows); //update max
            return;
        }
        
        recur(mat, cols, col+1, ones, rows); //not pick
        if (cols > 0) //if there are remaining cols
        {
        	//copy the ones array
            int[] copy = new int[M];
            for (int i = 0; i < M; ++i)
                copy[i] = ones[i];
            rows = 0; //reset rows
            for (int i = 0; i < M; ++i)
            {
                if (mat[i][col] == 1) --copy[i]; //reduce number of 1's for the corresponding rows
                if (copy[i] == 0) ++rows; //increment the number of covered rows
            }
            recur(mat, cols-1, col+1, copy, rows); //pick
        }
    }
}

class Solution {
    boolean [] visited;
    
    public int maximumRows(int[][] mat, int cols) {
        visited = new boolean [mat[0].length];
        
        return solve(mat, cols, 0);
    }
    
    private int solve(int [][] mat, int left, int idx){
        if (left == 0 || idx == mat[0].length){
            return countRows(mat);
        }
        
        int result = solve(mat, left, idx + 1);
        
        visited[idx] = true;
        result = Math.max(result, solve(mat, left - 1, idx + 1));
        visited[idx] = false;
        
        return result;
    }
    
    private int countRows(int [][] mat){
        int result = 0;
        
        for (int [] row : mat){
            ++result;
            
            for (int i = 0; i < row.length; ++i){
                if (visited[i] || row[i] == 0)
                    continue;
                
                --result;
                break;
            }
        }
        
        return result;
    }
}