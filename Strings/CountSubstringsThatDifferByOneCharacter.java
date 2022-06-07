/*https://leetcode.com/problems/count-substrings-that-differ-by-one-character/*/

class Solution {
    public int countSubstrings(String s, String t) {
        int ans = 0, i, j, diff, x, y;
		for (i = 0; i < s.length(); ++i)
        {
			for (j = 0; j < t.length(); ++j)
            {
				diff = 0;
				x = i;
				y = j;
				while (x < s.length() && y < t.length())
                {
					if (s.charAt(x) != t.charAt(y)) ++diff;
					if (diff == 1) ++ans;
					if (diff == 2) break;
					++x;
					++y;
				}
			}
		}
		return ans;
    }
}

