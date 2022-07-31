/*https://leetcode.com/problems/repeated-dna-sequences/*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<String>();
        HashSet<String> result = new HashSet<String>();
        String sub;
        int i;
        for (i = 0; i <= s.length()-10; ++i)
        {
            sub = s.substring(i,i+10);
            if (set.contains(sub)) result.add(sub);
            set.add(sub);
        }
        return new ArrayList<>(result);
    }
}