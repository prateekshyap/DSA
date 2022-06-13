/*https://practice.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1*/

class Solution 
{ 
    String printSequence(String S) 
    { 
        // code here
        int[][] hash = new int[][]{{2,0},{2,1},{2,2},{3,0},{3,1},{3,2},{4,0},{4,1},{4,2},{5,0},{5,1},{5,2},{6,0},{6,1},{6,2},{7,0},{7,1},{7,2},{7,3},{8,0},{8,1},{8,2},{9,0},{9,1},{9,2},{9,3}};
        int i, n = S.length(), index;
        StringBuffer buffer = new StringBuffer("");
        for (char ch : S.toCharArray())
        {
            if (ch == ' ') buffer.append("0");
            else
            {
                index = hash[ch-'A'][1];
                for (i = 0; i <= index; ++i)
                    buffer.append(hash[ch-'A'][0]);
            }
        }
        return buffer.toString();
    }
}