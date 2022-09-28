/*https://leetcode.com/problems/counting-words-with-a-given-prefix/*/

class Solution {
    public int prefixCount(String[] words, String pref) {
        int P = pref.length(), wordsCount = 0;
        for (String word : words)
        {
            int index = 0;
            while (index < P && index < word.length() && word.charAt(index) == pref.charAt(index)) ++index;
            if (index == P) ++wordsCount;
        }
        return wordsCount;
    }
}

class Solution {
    public int prefixCount(String[] words, String pref) {
        
        int prefixCount = 0;
        
        for(String word : words)
        {
            if(word.startsWith(pref))
            {
                prefixCount++;
            }
        }
        return prefixCount;
    }
}