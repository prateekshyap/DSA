/*https://leetcode.com/problems/count-prefixes-of-a-given-string/*/

class Solution {
    public int countPrefixes(String[] words, String s) {
        int prefixCount = 0;
        HashMap<String,Integer> wordSet = new HashMap<String,Integer>();
        for (String w : words)
            wordSet.put(w,wordSet.getOrDefault(w,0)+1);
        StringBuilder build = new StringBuilder();
        for (char ch : s.toCharArray())
        {
            build.append(ch);
            if (wordSet.containsKey(build.toString()))
                prefixCount += wordSet.get(build.toString());
        }
        return prefixCount;
    }
}

class Solution {
    public int countPrefixes(String[] words, String s) {
        int count =0;
        for(String str:words){
            if(s.startsWith(str)){
                count++;
            }
        }
        return count;
    }
}