/*https://leetcode.com/problems/numbers-at-most-n-given-digit-set/*/

class Solution {
    int dp[];
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String number = ""+n;
        dp = new int[number.length()+1];
        dp[0] = 1;
        for (int i = 1; i < number.length(); ++i)
            dp[i] = digits.length*dp[i-1];
        dp[number.length()] = last(0,number,digits);
        int finalResult = 0;
        for (int i = 1; i <= number.length(); ++i)
            finalResult += dp[i];
        return finalResult;
    }
    
    public int last(int index,String number,String digits[]){
        if (index >= number.length())
            return 1;
        int res = 0;
        for (String t:digits)
        {
            int d = Integer.parseInt(t);
            if (d < (number.charAt(index)-'0'))
                res += dp[number.length()-index-1];
            else if (d == (number.charAt(index)-'0'))
                res += last(index+1,number,digits);
            else
                return res;
        }
        return res;
    }
}