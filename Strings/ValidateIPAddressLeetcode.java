/*https://leetcode.com/problems/validate-ip-address/*/

class Solution {
    public String validIPAddress(String s) {
        if (s.length() == 0) return "Neither";
        boolean isV4 = true, isV6= true; //initially both are true

        //check for ipv4
        String[] tokens = s.split("[.]");
        if (s.charAt(0) == '.' || s.charAt(s.length()-1) == '.') isV4 = false; //false for dot at start or end
        if (tokens.length != 4) isV4 = false; //false for more than 4 parts
        if (isV4)
        {
            for (int i = 0; i < tokens.length; ++i)
            {
                if (tokens[i].length() >= 4)
                {
                    isV4 = false;
                    break;
                } //false for all strings of length greater than 3
                try
                {
                    int num = Integer.parseInt(tokens[i]);
                    if (!(num >= 0 && num <= 255))
                    {
                        isV4 = false; //false for out of range
                        break;
                    }
                    if (num < 10 && tokens[i].length() > 1)
                    {
                        isV4 = false; //false for extra zero
                        break;
                    }
                    if (num < 100 && tokens[i].length() > 2)
                    {
                        isV4 = false; //false for extra zero
                        break;
                    }
                }
                catch(NumberFormatException ne)
                {
                    isV4 = false; //false for presence of characters other than digits
                    break;
                }
            }
        }
        
        if (isV4) return "IPv4"; //return true for ipv4

        //check for ipv6
        tokens = s.split("[:]");
        if (s.charAt(0) == ':' || s.charAt(s.length()-1) == ':')
            isV6 = false; //false for dot at start or end
        if (tokens.length != 8) isV6 = false; //false for more than 4 parts
        if (isV6)
        {
            for (int i = 0; i < tokens.length; ++i)
            {
                if (tokens[i].length() >= 5 || tokens[i].length() == 0)
                {
                    isV6 = false;
                    break;
                } //false for all strings of length greater than 4
                for (char ch : tokens[i].toCharArray())
                    if (!((ch <= '9' && ch >= '0') || (ch >= 'a' && ch <= 'f') || (ch <= 'F' && ch >= 'A')))
                    {
                        isV6 = false;
                        break;
                    }
            }
        }
        
        if (isV6) return "IPv6"; //return true for ipv6
        return "Neither";
    }
}