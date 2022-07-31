/*https://leetcode.com/problems/remove-invalid-parentheses/*/

class Solution {
    Set<String> validExps;
    int minRemoved;
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0, n = s.length();
        minRemoved = Integer.MAX_VALUE;
        validExps = new HashSet<String>();
        recur(s,0,0,0,0,new StringBuilder());
        return new ArrayList<String>(validExps);
    }
    private void recur(String s, int index, int lc, int rc, int removed,StringBuilder exp)
    {
        if (index == s.length())
        {
            if (lc == rc && removed < minRemoved)
            {
                validExps = new HashSet<String>();
                validExps.add(exp.toString());
                minRemoved = removed;
            }
            else if (lc == rc && removed == minRemoved)
                validExps.add(exp.toString());
        }
        else
        {
            char ch = s.charAt(index);
            int len = exp.length();
            if (ch != '(' && ch != ')')
            {
                exp.append(ch);
                recur(s,index+1,lc,rc,removed,exp);
                exp.deleteCharAt(len);
            }
            else
            {
                recur(s,index+1,lc,rc,removed+1,exp);
                exp.append(ch);
                if (ch=='(')
                    recur(s,index+1,lc+1,rc,removed,exp);
                else if (rc < lc)
                    recur(s,index+1,lc,rc+1,removed,exp);
                exp.deleteCharAt(len);
            }
        }
    }
}

class Solution {
    Set<String> validExps;
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0, n = s.length();
        validExps = new HashSet<String>();
        for (int i = 0; i < n; ++i)
        {
            if (s.charAt(i) == '(') ++left;
            else if (s.charAt(i) == ')')
            {
                if (left == 0) ++right;
                if (left > 0) left = left-1;
            }
        }
        recur(s,0,0,0,left,right,new StringBuilder());
        return new ArrayList<String>(validExps);
    }
    private void recur(String s, int index, int lc, int rc, int left, int right, StringBuilder exp)
    {
        if (index == s.length())
        {
            if (left == 0 && right == 0)
                validExps.add(exp.toString());
        }
        else
        {
            char ch = s.charAt(index);
            int len = exp.length();
            if ((ch == '(' && left > 0) || (ch == ')' && right > 0))
                recur(s,index+1,lc,rc,left-(ch == '(' ? 1 : 0),right-(ch == ')' ? 1 : 0),exp);
            exp.append(ch);
            if (ch != '(' && ch != ')')
                recur(s,index+1,lc,rc,left,right,exp);
            else if (ch == '(')
                recur(s,index+1,lc+1,rc,left,right,exp);
            else if (rc < lc)
                recur(s,index+1,lc,rc+1,left,right,exp);
            exp.deleteCharAt(len);
        }
    }
}