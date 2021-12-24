/*https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1*/

class Solution {
    public boolean isValid(String s) {
        String[] tokens = s.split("[.]");
        if (s.charAt(0) == '.' || s.charAt(s.length()-1) == '.') return false; //false for dot at start or end
        if (tokens.length != 4) return false; //false for more than 4 parts
        for (int i = 0; i < tokens.length; ++i)
        {
            if (tokens[i].length() >= 4) return false; //false for all strings of length greater than 3
            try
            {
                int num = Integer.parseInt(tokens[i]);
                if (!(num >= 0 && num <= 255)) return false; //false for out of range
                if (num < 10 && tokens[i].length() > 1) return false; //false for extra zero
                if (num < 100 && tokens[i].length() > 2) return false; //false for extra zero
            }
            catch(NumberFormatException ne)
            {
                return false; //false for presence of characters other than digits
            }
        }
        return true;
    }
}