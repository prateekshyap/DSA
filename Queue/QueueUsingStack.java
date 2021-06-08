/*https://leetcode.com/problems/implement-queue-using-stacks/*/

class MyQueue {
    Stack<Integer> s1, s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	//move everything from stack 1 to stack 2
        while (!s1.isEmpty())
            s2.push(s1.pop());

        //push new element to stack 1
        s1.push(x);

        //move everything from stack 2 to stack 1
        while (!s2.isEmpty())
            s1.push(s2.pop());

        /*it ensures insertion at the bottom of stack 1,
        so that deletion will be as usual from top*/
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	//pop from stack 1
        return s1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	//return from stack 1
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (s1.isEmpty()) return true;
        return false;
    }
}