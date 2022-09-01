/*https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/*/

class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
		int n = s1.length();
        int xy = 0 , yx = 0;
        
        for (int i = 0 ; i < n ; i ++)
        {
            char c1 = s1.charAt(i) , c2 = s2.charAt(i);
            if (c1 == 'x' && c2 == 'y') xy++;
            else if (c1 == 'y' && c2 == 'x') yx++;
        }
        
        if (xy % 2 == 0 && yx % 2 == 0) return xy/2 + yx/2;
        else if (xy % 2 == 1 && yx % 2 == 1) return xy/2 + yx/2 + 2;
        return -1;
    }
}
