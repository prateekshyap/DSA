/*https://leetcode.com/problems/word-search/*/

/*Pratik's Solution*/

class Solution {
    HashSet<String> set = new HashSet<String>();
    public boolean exist(char[][] board, String word) 
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    boolean[] visited[] = new boolean[board.length][board[0].length];
                    if(dfs(board,i,j,word,new String(),visited))return true;
                }
            }
        }
        for(String s:set)System.out.println(s);
        return false;
    }
    public boolean dfs(char[][] board,int i,int j,String word,String cur,boolean[][] visited)
    {
        int rows = board.length,cols = board[0].length;
        int l = cur.length();
        if(word.equals(cur))return true;
        if(i<0 || j<0 || i>=rows || j>=cols || visited[i][j]==true ||cur.length()>=word.length() || board[i][j]!=word.charAt(l) || cur.length()>word.length())
        {
            return false;
        }
        cur += board[i][j];
        set.add(cur);
        visited[i][j] = true;
        boolean res = (dfs(board,i-1,j,word,cur,visited)||
        dfs(board,i,j-1,word,cur,visited)||
        dfs(board,i+1,j,word,cur,visited)||
        dfs(board,i,j+1,word,cur,visited));
        visited[i][j] = false;
        return res;
    }
}

/*Prateekshya's solution*/
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