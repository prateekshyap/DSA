/*https://leetcode.com/problems/letter-combinations-of-a-phone-number/*/

class Solution {
    String[] chs;
    List<String> l;
    Solution()
    {
    	//standard letter combinations
        chs = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        l = new ArrayList<String>();
    }
    public List<String> letterCombinations(String digits) {
    	//edge case
        if (digits.length() == 0) return new ArrayList<String>();
        Solution s = new Solution();

        //recursion call
        s.generateCombinations(0,"",digits);
        return s.l;
    }
    public void generateCombinations(int index, String curr, String digits)
    {
    	//base case
        if (index == digits.length())
        {
            l.add(curr);
            return;
        }

        int ind = Integer.parseInt(Character.toString(digits.charAt(index)))-2;
        
        /*recursion*/
        for (int i = 0; i < chs[ind].length(); ++i)
            generateCombinations(index+1,curr+(chs[ind].charAt(i)),digits);
    }
}