/*https://leetcode.com/problems/add-binary/*/

class Solution {
    public String addBinary(String x, String y) {
        StringBuffer result = new StringBuffer("");
        StringBuffer a = new StringBuffer(x);
        StringBuffer b = new StringBuffer(y);
        int sum = 0, carry = 0;

        //till the numbers are not exhausted
        while (a.length() > 0 && b.length() > 0)
        {
        	//extract the rightmost bits
            int bit1 = a.charAt(a.length()-1) == '0' ? 0 : 1; a.delete(a.length()-1,a.length());
            int bit2 = b.charAt(b.length()-1) == '0' ? 0 : 1; b.delete(b.length()-1,b.length());

            /*get the sum and carry
            put the formula of addition of three bits*/
            sum = bit1+bit2;
            sum += carry;
            
            if (sum > 1)
            {
                sum -= 2;
                carry = 1;
            }
            else
                carry = 0;
            
            result.append(sum);
        }

        StringBuffer rem = a.length() > 0 ? a : b;
        //add the carry, if any
        while (rem.length() > 0 && carry > 0)
        {
            int bit = rem.charAt(rem.length()-1) == '0' ? 0 : 1; rem.delete(rem.length()-1,rem.length());
            sum = bit+carry;
            if (sum > 1)
            {
                sum -= 2;
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            
            result.append(sum);
        }
        
        result.append(rem.reverse());
        
        if (carry > 0)
            result.append(carry);
        return result.reverse().toString();
    }
}