/*https://practice.geeksforgeeks.org/problems/word-break-part-23249/1*/

class Solution
{
    static HashSet<String> set;
    static List<String> result;
    static String getList(String s, int n, int[] table)
    {
        StringBuilder sb = new StringBuilder("");
        int i = 0, j = 1;
        while (i <= n && j <= n)
        {
            while (table[j] != 1) ++j;
            sb.append(s.substring(i,j));
            sb.append(" ");
            i = j;
            j = j+1;
        }
        return sb.substring(0,sb.length()-1);
    }
    static void wordBreakSolver(int[] table, String s, int n, int index, int loop)
    {
    	//if the entire string has been processed
        if (index > n)
        {
        	//add the current table to the result if the last index is 1
            if (table[table.length-1] == 1) result.add(getList(s,n,table));
        }
		else
        {
        	//from loop starting point till current index
            for (int j = loop; j <= index && index <= n; ++j)
            {
            	//if the substring till jth index has been checked
            	//and from j to index substring is present in the dictionary
                if (table[index] == 0 && table[j] > 0 && set.contains(s.substring(j,index)))
                {
                    table[index] = 1; //backtracking step - 1
                    //start the loop from the current index and increase index to 1
                    wordBreakSolver(table,s,n,index+1,index); //backtracking step - 2
                    table[index] = 0; //backtracking step - 3
                }
                else 
                {
                	//restart j and increase the index
                    j = loop-1;
                    ++index;
                }
            }
        }
    }
    static List<String> wordBreak (int m, List<String> dict, String s)
    {
    	//add the dictionary words to a hashset
        set = new HashSet<String>();
        for (String str : dict) set.add(str);
        
        //create the result list
        result = new ArrayList<String>();
        /*
        create the board for backtracking and store 1 at 0th index
    	(complete reference on Dynamic Programming - WordBreak.java)
    	*/
        int[] table = new int[s.length()+1];
        table[0] = 1;
        
        //start with 0th position as the loop starting point and 0th position as the index
        wordBreakSolver(table,s,s.length(),0,0);
        
        return result;
    }
}