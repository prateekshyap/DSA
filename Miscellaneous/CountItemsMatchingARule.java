/*https://leetcode.com/problems/count-items-matching-a-rule/*/

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int index = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int i;
        
        for (List<String> item : items)
            if (item.get(index).equals(ruleValue))
                ++count;
        
        return count;
    }
}