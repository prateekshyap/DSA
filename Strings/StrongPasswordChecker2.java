/*https://leetcode.com/problems/strong-password-checker-ii/*/

class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int i, n = password.length();
        if (n < 8) return false;
        boolean big = false, small = false, digit = false, special = false;
        String specialCharacters = "!@#$%^&*()-+";
        for (i = 0; i < n-1; ++i)
        {
            if (password.charAt(i) <= 'z' && password.charAt(i) >= 'a') small = true;
            else if (password.charAt(i) <= 'Z' && password.charAt(i) >= 'A') big = true;
            else if (password.charAt(i) <= '9' && password.charAt(i) >= '0') digit = true;
            else if (specialCharacters.indexOf(password.charAt(i)) != -1) special = true;
            if (password.charAt(i) == password.charAt(i+1)) return false;
        }
        if (password.charAt(i) <= 'z' && password.charAt(i) >= 'a') small = true;
        else if (password.charAt(i) <= 'Z' && password.charAt(i) >= 'A') big = true;
        else if (password.charAt(i) <= '9' && password.charAt(i) >= '0') digit = true;
        else if (specialCharacters.indexOf(password.charAt(i)) != -1) special = true;
        return big && small && digit && special;
    }
}