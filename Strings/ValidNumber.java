/*https://leetcode.com/problems/valid-number/*/

class Solution {
    public boolean isNumber(String s) {
    	//first and last characters cannot be exponents, hence return false
        if (s.charAt(0) == 'e' || s.charAt(0) == 'E' || s.charAt(s.length()-1) == 'e' || s.charAt(s.length()-1) == 'E') return false;

        //split by exponents
        String[] tokens = s.split("[Ee]");

        //if there are zero tokens or greater than two tokens, return false
        if (tokens.length > 2 || tokens.length == 0) return false;

        boolean result = true;
        //if there is just one token, it can be either a decimal or an integer
        if (tokens.length == 1)
            result = isDecimal(tokens[0]) || isInteger(tokens[0]);
        //if there are two tokens, first token can be a decimal or an integer and second must be an integer
        else
            result = (isDecimal(tokens[0]) || isInteger(tokens[0])) && isInteger(tokens[1]);

        return result;
    }

    private boolean isDecimal(String s)
    {
    	//decimals cannot be of length zero
        if (s.length() == 0) return false;

        //decimals cannot contain only sign or dot
        if (s.length() == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '.')) return false;
        
        //decimals cannot contain only sign and dot
        if (s.length() == 2 && (s.charAt(0) == '+' || s.charAt(0) == '-') && s.charAt(1) == '.') return false;
        
        //if the first character is something apart from sign, dot or digit, return false
        if (!(s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '.' || (s.charAt(0) <= '9' && s.charAt(0) >= '0')))
            return false;

        //mark if dot is encountered
        boolean dotEncountered = s.charAt(0) == '.' ? true : false;

        //for rest of the characters apart from the first one
        for (int i = 1; i < s.length(); ++i)
        {
        	//if the first dot is encountered, mark it
            if (s.charAt(i) == '.' && !dotEncountered)
                dotEncountered = true;

            //if the second dot is encountered, return false
            else if (s.charAt(i) == '.' && dotEncountered)
                return false;

            //if the character is not a digit, return false
            else if (!(s.charAt(i) <= '9' && s.charAt(i) >= '0'))
                return false;
        }

        //return true if for loop is uninterrupted
        return true;
    }

    private boolean isInteger(String s)
    {
    	//integers cannot be of length zero
        if (s.length() == 0) return false;

        //integers cannot contain only sign
        if (s.length() == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-')) return false;

        //if the first character is something apart from sign or digit, return false
        if (!(s.charAt(0) == '+' || s.charAt(0) == '-' || (s.charAt(0) <= '9' && s.charAt(0) >= '0')))
            return false;

        //for rest of the characters apart from the first one
        for (int i = 1; i < s.length(); ++i)
        	//if the character is not a digit, return false
            if (!(s.charAt(i) <= '9' && s.charAt(i) >= '0'))
                return false;

        //return true if for loop is uninterrupted
        return true;
    }
}