/*https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/*/

class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] hash = new int[10];
        for (char i : num.toCharArray()) ++hash[i-'0'];
        StringBuffer buffer = new StringBuffer("");
        for (int i = 0; i < n; ++i) buffer.append(hash[i]);
        return buffer.toString().equals(num);
    }
}