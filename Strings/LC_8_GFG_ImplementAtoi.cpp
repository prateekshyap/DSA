/*
https://practice.geeksforgeeks.org/problems/implement-atoi/1#
Implement Atoi 
https://leetcode.com/problems/string-to-integer-atoi/
*/
//LC ----------------------------------------
class Solution {
public:
    int myAtoi(string str) {
        
        int result = 0;
        int sign = 1;
        
        int i=0;
        // if whitespaces then ignore.
        while (str[i] == ' ')
        {
            i++;
        }
        
        //SIGN
        if(str[i] == '-')
        {    
            sign = -1;
            i++;
        }
        else if(str[i] == '+')
            i++;
        
        if(isalpha(str[i])) //first alpha is character then return zero
            return 0;
        
        // digit conversion
        for(  ; i<str.length(); i++)
        {
            if(str[i] >= '0' && str[i] <= '9')
            {
                
                // handling overflow test case
                if (result > INT_MAX / 10 || (result == INT_MAX / 10 && (str[i] - '0') > 7)) //Value of INT_MAX is +2147483647, 7->INT_MAX % 10)
                {
                    if (sign == 1)
                        return INT_MAX;
                    else
                        return INT_MIN;
                }
                
               result = result * 10 + (str[i] - '0'); //shift // add digit
            }
            else 
            {
                return result*sign;
            }
            
        }
        
        return result*sign;
    }
};


// GFG----------------------------------------
// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution{
  public:
    /*You are required to complete this method */
    int atoi(string str) {
        //Your code here
        
        int result = 0;
        int sign = 1;
        
        int i=0;
        // if whitespaces then ignore.
        while (str[i] == ' ')
        {
            i++;
        }
        
        //SIGN
        if(str[i] == '-')
        {    
            sign = -1;
            i++;
        }
        // digit conversion
        for(  ; i<str.length(); i++)
        {
            int d =0;
            if(str[i] >= '0' && str[i] <= '9')
            {
                
                // handling overflow test case
                // if (result > INT_MAX / 10 || (result == INT_MAX / 10 && str[i] - '0' > 7))
                // {
                //     if (sign == 1)
                //         return INT_MAX;
                //     else
                //         return INT_MIN;
                // }
                
              d = str[i] - '0'; //relative value
              result = result * 10; //shift
              result = result + d; // add digit
            }
            else 
             return -1;
            
        }
        
        // if(signNeg) result = -result;
        
        return result*sign;
        
    }//end
};

// { Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		string s;
		cin>>s;
		Solution ob;
		cout<<ob.atoi(s)<<endl;
	}
}  // } Driver Code Ends