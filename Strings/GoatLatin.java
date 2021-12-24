/*https://leetcode.com/problems/goat-latin/*/

class Solution {
    public String toGoatLatin(String sentence) {
        StringBuffer wordIndex = new StringBuffer("a");
        StringBuffer result = new StringBuffer("");
        String[] tokens = sentence.split(" +");
        for (int i = 0; i < tokens.length; ++i)
        {
            StringBuffer sb = new StringBuffer(tokens[i]);
            char ch = tokens[i].charAt(0);
            if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'))
            {
                sb.delete(0,1);
                sb.append(tokens[i].charAt(0));
            }
            sb.append("ma");
            sb.append(wordIndex);
            wordIndex.append("a");
            result.append(sb);
            result.append(" ");
        }
        return result.toString().trim();
    }
}