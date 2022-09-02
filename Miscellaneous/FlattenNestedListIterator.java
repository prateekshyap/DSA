/*https://leetcode.com/problems/flatten-nested-list-iterator/*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> result = new ArrayList<>();
    int index=0; 
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i =0 ; i < nestedList.size(); i++)  
        {
            if(nestedList.get(i).isInteger())  
                result.add(nestedList.get(i).getInteger());
            else{
                search(nestedList.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        return result.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<result.size();
    }
    
    public void search(NestedInteger data){
        if(data.isInteger())
            result.add(data.getInteger());
        else{
            for(int i =0; i <data.getList().size();i++){
                search(data.getList().get(i));
            }
        }
        
    }
}