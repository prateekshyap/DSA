/*https://leetcode.com/problems/largest-palindromic-number/*/

class Solution {
    public String largestPalindromic(String num) {
        int[] freq = new int[10];
        char[] nums = num.toCharArray();
        int i, req, n = nums.length, mid = -1;
        for (i = 0; i < n; ++i)
            ++freq[nums[i]-'0'];
        StringBuilder result = new StringBuilder("");
        for (i = 9; i >= 0; --i)
        {
            if (i == 0 && result.length() == 0)
            {
                if (freq[i] > 0 && mid == -1) mid = 0;
                break;
            }
            if (freq[i] >= 2)
            {
                req = freq[i]/2;
                while (req-- > 0)
                    result.append((char)(i+'0'));
            }
            if (freq[i]%2 == 1 && mid == -1)
                mid = i;
        }
        req = result.length();
        if (mid != -1)
            result.append(mid);
        for (i = req-1; i >= 0; --i)
            result.append(result.charAt(i));
        return result.toString();
    }
}