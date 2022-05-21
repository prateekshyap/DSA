/*https://leetcode.com/problems/excel-sheet-column-title/*/

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer result = new StringBuffer("");
        while (columnNumber-- > 0)
        {
            result.append((char)((columnNumber%26)+'A'));
            columnNumber/=26;
        }
        result.reverse();
        return result.toString();
    }
}