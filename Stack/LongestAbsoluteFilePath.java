/*https://leetcode.com/problems/longest-absolute-file-path/*/

class Solution {
    public int lengthLongestPath(String input) {
        
        String[] exp=input.split("\n");
        
        HashMap<Integer,Integer> levMap = new HashMap<>();
        
        int max=0;
        int lev,len=0;
                
        for(int i=0;i<exp.length;i++)
        {
            
            if(exp[i].contains("."))
            {
                lev = exp[i].lastIndexOf("\t")+1;
                len = levMap.getOrDefault(lev-1,0)+exp[i].length()-lev;
                max=len>max?len:max;
            }
            else //directory
            {
                lev = exp[i].lastIndexOf("\t")+1; //get current level
                 
                levMap.put(lev,levMap.getOrDefault(lev-1,0)+exp[i].length()-lev+1); //overwrite with current dir since all inputs are together (a file falling in a previous directory wouldn't be inputted later when a new directory is input) 
                    
            }
        }
        
        return max;
    }  
    
}