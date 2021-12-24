/*https://practice.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1#*/

//O(n^2) solution
class Solution 
{
    static int[] maxOfMin(int[] arr, int n) 
    {
    	//initialize two stacks
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        //find out the max of all single element windows and store
        int max = Integer.MIN_VALUE;
        int[] result = new int[n];
        for (int i = 0; i < n; ++i)
        {
            s1.push(arr[i]);
            max = Math.max(max,arr[i]);
        }
        result[0] = max;

        //for rest of the windows
        int index = 1;
        while (index < n)
        {
            int i1 = -1, i2 = -1;
            max = Integer.MIN_VALUE;

            //till the first stack is empty
            while (!s1.isEmpty())
            {
                i2 = i1;
                i1 = s1.pop();

                //for each consecutive pairs
                if (i2 != -1 && i1 != -1)
                {
                	//push the minimum to the second stack
                    s2.push(Math.min(i1,i2));

                    //update the maximum
                    max = Math.max(max,s2.peek());
                }
            }

            //store the maximum in result
            result[index++] = max;

            //swap the two stacks
            Stack<Integer> temp = s1;
            s1 = s2;
            s2 = temp;
        }

        return result;
    }
}

//O(n) solution
class Solution 
{
    static int[] maxOfMin(int[] arr, int n) 
    {
        int[] result = new int[n];
        int[] leftMin = getLeftMin(arr,n);
        int[] rightMin = getRightMin(arr,n);
        for (int i = 0; i < n; ++i)
        {
            int len = rightMin[i]-leftMin[i]-1;
            result[len-1] = Math.max(result[len-1],arr[i]);
        }
        for (int i = n-2; i >= 0; --i)
            result[i] = Math.max(result[i], result[i+1]);
        return result;
    }
    static int[] getLeftMin(int[] arr, int n)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[n];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        stack.push(-1);
        for (int i = 0; i < n; ++i)
        {
            while (stack.peek() != -1 && arr[stack.peek()] >= arr[i])
                stack.pop();
            res[i] = stack.peek();
            stack.push(i);
        }
        return res;
    }
    static int[] getRightMin(int[] arr, int n)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[n];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        stack.push(-1);
        for (int i = n-1; i >= 0; --i)
        {
        	while (stack.peek() != -1 && arr[stack.peek()] >= arr[i])
                stack.pop();
            res[i] = stack.peek() == -1 ? n : stack.peek();
            stack.push(i);
        }
        return res;
    }
}