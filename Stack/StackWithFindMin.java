/*https://practice.geeksforgeeks.org/problems/special-stack/1*/

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