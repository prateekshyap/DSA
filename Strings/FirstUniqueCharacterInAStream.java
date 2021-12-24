/*https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1*/

class Solution
{
    public String FirstNonRepeating(String A)
    {
    	//store -1 everywhere
        int[] hashTable = new int[26];
        for (int i = 0; i < 26; ++i)
            hashTable[i] = -1;

        StringBuilder result = new StringBuilder("");

        //for all streams
        for (int i = 0; i < A.length(); ++i)
        {
            char ch = A.charAt(i); //get the current character
            if (hashTable[ch - 'a'] == -1) //if it is not yet visited
                hashTable[ch - 'a'] = i; //store it
            else //otherwise
                hashTable[ch - 'a'] = -2; //mark as duplicate
            int min = Integer.MAX_VALUE;
            ch = '\0';

            //for every alphabet
            for (int j = 0; j < 26; ++j)
            	//if the character is visited only once
                if(hashTable[j] > -1 && hashTable[j] < min)
                {
                	//update the min
                    min = hashTable[j];
                    ch = (char)('a'+j);
                }

            //update the result
            result.append((min == Integer.MAX_VALUE) ? '#' : ch);
        }
        return new String(result);
    }
}