/*https://leetcode.com/problems/unique-morse-code-words/*/

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseTable = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<String>();
        for (String word : words)
        {
            StringBuilder str = new StringBuilder("");
            for (int i = 0; i < word.length(); ++i)
                str.append(morseTable[word.charAt(i)-'a']);
            set.add(str.toString());
        }
        return set.size();
    }
}