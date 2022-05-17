/*https://leetcode.com/problems/happy-number/*/

class Solution {
    public boolean isHappy(int n) {
        /*if (n<7 && n>1)  return false;
        int sum = 0;
		//here base condition 
        if (n == 1)  return true;           
        while (n > 0) {
            int digit = n % 10;             //we taking last element 
            sum = sum + (digit * digit);    //squre it
            n = n / 10;                     //remove the last elment
        }

        return isHappy(sum);*/
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(n);
        int sum = 0, copy, dig;
        while (n != 1)
        {
            sum = 0;
            copy = n;
            while (copy > 0)
            {
                dig = copy%10;
                sum += dig*dig;
                copy /= 10;
            }
            n = sum;
            if (visited.contains(n)) return false;
            visited.add(n);
        }
        return true;
    }
}