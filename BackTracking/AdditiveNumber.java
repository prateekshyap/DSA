/*https://leetcode.com/problems/additive-number/*/

class Solution {
    public boolean isAdditiveNumber(String num) {
        return solve(num,0,0,0,0);
    }
    private boolean solve(String num, int index, int length, long sum, long prev)
    {
        if (index == num.length())
        {
            return length >= 3;
        }
        long curr = 0;
        for (int i = index; i < num.length(); ++i)
        {
            if (i > index && num.charAt(index) == '0') break;
            curr = curr*10+num.charAt(i)-'0';
            if (length >= 2)
            {
                if (sum < curr)
                    break;
                else if (sum > curr)
                    continue;
            }
            if (solve(num,i+1,length+1,curr+prev,curr))
                return true;
        }
        return false;
    }
}