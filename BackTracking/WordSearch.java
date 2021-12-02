/*https://leetcode.com/problems/word-search/*/

//simple DFS and backtracking solution

class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        boolean result = false; //store false in result
        visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; ++r)
        {
            for (int c = 0; c < board[r].length; ++c)
            {
                if (board[r][c] == word.charAt(0)) //if current cell matched with the first character of the given word
                {
                    visited[r][c] = true; //mark the cell as visited
                    result = runDFS(board, r, c, word, 1); //run DFS and update the result
                    if (result) return result; //if result is true, return it
                    visited[r][c] = false; // BACKTRACK
                }
            }
        }
        return result; //this definitely returns false
    }
    public boolean runDFS(char[][] board, int r, int c, String word, int index)
    {
    	//base case
        if (index >= word.length()) //if the entire word is checked
            return true; //return true

        boolean result = false; //store false in result
        if (c+1 < board[0].length && board[r][c+1] == word.charAt(index) && !visited[r][c+1]) //for right cell
        {
            visited[r][c+1] = true; //mark as visited
            result = runDFS(board, r, c+1, word, index+1); //run DFS and update result
            if (result) return result; //if true, return
            visited[r][c+1] = false; //BACKTRACK
        }
        if (c-1 >= 0 && board[r][c-1] == word.charAt(index) && !visited[r][c-1]) //for left cell
        {
            visited[r][c-1] = true; //mark as visited
            result = runDFS(board, r, c-1, word, index+1); //run DFS and update result
            if (result) return result; //if true, return
            visited[r][c-1] = false; //BACKTRACK
        }
        if (r+1 < board.length && board[r+1][c] == word.charAt(index) && !visited[r+1][c]) //for down cell
        {
            visited[r+1][c] = true; //mark as visited
            result = runDFS(board, r+1, c, word, index+1); //run DFS and update result
            if (result) return result; //if true, return
            visited[r+1][c] = false; //BACKTRACK
        }
        if (r-1 >= 0 && board[r-1][c] == word.charAt(index) && !visited[r-1][c]) //for up cell
        {
            visited[r-1][c] = true; //mark as visited
            result = runDFS(board, r-1, c, word, index+1); //run DFS and update result
            if (result) return result; //if true, return
            visited[r-1][c] = false; //BACKTRACK
        }
        return false; //if nothing satisfied
    }
}