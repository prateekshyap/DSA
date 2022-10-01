/*https://leetcode.com/problems/backspace-string-compare/*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        Stack<Character> sStack = new Stack<Character>();
        Stack<Character> tStack = new Stack<Character>();
        for (char ch : s.toCharArray())
        {
            if (ch == '#')
            {
                if (!sStack.isEmpty()) sStack.pop();
            }
            else sStack.push(ch);
        }
        for (char ch : t.toCharArray())
        {
            if (ch == '#')
            {
                if (!tStack.isEmpty())tStack.pop();
            }
            else tStack.push(ch);
        }
        if (sStack.size() != tStack.size()) return false;
        while (!sStack.isEmpty())
        {
            if (sStack.peek() != tStack.peek()) return false;
            sStack.pop();
            tStack.pop();
        }
        return true;
    }
}

class Solution {
    public boolean backspaceCompare(String S, String T) {
        String s = getString(S);
        String t = getString(T);
        return s.equals(t);
    }
    
    private String getString(String s) {
        StringBuilder str = new StringBuilder();
        char[] c = s.toCharArray();
        for (char ch : c) {
            if (ch == '#') {
                if ( str.length() != 0) {
                    str.deleteCharAt(str.length() - 1);
                }
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}