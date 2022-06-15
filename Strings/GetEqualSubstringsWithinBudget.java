/*https://leetcode.com/problems/get-equal-substrings-within-budget/*/

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0, j = -1, currLen = 0, maxLen = 0, currCost = 0, n = t.length();
        while (i < n && j < n-1) //till all elements are exhausted
        {
            ++j; //increase the window size to right
            if (currCost+Math.abs(t.charAt(j)-s.charAt(j)) <= maxCost) //if current character can be added
            {
                currCost += Math.abs(t.charAt(j)-s.charAt(j)); //add it
                ++currLen; //increase the length
            }
            else //otherwise
            {
                if (currLen > maxLen) maxLen = currLen; //update maximum length
                currCost += Math.abs(t.charAt(j)-s.charAt(j)); //add cost, this is for sure greater than maxCost
                ++currLen; //increase the length
                while (currCost > maxCost) //till cost is more
                {
                    currCost -= Math.abs(t.charAt(i)-s.charAt(i)); //reduce the cost from left
                    --currLen; //reduce length
                    ++i; //reduce the window size from left
                }
            }
        }
        
        if (currLen > maxLen) maxLen = currLen; //update maxLen at the end
        
        return maxLen;
    }
}