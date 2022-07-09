/*https://practice.geeksforgeeks.org/problems/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/1/*/

class Solution {
    public static int maxSubStr(String str) {
       //Write your code here
       int sum = 0, count = 0;
       for (char ch : str.toCharArray())
       {
           sum += ch-'0' == 1 ? 1 : -1;
           count += sum == 0 ? 1 : 0;
       }
       return sum == 0 ? count : -1;
    }
}