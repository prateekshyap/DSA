/*https://practice.geeksforgeeks.org/problems/minimum-indexed-character-1587115620/1/*/

class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        // Your code here
        HashSet<Character> set = new HashSet<Character>();
        for (char ch : patt.toCharArray()) set.add(ch);
        int i, n = str.length();
        for (i = 0; i < n; ++i) if (set.contains(str.charAt(i))) return i;
        return -1;
    }
}