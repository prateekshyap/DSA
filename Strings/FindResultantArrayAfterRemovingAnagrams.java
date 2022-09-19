/*https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/*/

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> remWords = new ArrayList<String>();
        int currWord = -1;
        for (String word : words)
        {
            int wordVal = 0;
            for (char ch : word.toCharArray())
                wordVal += 1<<(ch-'a');
            if (wordVal != currWord)
            {
                currWord = wordVal;
                remWords.add(word);
            }
        }
        return remWords;
    }
}