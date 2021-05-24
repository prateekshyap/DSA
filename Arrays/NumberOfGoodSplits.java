/*https://leetcode.com/problems/number-of-good-ways-to-split-a-string/*/

class Solution {
    public int numSplits(String s) {
        if (s.length() <= 1) return 0;
        int[] leftHash = new int[26];
        int[] rightHash = new int[26];
        int leftUnique = 0, rightUnique = 0, goodSplitCount = 0;

        //for the initial window
        ++leftHash[(int)s.charAt(0)-97];
        ++leftUnique;
        for (int i = 1; i < s.length(); ++i)
        {
            int index = (int)s.charAt(i)-97;
            ++rightHash[index];
            if (rightHash[index] == 1)
                ++rightUnique;
        }
        if (leftUnique == rightUnique)
            ++goodSplitCount;

        //for next windows
        for (int i = 1; i < s.length()-1; ++i)
        {
            int index = (int)s.charAt(i)-97;

            //delete the current character from right hashtable
            --rightHash[index];
            
            //if the count becomes 0 then decrease the right unique count
            if (rightHash[index] == 0)
                --rightUnique;

            //add the current character to the left hash table
            ++leftHash[index];

            //if the count becomes 1, increment the left unique count
            if (leftHash[index] == 1)
                ++leftUnique;

            //if the unique counts are equal then increment the split count
            if (leftUnique == rightUnique)
                ++goodSplitCount;
        }
        return goodSplitCount;
    }
}