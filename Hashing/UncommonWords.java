/*https://leetcode.com/problems/uncommon-words-from-two-sentences/*/

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Boolean> map = new HashMap<String,Boolean>();
        String[] tokens = s1.split(" ");
        int falseCount = 0;
        for (int i = 0; i < tokens.length; ++i)
        {
            if (map.containsKey(tokens[i]))
            {
                if ((Boolean)map.get(tokens[i]))
                    ++falseCount;
                map.put(tokens[i],false);
            }
            else
                map.put(tokens[i],true);
        }
        tokens = s2.split(" ");
        for (int i = 0; i < tokens.length; ++i)
        {
            if (map.containsKey(tokens[i]))
            {
                if ((Boolean)map.get(tokens[i]))
                    ++falseCount;
                map.put(tokens[i],false);
            }
            else
                map.put(tokens[i],true);
        }
        String[] result = new String[map.size()-falseCount];
        int i = 0;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry elem = (Map.Entry)iter.next();
            if ((Boolean)elem.getValue())
                result[i++] = (String)elem.getKey();
        }
        return result;
    }
}