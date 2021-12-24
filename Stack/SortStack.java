/*https://practice.geeksforgeeks.org/problems/sort-a-stack/1*/

//bubble sort or merge sort are definite solutions

//a different solution
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		if (s.isEmpty()) return s;
		Stack<Integer> tempStack = new Stack<Integer>();
		while (!s.isEmpty())
		{
		    int topS = s.pop();
		    while (!tempStack.isEmpty() && topS < tempStack.peek())
		        s.push(tempStack.pop());
		    tempStack.push(topS);
		}
		return tempStack;
	}
}