/*https://leetcode.com/problems/find-common-characters/*/

class Solution {
    public List<String> commonChars(String[] words) {
        int[] hash = new int[26];
        for (int i = 0; i < words[0].length(); ++i)
            ++hash[words[0].charAt(i)-'a'];
        for (int i = 1; i < words.length; ++i)
        {
            int[] newHash = new int[26];
            for (int j = 0; j < words[i].length(); ++j)
                ++newHash[words[i].charAt(j)-'a'];
            for (int j = 0; j < 26; ++j)
            {
                if (newHash[j] == 0)
                    hash[j] = 0;
                else
                    hash[j] = Math.min(hash[j],newHash[j]);
            }
        }
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < 26; ++i)
            while (hash[i]-- > 0)
                result.add(Character.toString((char)(i+'a')));
        return result;
    }
}