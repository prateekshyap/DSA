/*https://leetcode.com/problems/maximum-deletions-on-a-string/*/

class Solution {
    Integer[] table;
    public int deleteString(String s) {
        table = new Integer[s.length()];
        HashSet<Character> set = new HashSet<Character>();
        for (char ch : s.toCharArray())
            set.add(ch);
        if (set.size() == 1) return s.length();
        return recur(s,0);
    }
    private int recur(String s, int index)
    {
        int count = 1;
        if (table[index] != null) return table[index];
        int n = s.length()-index;
        for (int i = 1; i <= n/2; ++i)
        {
            String s1 = s.substring(index+0,index+i);
            String s2 = s.substring(index+i,index+(2*i));
            if (s1.equals(s2))
            {
                int curr = 1+recur(s,index+i);
                count = Math.max(count,curr);
            }
        }
        return table[index] = count;
    }
}