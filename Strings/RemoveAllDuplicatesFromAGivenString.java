/*https://practice.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1/*/

class Solution {
    String removeDuplicates(String str) {
        // code here
        HashSet<Character> set = new HashSet<Character>();
        char[] arr = str.toCharArray();
        int i;
        for (i = 0; i < arr.length; ++i)
        {
            if (set.contains(arr[i])) arr[i] = '\0';
            set.add(arr[i]);
        }
        StringBuffer result = new StringBuffer("");
        for (char ch : arr)
            if (ch != '\0')
                result.append(ch);
        return result.toString();
    }
}