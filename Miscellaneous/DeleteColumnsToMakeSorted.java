/*https://leetcode.com/problems/delete-columns-to-make-sorted/*/

class Solution {
    public int minDeletionSize(String[] strs) {
        int columnCount = 0, columns = strs[0].length(), rows = strs.length;
        for (int i = 0; i < columns; ++i)
        {
            int prev = -1;
            for (int j = 0; j < rows; ++j)
            {
                int next = strs[j].charAt(i)-'a';
                if (next < prev)
                {
                    ++columnCount;
                    break;
                }
                prev = next;
            }
        }
        return columnCount;
    }
}