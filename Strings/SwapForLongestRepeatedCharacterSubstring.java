/*https://leetcode.com/problems/swap-for-longest-repeated-character-substring/*/

class Solution {
    
    private static final int numLowerCaseCharacters = 26;
    
    private static final char a = 'a';
    
    public int maxRepOpt1(String text) {
        
        char[] textArr = text.toCharArray();
        
        int length  = textArr.length,
            left    = 0,
            longest = 0;
        
        int[] anagram = new int[numLowerCaseCharacters];
        
        for (char c : textArr)
            anagram[c - a]++;
        
        while (left < length) {
            
            char c = textArr[left];
            
            int next = 0,
                len  = 0,
				right = left;
            
            // check for block 1
            while (right < length && textArr[right] == c)
                right++;
            
            next = right;
            
            len = right - left;
            
            // check if block2 exists, and add the len
            if (++right < length && textArr[right] == c) {
                
                left = right;
                
                while (right < length && textArr[right] == c)
                    right++;
                
                // Add block 2 len
                len += (right - left);
                
            }
            
            // whether it is only 1 block or 2 blocks
            // if there is at least one character found outside the 1 or 2 block(s)
            // then it can be used to swap at end of block1 or the character between the 2 blocks
            // increasing the length after swap tp len + 1
            if ((anagram[c - a] - len) > 0)
                len++;
            
            // get the new longest
            longest = Math.max(longest, len);
            
            left = next; // set the pointers to the next character after block1
            
            
        }
        
        return longest;
        
    }
}