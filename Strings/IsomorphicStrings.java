/*https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1*/
/*https://leetcode.com/problems/isomorphic-strings/*/

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

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sHash = new int[128], tHash = new int[128];
        Arrays.fill(sHash,-1);
        Arrays.fill(tHash,-1);
        int i = 0, n = s.length();
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        for (i = 0; i < n; ++i)
        {
            if (sHash[a[i]] != -1 && sHash[a[i]] != b[i]) return false;
            if (tHash[b[i]] != -1 && tHash[b[i]] != a[i]) return false;
            sHash[a[i]] = b[i];
            tHash[b[i]] = a[i];
        }
        return true;
    }
}