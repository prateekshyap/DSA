/*https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree/*/

class Solution {
    int[] result, parents, nums;
    SortedSet<Integer> set;
    Map<Integer, List<Integer>> graph;
    boolean[] removed;
    int max;
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        result = new int[n];
        removed = new boolean[(int)1e5+1];
        this.parents = parents;
        this.nums = nums;
        set = new TreeSet<Integer>();
        Arrays.fill(result,1);
        max = 0;
        for (int val : nums)
            max = Math.max(max,val);
        for (int val = 1; val <= max+1; ++val)
            set.add(val);
        if (!set.contains(1)) return result;
        graph = new HashMap<Integer,List<Integer>>();
        for (int i = 0; i < n; ++i)
            graph.put(i,new ArrayList<Integer>());
        for (int i = 1; i < n; ++i)
            graph.get(parents[i]).add(i);
        
        dfs(0);
        
        return result;
    }
    private boolean dfs(int node)
    {
        boolean isOnePresent = false;
        
        if (nums[node] == 1) isOnePresent = true;
        else for (Integer child : graph.get(node))
            isOnePresent |= dfs(child);
        
        if (isOnePresent)
        {
            remove(node);
            result[node] = set.first();
        }
        return isOnePresent;
    }
    private void remove(int node)
    {
        int num = nums[node];
        if (removed[num]) return;
        removed[num] = true;
        set.remove(num);
        for (Integer child : graph.get(node))
            remove(child);
    }
}

class Solution {
    int[] result, parents, nums;
    SortedSet<Integer> set;
    Map<Integer, List<Integer>> graph;
    boolean[] removed;
    int max;
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        result = new int[n];
        removed = new boolean[(int)1e5+1];
        this.parents = parents;
        this.nums = nums;
        set = new TreeSet<Integer>();
        Arrays.fill(result,1);
        max = 0;
        int val, oneIndex = -1;
        for (int i = 0; i < nums.length; ++i)
        {
            val = nums[i];
            if (val == 1) oneIndex = i;
            max = Math.max(max,val);
        }
        if (oneIndex == -1) return result;
        for (val = 1; val <= max+1; ++val)
            set.add(val);
        graph = new HashMap<Integer,List<Integer>>();
        for (int i = 0; i < n; ++i)
            graph.put(i,new ArrayList<Integer>());
        for (int i = 1; i < n; ++i)
            graph.get(parents[i]).add(i);
        
        dfs(oneIndex);
        
        return result;
    }
    private void dfs(int node)
    {
        if (node == -1) return;
        remove(node);
        result[node] = set.first();
        dfs(parents[node]);
    }
    private void remove(int node)
    {
        int num = nums[node];
        if (removed[num]) return;
        removed[num] = true;
        set.remove(num);
        for (Integer child : graph.get(node))
            remove(child);
    }
}