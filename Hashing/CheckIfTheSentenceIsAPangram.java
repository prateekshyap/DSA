/*https://leetcode.com/problems/check-if-the-sentence-is-pangram/*/

class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<Character>();
        for (char ch : sentence.toCharArray())
            set.add(ch);
        return set.size() == 26;
    }
}