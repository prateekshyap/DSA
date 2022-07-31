/*https://practice.geeksforgeeks.org/problems/word-boggle4143/1/*/

class Solution
{
    int m, n;
    boolean[][] visited;
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        m = board.length; n = board[0].length;
        int i, j, k;
        visited = new boolean[m][n];
        HashSet<String> set = new HashSet<String>();
        
        for (i = 0; i < dictionary.length; ++i)
            for (j = 0; j < m; ++j)
                for (k = 0; k < n; ++k)
                    if (dictionary[i].charAt(0) == board[j][k] && dfs(board, dictionary[i], j, k, 0))
                        set.add(dictionary[i]);
        
        String[] result = new String[set.size()];
        
        i = 0;
        for (String s : set) result[i++] = s;
        
        return result;
    }
    public boolean dfs(char[][] board, String s, int j, int k, int index)
    {
        if (index == s.length()) return true;
        
        if (j < 0 || j >= m || k < 0 || k >= n || board[j][k] != s.charAt(index) || visited[j][k]) return false;
        
        visited[j][k] = true;
        
        boolean result = dfs(board, s, j+1, k, index+1);
        result |= dfs(board, s, j-1, k, index+1);
        result |= dfs(board, s, j+1, k+1, index+1);
        result |= dfs(board, s, j-1, k+1, index+1);
        result |= dfs(board, s, j+1, k-1, index+1);
        result |= dfs(board, s, j-1, k-1, index+1);
        result |= dfs(board, s, j, k+1, index+1);
        result |= dfs(board, s, j, k-1, index+1);
        
        visited[j][k] = false;
        
        return result;
    }
}