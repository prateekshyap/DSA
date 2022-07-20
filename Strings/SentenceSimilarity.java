/*https://www.lintcode.com/problem/856/description*/

public class Solution {
    /**
     * @param words1: a list of string
     * @param words2: a list of string
     * @param pairs: a list of string pairs
     * @return: return a boolean, denote whether two sentences are similar or not
     */
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        // write your code here
        if (words1.length != words2.length) return false;
        HashMap<String,Set<String>> map = new HashMap<String,Set<String>>();
        for (List<String> pair : pairs)
        {
            if (!map.containsKey(pair.get(0))) map.put(pair.get(0),new HashSet<String>());
            map.get(pair.get(0)).add(pair.get(1));
        }
        for (int i = 0; i < words1.length; ++i)
        {
            if (map.containsKey(words1[i]) && map.get(words1[i]).contains(words2[i])) continue;
            else if (map.containsKey(words2[i]) && map.get(words2[i]).contains(words1[i])) continue;
            else if (words1[i].equals(words2[i])) continue;
            else return false;
        }
        return true;
    }
}