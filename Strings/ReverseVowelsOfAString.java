/*https://leetcode.com/problems/reverse-vowels-of-a-string/*/

class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length-1;
        char temp;
        Set<Character> hash = new HashSet<Character>();
        hash.add('a'); hash.add('e'); hash.add('i'); hash.add('o'); hash.add('u');
        hash.add('A'); hash.add('E'); hash.add('I'); hash.add('O'); hash.add('U');
        while (i < j)
        {
            while (i < arr.length && !hash.contains(arr[i])) ++i;
            while (j >= 0 && !hash.contains(arr[j])) --j;
            if (i >= j) continue;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i; --j;
        }
        return new String(arr);
    }
}