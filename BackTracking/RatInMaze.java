/*https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1*/

class Solution {
    static ArrayList<String> list;
    static String currPath;
    static int n;
    
    public static boolean isSafe(int r, int c, int[][] maze, boolean[][] visited) {
        //if boundary conditions violate, return false
        if (r == -1 || r == n || c == -1 || c == n)
            return false;
            
        //if the move is unsafe, return false
        if (visited[r][c] || maze[r][c] == 0)
            return false;
            
        //return true
        return true;
    }
    
    public static void addPaths(int r, int c, int[][] maze, boolean[][] visited) {
        //if conditions violate, return
        if (r == -1 || c == -1 || r == n || c == n || maze[r][c] == 0) return;
        
        //if board completed, add solution 
        if (r == n-1 && c == n-1)
        {
            list.add(currPath);
        }
        
        visited[r][c] = true; //backtracking step-1
        
        //move in all four directions
        if (isSafe(r+1,c,maze,visited))
        {
            currPath += "D"; //backtracking step - 1
            addPaths(r+1,c,maze,visited); //backtracking step - 2
            currPath = currPath.substring(0,currPath.length()-1); //backtracking step - 3
        }
        if (isSafe(r,c+1,maze,visited))
        {
            currPath += "R"; //backtracking step - 1
            addPaths(r,c+1,maze,visited); //backtracking step - 2
            currPath = currPath.substring(0,currPath.length()-1); //backtracking step - 3
        }
        if (isSafe(r-1,c,maze,visited))
        {
            currPath += "U"; //backtracking step - 1
            addPaths(r-1,c,maze,visited); //backtracking step - 2
            currPath = currPath.substring(0,currPath.length()-1); //backtracking step - 3
        }
        if (isSafe(r,c-1,maze,visited))
        {
            currPath += "L"; //backtracking step - 1
            addPaths(r,c-1,maze,visited); //backtracking step - 2
            currPath = currPath.substring(0,currPath.length()-1); //backtracking step - 3
        }
        
        visited[r][c] = false; //backtracking step - 3
    }
    
    public static ArrayList<String> findPath(int[][] m, int N) {
        n = N;
        list = new ArrayList<String>();
        currPath = "";
        boolean[][] visited = new boolean[n][n];
        addPaths(0, 0, m, visited);
        Collections.sort(list);
        return list;
    }
}