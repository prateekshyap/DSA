/*https://leetcode.com/problems/decode-ways/*/

class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int[] table = new int[s.length()];
        table[0] = 1;
        for (int i = 1; i < s.length(); ++i)
        {
        	//if the current character is zero and it cannot be attached to the previous character
            if (s.charAt(i) == '0' && (s.charAt(i-1) == '0' || s.charAt(i-1) >= '3'))
                return 0;

            //if previous character is 0 or greater than 2, cannot be attached
            else if (s.charAt(i-1) >= '3' || s.charAt(i-1) == '0')
                table[i] = table[i-1];

            //if previous character is 2 but current character is greater than 6, cannot be attached
            else if (s.charAt(i-1) == '2' && s.charAt(i) >= '7')
                table[i] = table[i-1];

            //if current character is zero and it's the character at index 1
            else if (s.charAt(i) == '0' && i == 1)
                table[i] = table[i-1];

            //if current character is zero
            else if (s.charAt(i) == '0')
                table[i] = table[i-2];

            //if current index is less than 2
            else if (i < 2)
                table[i] = table[i-1]*2;

            //for all other cases
            else
                table[i] = table[i-1]+table[i-2];
        }

        //return the final value
        return table[s.length()-1];
    }
}

