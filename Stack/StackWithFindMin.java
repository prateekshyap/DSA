/*https://practice.geeksforgeeks.org/problems/special-stack/1*/
/*https://leetcode.com/problems/min-stack/*/

class GfG{
   public void push(int a,Stack<Integer> s)
   {
      //add code here.
      s.push(a);
   }
   public int pop(Stack<Integer> s)
   {
      //add code here.
      if (s.isEmpty()) return -1;
      return s.pop();
   }
   public int min(Stack<Integer> s)
   {
      //add code here.
      int min = Integer.MAX_VALUE;
      if (s.isEmpty()) return -1;
      for (int i = 0; i < s.size(); ++i)
         if (s.get(i) < min)
            min = s.get(i);
      return min;
   }
   public boolean isFull(Stack<Integer>s, int n)
   {
      //add code here.
      return s.size() == n;
   }
   public boolean isEmpty(Stack<Integer>s)
   {
      //add code here.
      return s.isEmpty();
   }
}

class MinStack {
    int[] stack, minElem;
    int top;

    public MinStack() {
        stack = new int[30000];
        minElem = new int[30000];
        top = -1;
    }
    
    public void push(int val) {
        if (top == -1)
        {
            ++top;
            stack[top] = val;
            minElem[top] = val;
        }
        else
        {
            ++top;
            stack[top] = val;
            minElem[top] = Math.min(stack[top],minElem[top-1]);
        }
    }
    
    public void pop() {
        --top;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minElem[top];
    }
}