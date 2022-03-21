/*https://practice.geeksforgeeks.org/problems/decode-the-string2444/1*/

class Solution{
    static String decodedString(String s){
        // code here
        StringBuffer buffer = new StringBuffer(""), result = new StringBuffer("");
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<Integer> bracketStack = new Stack<Integer>();
        Stack<StringBuffer> contentStack = new Stack<StringBuffer>();
        StringBuffer integerVal = new StringBuffer("");
        
        for (int i = 0; i < s.length(); ++i)
        {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') //for digits
            {
                integerVal.append(ch); //keep appending in a buffer
                if (buffer.length() > 0) //push the substring to stack
                {
                	contentStack.push(buffer); //push
                	buffer = new StringBuffer(""); //reset
                }
            }
            else if (ch == '[') //for opening brackets
            {
                bracketStack.push(0); //push it into stack
                countStack.push(Integer.parseInt(integerVal.toString())); //push the count to stack
                integerVal = new StringBuffer(""); //reset it
            }
            else if (ch == ']') //for closing brackets
            {
                contentStack.push(buffer); //push buffer into stack
                buffer = new StringBuffer(""); //reset buffer
                int count = (Integer)countStack.pop(); //pop count
                bracketStack.pop(); //pop open bracket
                buffer = (StringBuffer)contentStack.pop(); //pop content
                StringBuffer temp = new StringBuffer("");
                for (int j = 0; j < count; ++j) //append content count times
                    temp.append(buffer);
                StringBuffer prev = contentStack.isEmpty() ? new StringBuffer("") : (StringBuffer)contentStack.pop();
                prev.append(temp);
                buffer = prev; //store expanded content
            }
            else buffer.append(ch); //append character to buffer
        }
        
        return buffer.toString(); //return buffer
    }
}