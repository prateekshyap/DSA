/*https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1*/

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(-1);
	    int currElem;
	    int[] result = new int[n];
	    for (int i = n-1; i >= 0; --i)
	    {
	        result[i] = -1;
	        while (stack.peek() != -1)
	        {
	            currElem = (Integer)stack.peek();
	            if (currElem < arr[i])
	            {
	                result[i] = currElem;
	                break;
	            }
	            else stack.pop();
	            
	        }
	        if ((Integer)stack.peek() < arr[i]) stack.push(arr[i]);
	    }
	    return result;
	} 
}
