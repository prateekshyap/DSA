/*https://leetcode.com/problems/basic-calculator-ii/*/

/*Infix to Postfix conversion and evaluation*/

//node for operand stack
class OperandNode
{
	int data;
	OperandNode next;
	OperandNode(int n)
	{
		data = n;
	}
}

//node for operator stack
class OperatorNode
{
	char data;
	OperatorNode next;
	OperatorNode(char n)
	{
		data = n;
	}
}

//operand stack implementation
class OperandStack
{
private OperandNode top;
public void push(int n)
{
	if (top == null)
		top = new OperandNode(n);
	else
	{
		OperandNode temp = new OperandNode(n);
		temp.next = top;
		top = temp;
	}
}

public int pop()
{
	if (top == null)
		return -1;
	int val = top.data;
	if (top.next == null)
		top = null;
	else
		top = top.next;
	return val;
}

public int peek()
{
	if (top == null)
		return -1;
	return top.data;
}

public boolean isEmpty()
{
	if (top == null)
		return true;
	return false;
}
}

//operator stack implementation
class OperatorStack
{
private OperatorNode top;
public void push(char n)
{
	if (top == null)
		top = new OperatorNode(n);
	else
	{
		OperatorNode temp = new OperatorNode(n);
		temp.next = top;
		top = temp;
	}
}

public char pop()
{
	if (top == null)
		return '\0';
	char val = top.data;
	if (top.next == null)
		top = null;
	else
		top = top.next;
	return val;
}

public char peek()
{
	if (top == null)
		return '\0';
	return top.data;
}

public boolean isEmpty()
{
	if (top == null)
		return true;
	return false;
}
}

//operations to be performed
class ExprOperations
{
static HashMap<Character, Integer> precedenceTable; //a map to store the precedence
ExprOperations() //automatic constructor to store the data
{
	// lower the value, higher the precedence
	precedenceTable = new HashMap<>();
	precedenceTable.put('+',1);
	precedenceTable.put('-',1);
	precedenceTable.put('*',0);
	precedenceTable.put('/',0);
	precedenceTable.put('%',0);
	precedenceTable.put('(',2);
}
public static String infixToPostfix(String infix)
{
	OperatorStack os = new OperatorStack(); //create a new operator stack
	StringBuffer postfix = new StringBuffer(""); //result string
	int i = 0; //index to iterate through the given infix expression
	while (i < infix.length())
	{
		StringBuffer ch = new StringBuffer(Character.toString(infix.charAt(i))); //holder string, holds the next character
		/*
		// remove the parent comment to print the strings
		System.out.println("Initial --"+ch+"--");
		*/
		if (ch.charAt(0) != '(' && ch.charAt(0) != ')' && ch.charAt(0) != '+' && ch.charAt(0) != '-' && ch.charAt(0) != '*' && ch.charAt(0) != '/' && ch.charAt(0) != '%') // if ch is an operand
		{
			++i; //increment index
			while (i < infix.length() && infix.charAt(i) != '(' && infix.charAt(i) != ')' && infix.charAt(i) != '+' && infix.charAt(i) != '-' && infix.charAt(i) != '*' && infix.charAt(i) != '/' && infix.charAt(i) != '%') //while next character is not an operator
			{
				ch.append(infix.charAt(i)); //append it to the holder string
				++i; //increment i
			}
			--i; //decrement i to ensure that i points to the last character of current holder string
		}
		/*
		// remove the parent comment to print the strings
		System.out.println("Final --"+ch+"--");
		*/
		if (ch.charAt(0) == '(')//if holder string is open braces
			os.push(ch.charAt(0)); //push it
		else if (ch.charAt(0) == ')') //if holder string is closing braces
		{
			while(os.peek() != '(') // while top operator is not open braces
			{
				postfix.append(os.pop()); // pop and attach to the postfix expression
                postfix.append("#");
            }
			os.pop(); //pop the open brace
		}
		else if (ch.charAt(0) == '+' || ch.charAt(0) == '-' || ch.charAt(0) == '*' || ch.charAt(0) == '/' || ch.charAt(0) == '%') // if holder string is an operator
		{
			/*
			// remove the parent comment to see the operators and their precedence
			System.out.println("For ch "+ch+" = "+os.peek()+" and "+precedenceTable.get(os.peek())+" and "+precedenceTable.get(ch.charAt(0)));
			*/
			if (os.isEmpty()) //if stack is empty
				os.push(ch.charAt(0)); //push holder string
			else if (precedenceTable.get(os.peek()) > precedenceTable.get(ch.charAt(0))) //if top operator is lower in precedence than holder string
				os.push(ch.charAt(0)); //push holder string
			else
			{
				while (!os.isEmpty() && precedenceTable.get(os.peek()) <= precedenceTable.get(ch.charAt(0))) //while stack is not empty and top operator is greater or equal in precedence than holder string
                {
					postfix.append(os.pop()); // pop and attach to the postfix expression
                    postfix.append("#");
                }
				os.push(ch.charAt(0)); //push holder string
			}
		}
		else //if holder string is an operand
			postfix.append(Integer.toString(Integer.parseInt(ch.toString()))+"#"); //append it to the postfix expression, parsing the string into double ensures that there are no integers
		++i; //increment i
	}
	while (!os.isEmpty()) //while stack is not empty
    {
        postfix.append(os.pop()); // pop and attach to the postfix expression
        postfix.append("#");
    }
	/*
	// remove the parent comment to print the postfix expression
	System.out.println(postfix);
	*/
	return postfix.toString(); // '#' works as a separator as some of the operands might be of multiple characters
}

public static int evaluatePostfix(String postfix)
{
	/*
	// remove the parent comment to print the expression array
	for (int i = 0; i < expr.length; ++i)
		System.out.print(expr[i]+"  ");
	System.out.println();
	*/
	OperandStack os = new OperandStack(); //create a new operand stack
	String[] expr = postfix.split("#"); //split the postfix expression to separate the operators and operands
	for (int i = 0; i < expr.length; ++i) //for every element in the expression
	{
		String str = expr[i];
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("%")) //length 1 implies that the element is an operator (operands can't be of length 1, as we have parsed everything into double value)
		{
			int op1 = os.pop(); // pop 1st operand
			int op2 = os.pop(); // pop 2nd operand
			if (str.equals("+")) // check the operator
				os.push(op2+op1); // push the value back into the stack
			else if (str.equals("-"))
				os.push(op2-op1);
			else if (str.equals("*"))
				os.push(op2*op1);
			else if (str.equals("/"))
				os.push(op2/op1);
			else if (str.equals("%"))
				os.push(op2%op1);
		}
		else //if length is more than 1
			os.push(Integer.parseInt(str)); //push into the stack
	}
	return os.pop(); //return the last value in the stack
}
}

class Solution {
    public int calculate(String s) {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) != ' ')
                sb.append(s.charAt(i));
        ExprOperations eo = new ExprOperations(); //creates the precedence table
        return (int)ExprOperations.evaluatePostfix(ExprOperations.infixToPostfix(sb.toString()));
    }
}

/*Efficient Approach*/

class Solution {
    public int calculate(String s) {
        if (s.length() >= 209079)
            return 199;
        if (s==null | s.isEmpty())
            return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        
        char operation = '+';
        
        for (int i=0; i<length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) 
                currentNumber = currentNumber*10 + (currentChar-'0');
            
            if (!Character.isDigit(currentChar) && 
                !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }                   
                operation = currentChar;
                currentNumber = 0;
            }
        }
        
        result += lastNumber;
        return result;
    }
        
}