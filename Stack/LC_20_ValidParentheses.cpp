/*
https://leetcode.com/problems/valid-parentheses/
20. Valid Parentheses

*/
class Solution {
public:
    bool isValid(string s) {
        
        stack<char> st;
        
        for(char c: s)
        {
            char x = '\0';
            if(c == '(' || c == '{' || c == '[')
            {
                st.push(c);
                continue;
            }
            // if it is not openining paranthese
            
            if(st.empty()) return false; // stack cannot be empty here. in case of starting with closing bracket
           
            x = st.top();  st.pop();
            
            switch(c)
            {
                case ')' : 
                    if(x != '(') return false;
                    break;
                case '}' : 
                    if(x != '{') return false;
                    break;
                case ']' : 
                    if(x != '[') return false;
                    break;
            }
            
                
        }
        
        return st.empty();
    }//end
};