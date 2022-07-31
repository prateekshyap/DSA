/*https://leetcode.com/problems/decode-the-message/*/

class Solution {
    public String decodeMessage(String key, String message) {
        int[] mapping = new int[26];
        Arrays.fill(mapping,-1);
        int i = 0, n = key.length();
        for (char ch : key.toCharArray())
            if (ch != ' ' && mapping[ch-'a'] == -1)
                mapping[ch-'a'] = i++;
        StringBuilder decodedMessage = new StringBuilder("");
        for (char ch : message.toCharArray())
            decodedMessage.append(ch == ' ' ? " " : (char)(mapping[ch-'a']+'a'));
        return decodedMessage.toString();
    }
}