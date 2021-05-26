/*https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1*/

class Solution {
    static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> fact = new ArrayList<Integer>();
        
        //add 1 to the factorial
        fact.add(1);
        
        //multiply from 2 to N
        for (int i = 2; i <= N; ++i)
            multiply(fact,i);
            
        //since the result is stored in reverse order
        Collections.reverse(fact);
        return fact;
    }
    static void multiply(ArrayList<Integer> fact, int next)
    {
        int i = 0;
        int totalDigits = fact.size();
        int carry = 0;
        
        //for each digit
        while (i < totalDigits)
        {
            //multiply with the number
            int product = next * (Integer)fact.get(i);
            
            //add the previous carry
            product += carry;
            
            //pick the LSB
            int LSB = product%10;
            
            //store the current carry
            carry = product/10;
            
            //set the new digit
            fact.set(i,LSB);
            
            //increment
            ++i;
        }
        
        //till the carry exists
        while (carry > 0)
        {
            //add the digits one by one
            fact.add(carry%10);
            carry /= 10;
        }
    }
}