/*https://leetcode.com/problems/sentence-similarity-iii/*/

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] a1 = sentence1.split(" +");
        String[] a2 = sentence2.split(" +");
        int s1 = 0, e1 = a1.length-1, s2 = 0, e2 = a2.length-1;
        while (s1 <= e1 && s2 <= e2)
        {
            if (a1[s1].equals(a2[s2])) { ++s1; ++s2;}
            else if (a1[e1].equals(a2[e2])) { --e1; --e2; }
            else return false;
        }
        return true;
    }
}