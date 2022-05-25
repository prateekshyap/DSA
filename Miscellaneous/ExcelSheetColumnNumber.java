/*https://leetcode.com/problems/excel-sheet-column-number/*/
/*https://binarysearch.com/problems/The-Auditor*/


class Solution {
    public int titleToNumber(String columnTitle) {
        int columnNumber = 0;
        char[] columnTitleArr = columnTitle.toCharArray();
        boolean isFirst = true;
        for (char col : columnTitleArr)
        {
			columnNumber *= 26;
            columnNumber += col-'A';
            ++columnNumber;
        }
        return columnNumber;
    }
}