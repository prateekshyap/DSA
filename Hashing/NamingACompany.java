/*https://leetcode.com/problems/naming-a-company/*/

class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] groups = new HashSet[26];
        for (int i = 0; i < 26; ++i)
            groups[i] = new HashSet<String>();
        for (String idea : ideas)
            groups[idea.charAt(0)-'a'].add(idea.substring(1));
        long result = 0;
        for (int i = 0; i < 25; ++i)
        {
            for (int j = i+1; j < 26; ++j)
            {
                long mutualSuffixes = 0;
                for (String ideaA : groups[i])
                    if (groups[j].contains(ideaA))
                        ++mutualSuffixes;
                result += 2*(groups[i].size()-mutualSuffixes)*(groups[j].size()-mutualSuffixes);
            }
        }
        return result;
    }
}