/*https://leetcode.com/problems/minimum-window-substring/*/
/*https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1*/

class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        int[] hash = new int[128];
        int len = Integer.MAX_VALUE, start = -1;
        int i = 0, j = -1, totalCount = 0;
        
        //hash t in hashtable ans reset i
        for (i = 0; i < t.length(); ++i)
            ++hash[(int)t.charAt(i)];
        i = 0;
        
        //till j reaches end of s
        while (j < s.length())
        {
        	//move i to a point in s such that the character at that point is present in t
            while (i <= j)
            {
                if (hash[(int)s.charAt(i)] != 0)
                    break;
                ++i;
            }

            //if j is less than i then set j to i-1
            if (j < i) j = i-1;

            //increment j (helps in loop termination)
            ++j;

            //break if string scanned completely
            if (j >= s.length()) break;

            //hash the jth character of s
            ++count[(int)s.charAt(j)];

            //if the count of s is less than or equal to that of t, increment total count
            if (count[(int)s.charAt(j)] <= hash[(int)s.charAt(j)]) ++totalCount;

            //till total count is equal to the length of t
            while (totalCount == t.length())
            {
            	//keep updating length and starting point
                if (j-i+1 < len)
                {
                    len = j-i+1;
                    start = i;
                }

                //remove the first character of the current window of s from hash
                --count[(int)s.charAt(i)];

                //if count goes below the hash value of t, decrement total count
                if (count[(int)s.charAt(i)] < hash[(int)s.charAt(i)]) --totalCount;

                //slide the window
                ++i;
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}

//filtered S approach