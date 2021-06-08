/*https://leetcode.com/problems/design-a-stack-with-increment-operation/*/

class CustomStack {
    private int[] stack;
    private int top;
    
    public CustomStack(int maxSize) {
        this.top = -1;
        this.stack = new int[maxSize];
    }
    
    public void push(int x) {
        ++this.top;

        //if index exceeds capacity
        if (top == this.stack.length)
        {
        	//skip the current element
            top = stack.length-1;
            return;
        }

        //add if there is space in stack
        stack[top] = x;
    }
    
    public int pop() {
 		//standard pop operation
        if (top == -1) return -1;
        return stack[top--];
    }
    
    public void increment(int k, int val) {
        if (top == -1) return;

        //if k is greater than the stack size
        if (top+1 <= k)
        {
        	//increment all the elements
            for (int i = 0; i <= top; ++i)
                stack[i] += val;
        }
        //otherwise
        else
        {
        	//increment the bottom k elements
            for (int i = 0; i < k; ++i)
                stack[i] += val;
        }
    }
}