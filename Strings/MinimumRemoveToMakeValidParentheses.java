/*https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0, index = 0, n = s.length();
        char[] arr = s.toCharArray();

        //forward direction, deleting extra closing brackets
        while (index < n)
        {
            if (arr[index] == '(') ++count;
            else if (arr[index] == ')')
            {
                --count;
                if (count < 0)
                {
                    arr[index] = '\0';
                    count = 0;
                }
            }
            ++index;
        }

        //reverse direction, deleting extra opening brackets
        index = n-1;
        count = 0;
        while (index >= 0)
        {
            if (arr[index] == ')') ++count;
            else if (arr[index] == '(')
            {
                --count;
                if (count < 0)
                {
                    arr[index] = '\0';
                    count = 0;
                }
            }
            --index;
        }
        StringBuilder result = new StringBuilder("");
        for (char ch : arr)
            if (ch != '\0')
                result.append(ch);
        return result.toString();
    }
}