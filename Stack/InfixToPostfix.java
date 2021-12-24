/*https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1*/

class Solution
{
	public static String infixToPostfix(String exp) 
	{
		HashMap<Character,Integer> precedenceTable = new HashMap<Character,Integer>();
		precedenceTable.put('+',2);
		precedenceTable.put('-',2);
		precedenceTable.put('*',1);
		precedenceTable.put('/',1);
		precedenceTable.put('^',0);
		precedenceTable.put('(',3);
		Stack<Character> os = new Stack<Character>();
		StringBuilder postfix = new StringBuilder("");
		int i = 0; //index to iterate through the given infix expression
    	while (i < exp.length())
    	{
    		String ch = Character.toString(exp.charAt(i)); //holder string, holds the next character
    		if (!ch.equals("(") && !ch.equals(")") && !ch.equals("+") && !ch.equals("-") && !ch.equals("*") && !ch.equals("/") && !ch.equals("^")) // if ch is an operand
    		{
    			++i; //increment index
    			while (i < exp.length() && exp.charAt(i) != '(' && exp.charAt(i) != ')' && exp.charAt(i) != '+' && exp.charAt(i) != '-' && exp.charAt(i) != '*' && exp.charAt(i) != '/' && exp.charAt(i) != '^') //while next character is not an operator
    			{
    				ch += exp.charAt(i); //append it to the holder string
    				++i; //increment i
    			}
    			--i; //decrement i to ensure that i points to the last character of current holder string
    		}
    		if (ch.equals("("))//if holder string is open braces
    			os.push(ch.charAt(0)); //push it
    		else if (ch.equals(")")) //if holder string is closing braces
    		{
    			while(os.peek() != '(') // while top operator is not open braces
    				postfix.append(os.pop()); //pop and attach to the postfix expression
    			os.pop(); //pop the open brace
    		}
    		else if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("^")) // if holder string is an operator
    		{
    			if (os.isEmpty()) //if stack is empty
    				os.push(ch.charAt(0)); //push holder string
    			else if (precedenceTable.get(os.peek()) > precedenceTable.get(ch.charAt(0))) //if top operator is lower in precedence than holder string
    				os.push(ch.charAt(0)); //push holder string
    			else
    			{
    				while (!os.isEmpty() && precedenceTable.get(os.peek()) <= precedenceTable.get(ch.charAt(0))) //while stack is not empty and top operator is greater or equal in precedence than holder string
    					postfix.append(os.pop()); // pop and attach to the postfix expression
    				os.push(ch.charAt(0)); //push holder string
    			}
    		}
    		else //if holder string is an operand
    			postfix.append(ch); //append it to the postfix expression, parsing the string into double ensures that there are no integers
    		++i; //increment i
    	}
    	while (!os.isEmpty()) //while stack is not empty
    		postfix.append(os.pop()); //pop and attach
    	return new String(postfix);
	} 
}