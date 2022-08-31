/*https://leetcode.com/problems/smallest-value-of-the-rearranged-number/*/

class Solution {
    public long smallestNumber(long num) {
        if (num < 0)
        {
            ArrayList<Integer> digits = new ArrayList<Integer>();
            num *= -1;
            while (num > 0)
            {
                digits.add((int)(num%10));
                num /= 10;
            }
            Collections.sort(digits);
            StringBuilder result = new StringBuilder("");
            for (int digit : digits)
            {
                result.append(digit);
            }
            result.reverse();
            return -1*Long.parseLong(result.toString());
        }
        else if (num > 0)
        {
            ArrayList<Integer> digits = new ArrayList<Integer>();
            while (num > 0)
            {
                digits.add((int)(num%10));
                num /= 10;
            }
            Collections.sort(digits);
            StringBuilder result = new StringBuilder("");
            int zeroCount = 0;
            for (int digit : digits)
            {
                if (digit == 0) ++zeroCount;
                else result.append(digit);
            }
            while (zeroCount-- > 0)
                result.insert(1,"0");
            return Long.parseLong(result.toString());
        }
        else return 0;
    }
}