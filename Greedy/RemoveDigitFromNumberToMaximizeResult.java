/*https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/*/

class Solution {
    public String removeDigit(String number, char digit) {
        StringBuilder build = new StringBuilder(number);
        int lastIndex = -1, n = number.length();
        for (int i = 0; i < n; ++i)
        {
            if (number.charAt(i) == digit)
            {
                lastIndex = i;
                if (i+1 < n && number.charAt(i+1) > digit)
                {
                    build.deleteCharAt(i);
                    return build.toString();
                }
            }
        }
        build.deleteCharAt(lastIndex);
        return build.toString();
    }
}