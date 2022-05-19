/*https://leetcode.com/problems/combination-sum-ii/*/

class Solution {
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //marker per path
        boolean[] used = new boolean[candidates.length];
        backtracking(ans, new ArrayList<Integer>(), candidates, target, 0, 0, used);
        return ans; 
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> path, int[] candidates, int target, int sum, int index, boolean[] used) {
        if (sum == target)
        {
            //make a new copy of the current path, as path will change throughout the recursion
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++)
        {
            //early pruning 
            if (sum + candidates[i] > target) break;
            //avoid duplicates at same tree depth, allowing duplicate at different tree depths (eg. [1,1,1,2] target:3; allows [1,1,1], not allow [1,2] after [1,2])
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
            path.add(candidates[i]);
            used[i] = true;
            backtracking(ans, path, candidates, target, sum + candidates[i], i + 1, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}