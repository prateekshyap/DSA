/*https://leetcode.com/problems/permutations/*/
/*https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string-1587115620/1*/

//for integer array
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<List<Integer>>();

        //recursion call
        recurPerm(nums,0,nums.length-1);
        
        return list;
    }
    public void recurPerm(int[] nums, int l, int r) {
        //base case
        if (l == r)
        {
        	//add the permutation to the list
            list.add(new ArrayList<Integer>());
            for (int i = 0; i < nums.length; ++i)
                list.get(list.size()-1).add(nums[i]);
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

//for string
class Solution
{
    ArrayList<String> list;
    public ArrayList<String> permutation(String S)
    {
        list = new ArrayList<String>();

        //recursion call
        recurPerm(S,0,S.length()-1);

        //sort and return
        Collections.sort(list);
        return list;
    }
    public void recurPerm(String str, int l, int r)
    {
    	//base case
        if (l == r)
            list.add(str);
        else
        {
        	//for every character in the range
            for (int i = l; i <= r; ++i)
            {
                str = swap(str,l,i); //backtracking step-1 - swap
                recurPerm(str,l+1,r); //backtracking step-2 - recur
                str = swap(str,l,i); //backtracking step-3 - backtrack
            }
        }
    }
    public String swap(String s, int i, int j)
    {
        char[] temp = s.toCharArray();
        char ch = temp[i];
        temp[i] = temp[j];
        temp[j] = ch;
        return String.valueOf(temp);
    }
}