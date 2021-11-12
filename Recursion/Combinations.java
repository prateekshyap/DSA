/*https://leetcode.com/problems/combinations/*/

class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    void recur(List<Integer> currList, int curr, int k, int n)
    {
        if (k == 0)
        {
            result.add(currList);
            return;
        }
        
        for(int i = curr+1; i <= n; ++i)
        {
            List<Integer> newList = new ArrayList<>(currList);
            newList.add(i);
            recur(newList, i, k-1, n);
        }
    }
    
    public List<List<Integer>> combine(int n, int k)
    {
        List<Integer> currList = new ArrayList<Integer>();
        recur(currList, 0, k, n);
        return result;
    }
}