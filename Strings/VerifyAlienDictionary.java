/*https://leetcode.com/problems/verifying-an-alien-dictionary/*/

/*Prateekshya*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] hash = new int[26];
        String[] translations = new String[words.length];

        //store the mappings of changed characters to actual characters
        for (int i = 0; i < 26; ++i)
            hash[order.charAt(i)-'a'] = i;

        //for each word
        for (int i = 0; i < words.length; ++i)
        {
        	//create the actual word and store in a new list
            StringBuilder buffer = new StringBuilder("");
            for (int j = 0; j < words[i].length(); ++j)
                buffer.append((char)(hash[words[i].charAt(j)-'a']+'a'));
            translations[i] = new String(buffer);

            //if the new word doesn't follow dictionary order, return false
            if (i-1 >= 0 && translations[i-1].compareTo(translations[i]) > 0) return false;
        }
        return true;
    }
}