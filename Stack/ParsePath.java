/*https://leetcode.com/problems/simplify-path/*/

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<String>();
                
        String[] tokens = path.split("/");

        for(int i = 0; i < tokens.length; ++i)
        {
             String str = tokens[i];
             
             if(str.length() == 0 || str.equals("."))
                continue;
            
             if(str.equals(".."))
                 if(!stack.isEmpty())
                    stack.pop();
             else
                stack.push(str);
        }
        
        if(stack.isEmpty())
            return "/";
        
        StringBuilder re = new StringBuilder(); 

        while(!stack.isEmpty())
        {
            re.insert(0,"/");
            re.insert(0,stack.pop());
        }
        
        re.insert(0,"/");
        re.deleteCharAt(re.length()-1);
        
        return re.toString();
    }
}
