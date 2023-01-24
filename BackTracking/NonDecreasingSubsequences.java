/*https://leetcode.com/problems/non-decreasing-subsequences/*/

class Solution {
    List<List<Integer>> nondecreasingSubsequences;
    public List<List<Integer>> findSubsequences(int[] nums) {
        nondecreasingSubsequences = new ArrayList<>();
        Set<String> added = new HashSet<String>();
        findSubsequences(nums,new ArrayList<Integer>(),0,added);
        return nondecreasingSubsequences;
    }
    private void findSubsequences(int[] nums, List<Integer> currentSubsequence, int index, Set<String> added)
    {
        if (index >= nums.length)
        {
            StringBuilder key = new StringBuilder();
            for (Integer value : currentSubsequence)
            {
                key.append(value);
                key.append("#");
            }
            if (!added.contains(key.toString()))
            {
                key = new StringBuilder();
                List<Integer> list = new ArrayList<>();
                for (Integer value : currentSubsequence)
                {
                    key.append(value);
                    key.append("#");
                    list.add(value);
                    if (list.size() == 1) continue;
                    List<Integer> temp = new ArrayList<>(list);
                    if (!added.contains(key.toString())) nondecreasingSubsequences.add(temp);
                    added.add(key.toString());
                }
            }
            return;
        }
        
        if (currentSubsequence.isEmpty() || nums[index] >= currentSubsequence.get(currentSubsequence.size()-1))
        {
            currentSubsequence.add(nums[index]);
            findSubsequences(nums,currentSubsequence,index+1,added);
            currentSubsequence.remove(currentSubsequence.size()-1);
        }
        findSubsequences(nums,currentSubsequence,index+1,added);
    }
}

class Solution {
    List<List<Integer>> nondecreasingSubsequences;
    public List<List<Integer>> findSubsequences(int[] nums) {
        nondecreasingSubsequences = new ArrayList<>();
        findSubsequences(nums,new ArrayList<Integer>(),0);
        return nondecreasingSubsequences;
    }
    private void findSubsequences(int[] nums, List<Integer> currentSubsequence, int index)
    {
        if (index >= nums.length)
        {
            if (currentSubsequence.size() >= 2)
                nondecreasingSubsequences.add(new ArrayList<>(currentSubsequence));
            return;
        }
        
        if (currentSubsequence.isEmpty() || nums[index] >= currentSubsequence.get(currentSubsequence.size()-1))
        {
            currentSubsequence.add(nums[index]);
            findSubsequences(nums,currentSubsequence,index+1);
            currentSubsequence.remove(currentSubsequence.size()-1);
        }
        if (currentSubsequence.size() == 0 || nums[index] != currentSubsequence.get(currentSubsequence.size()-1)) findSubsequences(nums,currentSubsequence,index+1);
    }
}