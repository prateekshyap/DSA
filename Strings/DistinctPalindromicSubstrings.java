/*https://practice.geeksforgeeks.org/problems/distinct-palindromic-substrings5141/1/*/

class Solution 
{ 
    Set<String> set;
    int palindromeSubStrs(String s) { 
        // code here 
        if (s == null || s.length() < 1) return 0;
        int start = 0, end = 0;
        set = new HashSet<String>();
        
        //for every character
        for (int i = 0; i < s.length(); i++) {

            //find the odd length maximum expansion
            expandAroundCenter(s, i, i);

            //find the even length maximum expansion
            expandAroundCenter(s, i, i + 1);
        }
        return set.size();
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;

        //expand till the end characters are same
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            set.add(s.substring(L,R+1));
            L--;
            R++;
        }
        return R - L - 1;
    }
}