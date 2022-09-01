/*https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/*/

class Solution {
    public int convertTime(String current, String correct) {
        int currHour = 0, currMin = 0, corrHour = 0, corrMin = 0;
        currHour = (current.charAt(0)-'0')*10+(current.charAt(1)-'0');
        currMin = (current.charAt(3)-'0')*10+(current.charAt(4)-'0');
        corrHour = (correct.charAt(0)-'0')*10+(correct.charAt(1)-'0');
        corrMin = (correct.charAt(3)-'0')*10+(correct.charAt(4)-'0');
        if (corrMin < currMin)
        {
            --corrHour;
            corrMin += 60;
        }
        int hours = corrHour-currHour, mins = corrMin-currMin;
        int ops = 0;
        
        ops += hours; //60 mins operations

        //15 mins operations
        if (mins >= 45)
        {
            ops += 3;
            mins -= 45;
        }
        else if (mins >= 30)
        {
            ops += 2;
            mins -= 30;
        }
        else if (mins >= 15)
        {
            ++ops;
            mins -= 15;
        }
        
        //5 mins operations
        if (mins >= 10)
        {
            ops += 2;
            mins -= 10;
        }
        else if (mins >= 5)
        {
            ++ops;
            mins -= 5;
        }
        
        //1 mins operation
        ops += mins;
        
        return ops;
    }
}