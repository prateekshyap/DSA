/*https://leetcode.com/problems/zigzag-conversion/*/

class Solution {
    public String convert(String s, int numRows) {
        //edge case
        if (numRows == 1)
            return s;

        //find the gap
        int gap = numRows+(numRows-2);

        //to store the elements which will be present in the first row
        int[] pivots = new int[((s.length()-1)/gap)+2];

        //store the pivots
        int x = 0;
        for (int i = 0; i < pivots.length; ++i)
        {
            pivots[i] = x;
            x += gap;
        }
        
        StringBuffer result = new StringBuffer("");
        
        //adding the top elements
        for (int i = 0; i < pivots.length; ++i)
        {
            if (pivots[i] < s.length())
                result.append(s.charAt(pivots[i]));
        }
        
        //adding others except last row
        for (int row = 1; row < numRows-1; ++row) //excludes first and last row i.e. 0 and numRows-1
        {
            for (int i = 0; i < pivots.length; ++i)
            {
                //add the element before the pivot at row
                if (pivots[i]-row >= 0 && pivots[i]-row < s.length())
                    result.append(s.charAt(pivots[i]-row));

                //add the element after the pivot at row
                if (pivots[i]+row < s.length())
                    result.append(s.charAt(pivots[i]+row));
            }
        }
        
        //adding the last row
        for (int i = 0; i < pivots.length-1; ++i)
        {
            if ((pivots[i]+pivots[i+1])/2 < s.length())
                result.append(s.charAt((pivots[i]+pivots[i+1])/2));
        }
        
        return new String(result);
    }
}