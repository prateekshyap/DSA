/*https://leetcode.com/problems/pascals-triangle-ii/*/

class Solution {
    List<Integer> list;
    public List<Integer> getRow(int rowIndex) {
        list = new ArrayList<Integer>();
        list.add(1);
        
        //call the recursive function
        addNextRow(0,rowIndex);
        
        //return the final list
        return list;
    }
    public void addNextRow(int curr, int n) {
        //return if all rows added
        if (curr == n)
            return;
        
        //create the current new list
        List<Integer> newList = new ArrayList<Integer>();
        
        //add the first element
        newList.add(list.get(0));
        
        //add middle elements
        int i = 0, j = 1;
        while (j < list.size()) {
            newList.add(list.get(i)+list.get(j));
            ++i; ++j;
        }
        
        //add the last elements
        newList.add(list.get(list.size()-1));
        
        //add the current list to final list
        list = newList;
        
        //call for the next row
        addNextRow(curr+1,n);
    }
}