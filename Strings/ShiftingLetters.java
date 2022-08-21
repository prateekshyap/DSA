/*https://leetcode.com/problems/shifting-letters/*/

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int temp;
        shifts[shifts.length-1] %= 26;
        for (int i = shifts.length-2; i >= 0; --i)
        {
            shifts[i] += shifts[i+1];
            shifts[i] %= 26;
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; ++i)
        {
            temp = arr[i]-'a';
            temp += shifts[i];
            if (temp > 25) temp -= 26;
            arr[i] = (char)(temp+'a');
        }
        return new String(arr);
    }
}