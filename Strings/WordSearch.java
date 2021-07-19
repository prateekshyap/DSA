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