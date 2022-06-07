/*https://binarysearch.com/problems/Largest-Anagram-Group*/

import java.util.*;

class Solution {
    public int solve(String[] words) {
        int i;
        char[] arr;
        String temp;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (i = 0; i < words.length; ++i)
        {
            arr = words[i].toCharArray();
            Arrays.sort(arr);
            temp = new String(arr);
            map.put(temp, map.containsKey(temp) ? (Integer)map.get(temp)+1 : 1);
        }
        int max = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry elem = (Map.Entry)it.next();
            max = Math.max(max,(Integer)elem.getValue());
        }
        return max;
    }
}