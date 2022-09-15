/*https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/*/

class Solution {
    public String maximumTime(String time) {
        char[] timeArr = time.toCharArray();
        if (timeArr[0] == '?') timeArr[0] = timeArr[1] != '?' && timeArr[1] >= '4' ? '1' : '2';
        if (timeArr[1] == '?') timeArr[1] = timeArr[0] == '2' ? '3' : '9';
        if (timeArr[3] == '?') timeArr[3] = '5';
        if (timeArr[4] == '?') timeArr[4] = '9';
        return new String(timeArr);
    }
}