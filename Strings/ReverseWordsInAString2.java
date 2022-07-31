/*https://www.lintcode.com/problem/927/*/

public class Solution {
    /**
     * @param str: a string
     * @return: return a string
     */
    public String reverseWords(String str) {
        // write your code here
        String[] arr = str.split(" +");
        int i = 0, j = arr.length-1;
        String temp;
        while (i < j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i; --j;
        }
        StringBuilder result = new StringBuilder();
        for (String s : arr)
        {
            result.append(s);
            result.append(" ");
        }
        return result.toString().trim();
    }
}