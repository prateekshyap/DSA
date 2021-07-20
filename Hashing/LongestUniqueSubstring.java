/*https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1*/

//sliding window and hashing
class Solution
{
    int longestUniqueSubsttr(String S)
    {
        int i = 0, j = -1, n = S.length();
        int result = Integer.MIN_VALUE;
        int[] hash = new int[26];
        int lastIndex = -1;
        while (i < n && j < n-1) //till we reach the end
        {
            ++j; //increase the window size
            ++hash[S.charAt(j)-'a']; //add it to hash
            lastIndex = j; //store the last added index
            /*
            If the latest count is 1
			update the substring length
            */
            if (hash[S.charAt(lastIndex)-'a'] == 1)
                result = Math.max(result,j-i+1);
            /*
			Till the lastest added character that is repeating
			reduce window size from left
            */
            while (hash[S.charAt(lastIndex)-'a'] > 1)
                --hash[S.charAt(i++)-'a'];
        }
        return result;
    }
}

/*https://leetcode.com/problems/longest-substring-without-repeating-characters/*/

//leetcode version
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = -1, n = s.length();
        int result = Integer.MIN_VALUE;
        int[] hash = new int[256];
        int lastIndex = -1;
        while (i < n && j < n-1) //till we reach the end
        {
            ++j; //increase the window size
            ++hash[s.charAt(j)]; //add it to hash
            lastIndex = j; //store the last added index
            /*
            If the latest count is 1
            update the substring length
            */
            if (hash[s.charAt(lastIndex)] == 1)
                result = Math.max(result,j-i+1);
            /*
            Till the lastest added character that is repeating
            reduce window size from left
            */
            while (hash[s.charAt(lastIndex)] > 1)
                --hash[s.charAt(i++)];
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }
}