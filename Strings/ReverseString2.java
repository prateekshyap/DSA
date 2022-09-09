/*https://leetcode.com/problems/reverse-string-ii/*/

class Solution {
    public String reverseStr(String s, int k) {
        int S = s.length();
        char[] arr = s.toCharArray();
        int window = 2*k;
        for (int i = 0; i < S; i += window)
            reverse(i,i+k-1,arr);
        return new String(arr);
    }
    private void reverse(int s, int e, char[] arr)
    {
        if (e >= arr.length) e = arr.length-1;
        while (s < e)
        {
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            ++s; --e;
        }
    }
}