/*https://leetcode.com/problems/permutations-ii/*/

class Solution {
    HashSet<ArrayList<Integer>> set;
    public List<List<Integer>> permuteUnique(int[] nums) {
        set = new HashSet<ArrayList<Integer>>();

        //recursion call
        recurPerm(nums,0,nums.length-1);

        //convert set to list and return
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }
    public void recurPerm(int[] nums, int l, int r) {
        //base case
        if (l == r)
        {
        	//add the permutation to the set
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; ++i)
                temp.add(nums[i]);
            set.add(temp);
        }
        else
        {
        	//for every integer in the range
            for (int i = l; i <= r; ++i)
            {
                nums = swap(nums,l,i); //backtracking step-1 - swap
                recurPerm(nums,l+1,r); //backtracking step-2 - recur
                nums = swap(nums,l,i); //backtracking step-3 - backtrack
            }
        }
    }
    public int[] swap(int[] nums, int l, int i) {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
        return nums;
    }
}