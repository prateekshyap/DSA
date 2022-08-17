/*https://leetcode.com/problems/combination-sum-iii/*/

class Solution {
    public List<List<Integer>> result;
    public void countAndAdd(int[] list, int target, int sum, int lastAdded, ArrayList<Integer> curr, int limit)
    {
        if (sum > target) return;
        if (curr.size() > limit) return;
        if (sum == target && curr.size() == limit)
        {
        	//copy the current elements to another list 
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < curr.size(); ++i)
                temp.add((Integer)curr.get(i));

            //add it to result
            result.add(temp);
            return;
        }
        //start from the index which was added last, to avoid duplicate combinations
        for (int i = lastAdded+1; i < list.length; ++i)
        {
        	//if the element can contribute in the sum
            if (target-list[i] >= 0)
            {
                curr.add(list[i]); //backtracking step - 1
                countAndAdd(list,target,sum+list[i],i,curr,limit); //backtracking step - 2
                curr.remove(curr.size()-1); //backtracking step - 3
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<List<Integer>>();
        int i;
        int[] nums = new int[9];
        for (i = 0; i < 9; ++i) nums[i] = i+1;

        //recursion call
        countAndAdd(nums,n,0,-1,new ArrayList<Integer>(),k);
        
        return result;
    }
}

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<List<Integer>>();
        generateCombinations(k,n,1,0,new ArrayList<Integer>());
        return result;
    }
    private void generateCombinations(int n, int target, int elem, int sum, List<Integer> curr)
    {
        if (sum == target)
        {
            if (curr.size() == n)
                result.add(new ArrayList<>(curr));
            return;
        }
        if (curr.size() == n) return;
        for (int i = elem; i <= 9; ++i)
        {
            if (sum+i <= target)
            {
                curr.add(i);
                generateCombinations(n,target,i+1,sum+i,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}