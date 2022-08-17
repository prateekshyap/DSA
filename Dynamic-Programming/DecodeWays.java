/*https://leetcode.com/problems/decode-ways/*/
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

//recursion and memoization
class Solution {
    int n;
    Integer[] table;
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        n = s.length();
        table = new Integer[n+1];
        table[0] = count(s.toCharArray(),0);
        return table[0];
    }
    private int count(char[] s, int index)
    {
        if (index == n) return table[index] = 1; //if all characters scanned, return 1
        
        if (table[index] != null) return table[index]; //memo return
        
        int curr;
        
        table[index] = 0; //initialize to 0
        
        curr = s[index]-'0'; //get the current character
        
        if (curr != 0) //if it is non-zero i.e. 1,2,...9 , it can be decoded to some character
            table[index] += count(s,index+1); //hence go for recursion call with next index
        else return table[index]; //if zero, return zero
        
        if (index < n-1) //if we have not reached the last index
        {
            curr = curr*10+s[index+1]-'0'; //add the next character
            if (curr <= 26) //if the value is within the limit
                table[index] += count(s,index+2); //then two characters can be decoded to some letter between k to z, hence go for recursion call with second next index
        }
        
        return table[index];
    }
}