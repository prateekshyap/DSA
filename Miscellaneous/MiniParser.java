/*https://leetcode.com/problems/mini-parser/*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    NestedInteger result;
    int index;
    public NestedInteger deserialize(String s) {
        result = new NestedInteger();
        if (s.charAt(0) != '[')
        {
            result.setInteger(Integer.parseInt(s));
            return result;
        }
        index = 0;
        return recur(s);
    }
    private NestedInteger recur(String s)
    {
        NestedInteger res = new NestedInteger();
        StringBuilder intVal = new StringBuilder("");
        boolean start = true;
        
        while (start || s.charAt(index) == ',')
        {
            start = false;
            ++index;
            if (s.charAt(index) == '[')
                res.add(recur(s));
            else if (s.charAt(index) == ']') break;
            else
            {
                intVal = new StringBuilder("");
                while (s.charAt(index) != '[' && s.charAt(index) != ']' && s.charAt(index) != ',')
                    intVal.append(s.charAt(index++));
                res.add(new NestedInteger(Integer.parseInt(intVal.toString())));
            }
        }
        
        if (s.charAt(index) == ']') ++index;
        return res;
    }
}