/*https://leetcode.com/problems/subsets/*/

/*Prateekshya*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        recur(nums,0, new ArrayList<Integer>());
        return result;
    }
    public void recur(int[] nums, int index, ArrayList<Integer> currList)
    {
        if (index == nums.length) //if all elements are checked
        {
        	//create a list with the currently chosen elements
            List<Integer> newList = new ArrayList<Integer>();
            for (Integer element : currList)
                newList.add(element);

            //add it to the result and return
            result.add(newList);
            return;
        }

        /*exclude the current element and recur for the next*/
        recur(nums,index+1,currList);

        /*include the current element and recur for the next*/
        currList.add(nums[index]);
		recur(nums,index+1,currList);
        currList.remove(currList.size()-1);
    }
}