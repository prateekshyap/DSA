/*https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/*/

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> knowledgeMap = new HashMap<String,String>();
        for (List<String> info : knowledge)
            knowledgeMap.put(info.get(0),info.get(1));
        StringBuilder build = new StringBuilder(""), result = new StringBuilder("");
        int i = 0, S = s.length();
        char ch;
        while (i < S)
        {
            ch = s.charAt(i);
            if (ch == '(')
            {
                build = new StringBuilder("");
                ++i;
                while (s.charAt(i) != ')')
                    build.append(s.charAt(i++));
                ++i;
                result.append(knowledgeMap.getOrDefault(build.toString(),"?"));
            }
            else result.append(s.charAt(i++));
        }
        return result.toString();
    }
}