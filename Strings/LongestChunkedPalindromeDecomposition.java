/*https://leetcode.com/problems/longest-chunked-palindrome-decomposition/*/

class Solution {
    int result;
    public int longestDecomposition(String text) {
        result = 0;
        solve(text,0,text.length()-1,0);
        return result;
    }
    private boolean solve(String text, int start, int end, int count)
    {
        if (start > end)
        {
            result = Math.max(result,count);
            return true;
        }
        if (start == end)
        {
            result = Math.max(result,count+1);
            return true;
        }
        StringBuilder left = new StringBuilder(""), right = new StringBuilder("");
        while (start < end)
        {
            left.append(text.charAt(start++));
            right.insert(0,text.charAt(end--));
            if (left.toString().equals(right.toString()) && solve(text,start,end,count+2))
                return true;
        }
        result = Math.max(result,count+1);
        return false;
    }
}