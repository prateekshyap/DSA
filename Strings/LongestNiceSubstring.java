/*https://leetcode.com/problems/longest-nice-substring/*/

class Solution {
    public String longestNiceSubstring(String s) {
        int left = 0; String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int[] UCArray = new int[26];
            int[] LCArray = new int[26];
            String temp = "";
            for (int j = i; j < s.length(); j++) {
                temp += s.charAt(j);
                if (s.charAt(j) >= 97)
                    LCArray[s.charAt(j) - 'a']++;
                else
                    UCArray[s.charAt(j) - 'A']++;
                
                boolean flag = false;
                for (int k = 0; k < 26; k++)
                    if ((LCArray[k] != 0 && UCArray[k] == 0) || (LCArray[k] == 0 && UCArray[k] != 0)) {
                        flag = true;
                        break;
                    }
                if (flag == false)
                    ans = ans.length() >= temp.length() ? ans : temp;
            }
        }
        return ans;
    }
}
