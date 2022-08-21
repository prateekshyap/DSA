/*https://leetcode.com/problems/camelcase-matching/*/

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int q, p, Q = queries.length, P = pattern.length(), qLen;
        List<Boolean> result = new ArrayList<Boolean>();
        
        for (String query : queries)
        {
            qLen = query.length();
            p = q = 0;
            while (q < qLen)
            {
                if (p < P && query.charAt(q) == pattern.charAt(p))
                {
                    ++q;
                    ++p;
                }
                else 
                {
                    if (query.charAt(q) <= 'Z')
                    {
                        p = -1;
                        break;
                    }
                    ++q;
                }
            }
            if (p == P) result.add(true);
            else result.add(false);
        }
        
        return result;
    }
}