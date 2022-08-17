/*
https://leetcode.com/problems/longest-valid-parentheses/
32. Longest Valid Parentheses

*/

class Solution {
public:
    int longestValidParentheses_1(string s) {
        
        if(s.empty())
            return 0;
        
        int len=0, curLen=0;
        stack<int> st;
        
        for(char ch: s)
        {
            if(ch == '(')
            {
                st.push(curLen);
                curLen = 0;
            }
            else if(ch == ')' and !st.empty())
            {
                curLen += 2 + st.top();  st.pop();
                len = max(len, curLen);
            }
            else //if(ch == ')' and st.empty())
            {
                curLen = 0;
            }
        }
        
        
        
        return len;
    }//end
    
     int longestValidParentheses_2(string s) {
        
        if(s.empty())
            return 0;
         
        vector<int> stack;
        int maxLen=0;
        stack.push_back(-1);
         
        for(int i=0; i<s.length(); i++)
        {
            if(s[i] == '(')
                stack.push_back(i);
            else
            {
                stack.pop_back();
                if(stack.empty())
                    stack.push_back(i);
                
                maxLen = max(maxLen, i-stack.back());
            }
        }
        return maxLen;
     }
    
     int longestValidParentheses(string s) {
        
        if(s.empty())
            return 0;
        int maxLen=0;
        
        int left=0, right=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s[i] == '(')
                left++;
            else
                right++;
            
            if(right > left)
            {   
                left = right = 0;
                continue;
            }
            
            if(left == right)
            {
                maxLen = max(maxLen, left+right);
            }
        }
         
         left=0, right=0;
         for(int i=s.length()-1; i>=0; i--)
        {
            if(s[i] == '(')
                left++;
            else
                right++;
            
            if(right < left)
            {   
                left = right = 0;
                continue;
            }
            
            if(left == right)
            {
                maxLen = max(maxLen, left+right);
            }
        }
         
        return maxLen;
     }
};