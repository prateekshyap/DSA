/*https://leetcode.com/problems/implement-stack-using-queues/*/

class MyStack {
    Queue<Integer> q1, q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        //add to the second queue
        q2.add(x);

        //if queue 1 has elements, add all of them to queue 2
        while (!q1.isEmpty())
            q2.add(q1.remove());

        //swap the queues
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;

        /*it ensures insertion at the bottom of queue 1,
        so that deletion can be done as usual from queue 1*/
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //dequeue from queue 1
        return q1.remove();
    }
    
    /** Get the top element. */
    public int top() {
        //return from queue1
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty()) return true;
        return false;
    }
}