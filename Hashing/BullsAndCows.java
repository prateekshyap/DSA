/*https://leetcode.com/problems/bulls-and-cows/*/

class Solution {
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray(), g = guess.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int n = s.length, i, bullCount = 0, cowCount = 0;
        for (i = 0; i < n; ++i)
        {
            if (s[i] == g[i])
            {
                ++bullCount;
                s[i] = g[i] = '\0';
            }
            else
            {
                map.put(s[i],map.containsKey(s[i]) ? (Integer)map.get(s[i])+1 : 1);
            }
        }
        for (i = 0; i < n; ++i)
        {
            if (g[i] != '\0' && map.containsKey(g[i]) && map.get(g[i]) > 0)
            {
                ++cowCount;
                map.put(g[i],(Integer)map.get(g[i])-1);
            }
        }
        StringBuffer result = new StringBuffer("");
        result.append(bullCount);
        result.append("A");
        result.append(cowCount);
        result.append("B");
        return result.toString();
    }
}

class Solution {
    public String getHint(String secret, String guess) 
    {
        int[] h = new int[10];
        
        int bulls = 0, cows = 0;
        int n = guess.length();
        for(int i = 0; i < n; i++)
        {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g) bulls++;
            else
            {
                if(h[s - '0'] < 0) cows++;
                if(h[g - '0'] > 0) cows++;
                h[s-'0']++;
                h[g-'0']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }
}