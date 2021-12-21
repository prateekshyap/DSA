/*https://practice.geeksforgeeks.org/problems/reverse-bits-1611130171/1/*/

class Solution
{
    public int reverseBits(int n)
    {
        int result = 0;
        while (n > 0)
        {
            result <<= 1;
            result += (n&1);
            n >>= 1;
        }
        return result;
    }
}

/*https://leetcode.com/problems/reverse-bits/*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n)
    {
        int answer = 0;
        int bit = 0;
        for (int i = 0; i < 32; i++) {
            bit = n & 1;
            answer = (answer << 1) + bit;
            n = n >>> 1;
        }
        return answer;
    }
    /*int power = 1;
    public int reverseBits(int n) {
        StringBuffer result = new StringBuffer(Integer.toBinaryString(n));
        result.reverse();
        while (result.length() < 32)
            result.append("0");
        int returnValue = getDecimalValue(result, 0);
        return returnValue;
    }
    public int getDecimalValue(StringBuffer result, int index)
    {
        if (index == result.length()-1)
            return Integer.parseInt(Character.toString(result.charAt(index)));
        int decimal = getDecimalValue(result,index+1);
        power <<= 1;
        decimal += Integer.parseInt(Character.toString(result.charAt(index)))*power;
        return decimal;
    }*/
}