/*https://leetcode.com/problems/number-of-matching-subsequences/*/

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,TreeSet<Integer>> map = new HashMap<Character,TreeSet<Integer>>();
        int i, n = s.length();
        char ch;
        for (i = 0; i < n; ++i)
        {
            ch = s.charAt(i);
            if (!map.containsKey(ch)) map.put(ch,new TreeSet<Integer>());
            map.get(ch).add(i);
        }
        int count = 0;
        Integer index;
        boolean flag;
        for (String word : words)
        {
            ch = word.charAt(0);
            if (map.get(ch) == null) continue;
            index = map.get(ch).first();
            if (index == null) continue;
            flag = true;
            for (i = 1; i < word.length(); ++i)
            {
                ch = word.charAt(i);
                if (map.get(ch) == null)
                {
                    flag = false;
                    break;
                }
                index = map.get(ch).higher(index);
                if (index == null)
                {
                    flag = false;
                    break;
                }
            }
            if (flag) ++count;
        }
        return count;
    }
}

