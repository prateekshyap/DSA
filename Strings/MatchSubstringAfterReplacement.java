/*https://leetcode.com/problems/match-substring-after-replacement/*/

class Solution {
    public boolean matchReplacement(String str, String subStr, char[][] mappings) {
        HashMap<Character,Set<Character>> map = new HashMap<Character,Set<Character>>();
        int i, j, k, sLen = str.length(), subLen = subStr.length();
        char startSub = '\0';
        boolean result;
        char[] s = str.toCharArray();
        char[] sub = subStr.toCharArray();
        for (char[] mapping : mappings)
        {
            if (!map.containsKey(mapping[0]))
                map.put(mapping[0],new HashSet<Character>());
            map.get(mapping[0]).add(mapping[1]);
        }
        for (i = 0; i <= sLen-subLen; ++i)
        {
            if (s[i] == sub[0] || (map.containsKey(sub[0]) && map.get(sub[0]).contains(s[i])))
            {
                result = true;
                for (j = i, k = 0; k < subLen; ++j, ++k)
                {
                    if (s[j] != sub[k] && (!map.containsKey(sub[k]) || !map.get(sub[k]).contains(s[j])))
                    {
                        result = false;
                        break;
                    }
                }
                if (result) return result;
            }
        }
        return false;
    }
}

class Solution {
    public boolean matchReplacement(String str, String subStr, char[][] mappings) {
        int i, j, k, sLen = str.length(), subLen = subStr.length();
        boolean result;
        char[] s = str.toCharArray();
        char[] sub = subStr.toCharArray();
        boolean[][] map = new boolean[128][128];
        for (char[] mapping : mappings)
            map[(int)mapping[0]][(int)mapping[1]] = true;
        for (i = 0; i <= sLen-subLen; ++i)
        {
            if (s[i] == sub[0] || map[sub[0]][s[i]])
            {
                result = true;
                for (j = i, k = 0; k < subLen; ++j, ++k)
                {
                    if (s[j] != sub[k] && !map[sub[k]][s[j]])
                    {
                        result = false;
                        break;
                    }
                }
                if (result) return result;
            }
        }
        return false;
    }
}