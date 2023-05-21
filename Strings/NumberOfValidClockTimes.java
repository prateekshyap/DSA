/*https://leetcode.com/problems/number-of-valid-clock-times/*/

class Solution {
    public int countTime(String time) {
        return countTimes(time.toCharArray(),0);
    }
    private int countTimes(char[] time, int index)
    {
        if (index > 5) return 1;
        int count = 0;
        if (index == 0)
        {
            if (time[index] == '?')
            {
                time[index] = '0';
                count += countTimes(time,index+1);
                time[index] = '1';
                count += countTimes(time,index+1);
                if (time[index+1] == '?' || time[index+1] <= '3')
                {
                    time[index] = '2';
                    count += countTimes(time,index+1); 
                }
                time[index] = '?';
            }
            else count += countTimes(time,index+1);
        }
        else if (index == 1)
        {
            if (time[index] == '?')
            {
                for (char ch = '0'; ch <= '3'; ch = (char)(ch+1))
                {
                    time[index] = ch;
                    count += countTimes(time,index+1);
                }
                if (time[index-1] != '2')
                {
                    for (char ch = '4'; ch <= '9'; ch = (char)(ch+1))
                    {
                        time[index] = ch;
                        count += countTimes(time,index+1);
                    } 
                }
                time[index] = '?';
            }
            else count += countTimes(time,index+1);
        }
        else if (index == 3)
        {
            if (time[index] == '?')
            {
                for (char ch = '0'; ch <= '5'; ch = (char)(ch+1))
                {
                    time[index] = ch;
                    count += countTimes(time,index+1);
                }
                time[index] = '?';
            }
            else count += countTimes(time,index+1);
        }
        else if (index == 4)
        {
            if (time[index] == '?')
            {
                for (char ch = '0'; ch <= '9'; ch = (char)(ch+1))
                {
                    time[index] = ch;
                    count += countTimes(time,index+1);
                }
                time[index] = '?';
            }
            else count += countTimes(time,index+1);
        }
        else count += countTimes(time,index+1);
        return count;
    }
}

class Solution {
    public int countTime(String time) {
        int hours = 1;
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') hours = 24;
            else if (time.charAt(1) <= '3') hours = 3;
            else hours = 2;
        } else if (time.charAt(1) == '?') {
            if (time.charAt(0) <= '1') hours = 10;
            else hours = 4;
        }
        int minutes = 1;
        if (time.charAt(3) == '?') {
            if (time.charAt(4) == '?') minutes = 60;
            else minutes = 6;
        } else if (time.charAt(4) == '?') minutes = 10;
        return hours * minutes;
    }
}