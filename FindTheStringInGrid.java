/*https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1*/

class Solution
{
    int row = 0;
    int col = 0;
    
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        row = grid.length;
        col = grid[0].length;
        
        for(int i = 0; i<row; i++)
        {
            for(int j = 0; j<col; j++)
            {
                if(found(word,grid,i,j))
                {
                    ArrayList<Integer> coordinates = new ArrayList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    
                    res.add(coordinates);
                }
            }
        }
        int [][] resArray = new int[res.size()][2];
        
        for(int i = 0 ; i<res.size(); i++)
        {
            ArrayList<Integer> li = res.get(i);
            for(int j = 0; j<2; j++)
            {
                resArray[i][j] = li.get(j);
            }
        }
        
        return resArray;
    }
    
    boolean found(String word, char[][] grid, int i, int j)
    {
        if(word.length() == 0)
        return true;
        
        if(!isValidMove(i,j) || grid[i][j] != word.charAt(0))
        return false;
        
        return findInDirection(word.substring(1),grid,i,j+1,"hR") 
            || findInDirection(word.substring(1),grid,i,j-1,"hL")
            || findInDirection(word.substring(1),grid,i-1,j,"vU")
            || findInDirection(word.substring(1),grid,i+1,j,"vD")
            || findInDirection(word.substring(1),grid,i-1,j-1,"dLd")
            || findInDirection(word.substring(1),grid,i+1,j-1,"dLu")
            || findInDirection(word.substring(1),grid,i+1,j+1,"dRd")
            || findInDirection(word.substring(1),grid,i-1,j+1,"dRu");
            
    }
    
    boolean findInDirection(String word, char[][] grid, int i, int j,String direction)
    {
        if(word.length() == 0)
        return true;
        
        if(!isValidMove(i,j) || grid[i][j] != word.charAt(0))
        return false;
        
        if(direction.equals("hR"))
        return true && findInDirection(word.substring(1),grid,i,j+1,"hR");
        else if(direction.equals("hL"))
        return true && findInDirection(word.substring(1),grid,i,j-1,"hL");
        else if(direction.equals("vU"))
        return true && findInDirection(word.substring(1),grid,i-1,j,"vU");
        else if(direction.equals("vD"))
        return true && findInDirection(word.substring(1),grid,i+1,j,"vD");
        else if(direction.equals("dLd"))
        return true && findInDirection(word.substring(1),grid,i-1,j-1,"dLd");
        else if(direction.equals("dLu"))
        return true && findInDirection(word.substring(1),grid,i+1,j-1,"dLu");
        else if(direction.equals("dRd"))
        return true && findInDirection(word.substring(1),grid,i+1,j+1,"dRd");
        else if(direction.equals("dRu"))
        return true && findInDirection(word.substring(1),grid,i-1,j+1,"dRu");
        else
        return false;
        
    }
    
    boolean isValidMove(int i, int j)
    {
        if(i < 0 || i >= row || j < 0 || j >= col)
        return false;
        else
        return true;
    }
}