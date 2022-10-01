/*https://leetcode.com/problems/reverse-only-letters/*/

class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length-1;
        while (l < r)
        {
            while (l < r && !isAlphabet(arr[l])) ++l;
            while (l < r && !isAlphabet(arr[r])) --r;
            if (l >= r) break;
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            ++l; --r;
        }
        return new String(arr);
    }
    private boolean isAlphabet(char ch)
    {
        if (ch >= 'a' && ch <= 'z') return true;
        if (ch >= 'A' && ch <= 'Z') return true;
        return false;
    }
}