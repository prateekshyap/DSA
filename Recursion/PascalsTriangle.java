/*https://leetcode.com/problems/pascals-triangle/*/
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> generate(int numRows) {
        //return for 0 rows
        if (numRows == 0) return list;
        
        //instantiate
        list = new ArrayList<>();
        
        //add the first row to the list
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        list.add(temp);
        
        //return if single row required
        if (numRows == 1) return list;
        
        //call the recursive function
        addNextRow(1,numRows);
        
        //return the final list
        return list;
    }
    public void addNextRow(int curr, int n) {
        //return if all rows added
        if (curr == n)
            return;
        
        //obtain the previous list
        List<Integer> prevList = list.get(curr-1);
        
        //create the current new list
        List<Integer> newList = new ArrayList<Integer>();
        
        //add the first element
        newList.add(prevList.get(0));
        
        //add middle elements
        int i = 0, j = 1;
        while (j < prevList.size()) {
            newList.add(prevList.get(i)+prevList.get(j));
            ++i; ++j;
        }
        
        //add the last elements
        newList.add(prevList.get(prevList.size()-1));
        
        //add the current list to final list
        list.add(newList);
        
        //call for the next row
        addNextRow(curr+1,n);
    }
}