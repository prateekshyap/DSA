/*https://leetcode.com/problems/find-all-anagrams-in-a-string/*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    	//if pattern is longer than string, return empty list
        if (p.length() > s.length()) return new ArrayList<Integer>();
        int[] h = new int[26];
        List<Integer> l = new ArrayList<Integer>();

        //add frequencies for pattern
        for (int i = 0; i < p.length(); ++i)
            ++h[(int)p.charAt(i)-97];

        //subtract frequencies for the string
        for (int i = 0; i < p.length(); ++i)
            --h[(int)s.charAt(i)-97];

        //check if the pattern is present at 0th index
        boolean flag = true;
        for (int i = 0; i < 26; ++i)
            if (h[i] != 0)
                flag = false;
        if (flag)
            l.add(0);

        for (int i = 0; i < s.length()-p.length(); ++i)
        {
        	//sliding window approach
        	//remove the left most character and add the next character
            ++h[(int)s.charAt(i)-97]; --h[(int)s.charAt(i+p.length())-97];
            
            //check if the pattern is present in the window
            flag = true;
            for (int k = 0; k < 26; ++k)
                if (h[k] != 0)
                    flag = false;
            if (flag)
                l.add(i+1);
        }
        return l;
    }
}