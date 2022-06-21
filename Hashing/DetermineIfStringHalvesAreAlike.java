/*https://leetcode.com/problems/determine-if-string-halves-are-alike/*/

class Solution
{
    public boolean halvesAreAlike(String s)
    {
        int n = s.length(), i, lv = 0, rv = 0;
        HashSet<Character> set = new HashSet<Character>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u'); 
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
        for (i = 0; i < n/2; ++i)
            if (set.contains(s.charAt(i)))
                ++lv;
        for (i = n/2; i < n; ++i)
            if (set.contains(s.charAt(i)))
                ++rv;
        return lv == rv;
    }
}