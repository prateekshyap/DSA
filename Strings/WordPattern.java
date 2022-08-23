/*https://leetcode.com/problems/word-pattern/*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String,Character> map = new HashMap<String,Character>();
        HashMap<Character,String> rev = new HashMap<Character,String>();
        StringBuilder build = new StringBuilder("");
        String word = "";
        int N = s.length(), p = 0;
        char ch;
        for (int i = 0; i < N; ++i)
        {
            ch = s.charAt(i);
            if (ch != ' ')
                build.append(ch);
            else
            {
                word = build.toString();
                if (p >= pattern.length()) return false;
                if (map.containsKey(word))
                {
                    if (map.get(word) != pattern.charAt(p)) return false;
                }
                else if (rev.containsKey(pattern.charAt(p)) && rev.get(pattern.charAt(p)) != word)
                {
                    return false;
                }
                else
                {
                    map.put(word,pattern.charAt(p));
                    rev.put(pattern.charAt(p),word);
                }
                ++p;
                build = new StringBuilder("");
            }
        }
        word = build.toString();
        if (p >= pattern.length()) return false;
        if (map.containsKey(word))
        {
            if (map.get(word) != pattern.charAt(p)) return false;
        }
        else if (rev.containsKey(pattern.charAt(p)) && rev.get(pattern.charAt(p)) != word) return false;
        else
        {
            map.put(word,pattern.charAt(p));
            rev.put(pattern.charAt(p),word);
        }
        ++p;
        if (p < pattern.length()) return false;
        return true;
    }
}