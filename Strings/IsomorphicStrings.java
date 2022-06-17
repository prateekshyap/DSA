/*https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1*/

class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        int[] hash1 = new int[26], hash2 = new int[26];
        int i, j, m = str1.length(), n = str2.length();
        if (m != n) return false;
        for (i = 0; i < m; ++i)
        {
            ++hash1[str1.charAt(i)-'a'];
            ++hash2[str2.charAt(i)-'a'];
        }
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        for (i = 0; i < m; ++i) 
        {
            if (map.containsKey(str1.charAt(i)) && (Character)map.get(str1.charAt(i)) != str2.charAt(i)) return false;
            map.put(str1.charAt(i),str2.charAt(i));
            if (hash1[str1.charAt(i)-'a'] != hash2[str2.charAt(i)-'a']) return false;
        }
        return true;
    }
}