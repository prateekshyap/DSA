/*https://leetcode.com/problems/first-unique-character-in-a-string/*/

//hashtable solution
class Solution {
    public int firstUniqChar(String s) 
    {
        int[] hashTable = new int[26];
        for (int i = 0; i < 26; ++i)
            hashTable[i] = -1;

        for (int i = 0; i < s.length(); ++i)
        {
            char ch = s.charAt(i);

            //store the first index
            if (hashTable[ch-'a'] == -1)
                hashTable[ch-'a'] = i;

            //if encountered for the second time, store -inf
            else
                hashTable[ch-'a'] = Integer.MIN_VALUE;
        }
        int pos=-1;
        for (int i = 0; i < 26; ++i)
        {
            //if -1 or -inf, continue
            if (hashTable[i] == Integer.MIN_VALUE || hashTable[i] == -1) continue;

            //update pos
            if (pos == -1 || pos > hashTable[i])
                pos = hashTable[i];
        }
        return pos;
    }
}

//efficient solution
class Solution {
    public int firstUniqChar(String s) {
        int index = s.length();
        for (char i = 'a'; i <= 'z'; ++i) {

            //get the first index
            int first = s.indexOf(i);

            //if the character is present and the last index is same as the first index
            if (first != -1 && first == s.lastIndexOf(i)) {

                //update index
                if (index > first) {
                    index = first;
                }
            }
        }

        //return index
        if (index != s.length()) {
            return index;
        }
        return -1;
    }
}

/*Pratik's Solution*/

class Solution {
    public int firstUniqChar(String s) 
    {
        for(int i=0;i<s.length();i++)
        {
            if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i)))return i;
        }
        return -1;
    }
}