/*https://leetcode.com/problems/sender-with-largest-word-count/*/

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int n = messages.length, i;
        for (i = 0; i < n; ++i)
            map.put(senders[i],map.getOrDefault(senders[i],0)+messages[i].split(" ").length);
        int max = 0;
        String sender = "";
        for (Map.Entry entry : map.entrySet())
        {
            if ((Integer)entry.getValue() > max)
            {
                max = (Integer)entry.getValue();
                sender = (String)entry.getKey();
            }
            else if ((Integer)entry.getValue() == max)
            {
                if (sender.compareTo((String)entry.getKey()) < 0)
                    sender = (String)entry.getKey();
            }
        }
        return sender;
    }
}