/*https://leetcode.com/problems/delete-characters-to-make-fancy-string/*/

class Solution {
    public String makeFancyString(String s) {
        char[] arr = s.toCharArray();
        int count = 0, streak = 1;
        
        for (int i = 1; i < s.length(); ++i)
        {
            if (streak >= 2 && s.charAt(i) == s.charAt(i-1)) arr[i] = '\0';
            if (s.charAt(i) == s.charAt(i-1))
                ++streak;
            else
                streak = 1;
        }
        
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < s.length(); ++i)
            if (arr[i] != '\0')
                result.append(arr[i]);
        
        return result.toString();
    }
}

class Solution {
    public String makeFancyString(String s) {
        char[] arr = s.toCharArray();
        int left = 1, streak = 1, n = s.length();
        char curr = arr[0];
        
        for (int i = 1; i < n; ++i)
        {
            if (curr != arr[i])
            {
                arr[left++] = arr[i];
                curr = arr[i];
                streak = 1;
                continue;
            }
            if (streak >= 2) continue;
            arr[left++] = arr[i];
            ++streak;
        }
        
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < left; ++i)
            result.append(arr[i]);
        
        return result.toString();
    }
}