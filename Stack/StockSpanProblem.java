/*https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1*/

class Solution
{
	public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[price.length];

        //for all prices
        for (int i = 0; i < price.length; ++i)
        {
        	//add the values from stack till the price is less or equal to current price
            while (!stack.isEmpty() && price[stack.peek()] <= price[i])
                result[i] += result[stack.pop()];
            
            //add the current element to the stack
            stack.push(i);

            //increment the current result by 1 for the current day
            result[i] += 1;
        }
        return result;
    }
    
}