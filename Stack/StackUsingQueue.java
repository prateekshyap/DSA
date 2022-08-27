/*https://leetcode.com/problems/implement-stack-using-queues/*/
/*https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1*/

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

class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
        // Your code here
        q1.add(a);
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
        // Your code here
        if (q1.size() == 0) return -1;
        while (q1.size() != 1)
            q2.add(q1.poll());
        int val = q1.poll();
        while (!q2.isEmpty())
            q1.add(q2.poll());
        return val;
    }   
}