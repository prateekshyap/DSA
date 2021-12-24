/*https://leetcode.com/problems/substring-with-concatenation-of-all-words/*/

class Solution
{
    public List<Integer> findSubstring(String s, String[] words)
    {
        int counter = 0, wordLen = words[0].length(), reqLen = words.length*wordLen;
        List<Integer> res = new ArrayList<Integer>();
         
        for (int k = 0; k < wordLen; ++k)
        {
            Map<String,Integer> reqFreq = new HashMap<String,Integer>();
            for(String w : words)
                reqFreq.put(w, reqFreq.getOrDefault(w, 0)+1);
            counter = reqFreq.size(); //uniq chars
            for (int j = k, i = k; j+wordLen <= s.length(); j += wordLen)
            {
                 String word = s.substring(j, j+wordLen);
                 if (reqFreq.containsKey(word))
                 {
                     reqFreq.put(word, reqFreq.get(word)-1);
                     if(reqFreq.get(word) == 0) //used up all the required chars for `ch`
                         --counter;
                 }
                 while(counter == 0 && i <= j)
                 {
                     if(j+wordLen-i == reqLen)
                         res.add(i);
                     word = s.substring(i, i+wordLen);
                     if (reqFreq.containsKey(word))
                     {
                         reqFreq.put(word, reqFreq.get(word)+1);
                         if(reqFreq.get(word) == 1)
                             ++counter;
                     }
                     i += wordLen;
                 }
             }
        }
        return res; 
     }
}