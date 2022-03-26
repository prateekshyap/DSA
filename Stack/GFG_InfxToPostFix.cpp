/*
https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1#
Infix to Postfix 

*/
// { Driver Code Starts
// C++ implementation to convert infix expression to postfix
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to convert an infix expression to a postfix expression.
    string infixToPostfix(string s)
    {
        string ans="";
        stack<char> optst; //operator stack
        
        for(char c: s)
        {
            // if it is character
            // if(c >= 'a' && c<= 'z' || c>= 'A' && c<='Z')
            if(c >= 'a' && c<= 'z')
            {
                ans+=c;
            }
            //if it is operator
            else
            {
                if(c == '(')
                    optst.push(c);
                else if (c == ')')
                    {
                        while(!optst.empty() && optst.top() != '(')
                        {
                            ans += optst.top();
                            optst.pop();
                        }
                        optst.pop(); // pop (
                    }
            // The order of precedence is: ^ greater than * equals to / greater than + equal to -
                else
                {
                    while(!optst.empty() && precedence(c) <= precedence(optst.top()) && isLeftToRightAssociative(c)) 
                    {    
                        ans += optst.top();
                        optst.pop();
                    }
                    optst.push(c);    
                }
                
            }// else op
            
        }// for c
        
        while(!optst.empty())
            {
                ans += optst.top();
                optst.pop();
            }
            
        return ans;
    }//end 
    
    int precedence(char ch)
    {
        if(ch == '+' || ch == '-')
            return 1;
        else if(ch == '*' || ch == '/')
            return 2;
        else if(ch == '^')
            return 3;
        else 
            return -1;
    }// end precedence
    
    bool isLeftToRightAssociative(char ch)
    {    return (ch != '^');
    }
};


// { Driver Code Starts.
//Driver program to test above functions
int main()
{
    int t;
    cin>>t;
    cin.ignore(INT_MAX, '\n');
    while(t--)
    {
        string exp;
        cin>>exp;
        Solution ob;
        cout<<ob.infixToPostfix(exp)<<endl;
    }
    return 0;
}
  // } Driver Code Ends