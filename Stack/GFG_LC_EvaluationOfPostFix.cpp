/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/
150. Evaluate Reverse Polish Notation

*/

/**************** GFG **********************/

// { Driver Code Starts
// C++ program to evaluate value of a postfix expression


#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to evaluate a postfix expression.
    int evaluatePostfix(string S)
    {
        stack<int> st;
        
        for(char c: S)
        {
          
           if(c == '+'|| c == '-'|| c == '*'|| c == '/')
           {
               int x2 = st.top(); st.pop(); 
               int x1 = st.top(); st.pop();
               if(c == '+') st.push(x1+x2);
               else if(c == '-') st.push(x1-x2);
               else if(c == '*') st.push(x1*x2);
                else st.push(x1/x2);
           }
            else // if it is operator
                st.push(c-'0');
            
        }
        
        return st.top();
    }
};

// { Driver Code Starts.

// Driver program to test above functions
int main()
{
    int t;
    cin>>t;
    cin.ignore(INT_MAX, '\n');
    while(t--)
    {
        string S;
        cin>>S;
        Solution obj;
    
    cout<<obj.evaluatePostfix(S)<<endl;
    }
    return 0;
}
  // } Driver Code Ends
  
 /********************** LC ************************/
		
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        
        stack<int> st;
        
        for(string t: tokens)
        {
          
           if(t == "+" || t == "-" || t == "*" || t == "/")
           {
               int x2 = st.top(); st.pop(); 
               int x1 = st.top(); st.pop();
               if(t == "+") st.push(x1+x2);
               else if(t == "-") st.push(x1-x2);
               else if(t == "*") st.push(x1*x2);
                else st.push(x1/x2);
           }
            else // if it is operator
                st.push(stoi(t));
            
        }
        
        return st.top();
    }//end
};