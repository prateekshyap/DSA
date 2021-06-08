/*https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1*/

class Solution
{
    public String FirstNonRepeating(String A)
    {
        int[] hashTable = new int[26];

        //mark absence of all characters
        for (int i = 0; i < 26; ++i)
            hashTable[i] = -1;

        StringBuilder result = new StringBuilder("");
        
        //for every character
        for (int i = 0; i < A.length(); ++i)
        {
            char ch = A.charAt(i);

            //if absent, mark presence
            if (hashTable[ch - 'a'] == -1)
                hashTable[ch - 'a'] = i;

            //if present, mark multiple presence
            else
                hashTable[ch - 'a'] = -2;
            int min = Integer.MAX_VALUE;
            ch = '\0';

            //find the character with single presence and minimum index value
            for (int j = 0; j < 26; ++j)
                if(hashTable[j] > -1 && hashTable[j] < min)
                {
                    min = hashTable[j];
                    ch = (char)('a'+j);
                }

            //append to result
            result.append((min == Integer.MAX_VALUE) ? '#' : ch);
        }
        return new String(result);
    }
}