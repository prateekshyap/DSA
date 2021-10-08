/*https://leetcode.com/problems/palindrome-partitioning/*/

class Solution
{
    List<List<String>> result;
    public boolean isPalindrome(String str, int start, int end)
    {
        while(start<end)
        {
            if(str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public void palindromicPartitionSolver(int[] table, String s, int n, int index, int loop, List<String> curr)
    {
        if (index > n)
        {
        	//add the current partition to the result if the last index is 1
            if (table[table.length-1] == 1) result.add(new ArrayList<String>(curr));
        }
		else
        {
        	//from loop starting point till current index
            for (int j = loop; j <= index && index <= n; ++j)
            {
            	//if the substring till jth index has been checked
            	//and from j to index substring is a palindrome
                if (table[index] == 0 && table[j] > 0 && isPalindrome(s.substring(j,index),0,index-1-j))
                {
                	/*backtracking step - 1*/
                    table[index] = 1;
                    curr.add(s.substring(j,index));
                    //start the loop from the current index and increase index to 1
                    palindromicPartitionSolver(table,s,n,index+1,index,curr); //backtracking step - 2
                    /*backtracking step - 3*/
                    table[index] = 0;
                    curr.remove(curr.size()-1);
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
    public List<List<String>> partition(String s)
    {
        result = new ArrayList<List<String>>();
        int[] table = new int[s.length()+1];
        table[0] = 1;
        List<String> curr = new ArrayList<String>();
        palindromicPartitionSolver(table,s,s.length(),0,0,curr);
        return result;
    }
}