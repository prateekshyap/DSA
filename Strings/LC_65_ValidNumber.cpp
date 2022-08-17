/*
https://leetcode.com/problems/valid-number/
65. Valid Number
*/

class Solution {
public:
    // decimal number/integer + e/E + integer
    bool isNumber_1(string s) {
        int n = s.length();
        
        // if e/E is first/last char
        if(s[0] == 'e' || s[0] == 'E' || s[n-1] == 'e' || s[n-1] == 'E')
            return false;
        
        // check presence of e/E, dots, and other character
        int cnt_e = 0, pos_e = s.length();
        int cnt_dots=0, pos_dot = s.length()-1; //dot can present in the last also;
        int cnt_befDotSign=0, pos_befDotSign=-1;
        int cnt_aftDotSign=0, pos_aftDotSign=-1;
        int cnt_digits=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s[i] == 'e' or s[i] == 'E')
            {
                pos_e = i;
                cnt_e++;
            }
            else if(s[i] == '.')
            {
                pos_dot = i;
                cnt_dots++;
            }
            else if(s[i] == '+' || s[i] == '-')
            {
                if(cnt_e==0)
                {
                    pos_befDotSign=i;
                    cnt_befDotSign++;
                }
                else
                {
                    pos_aftDotSign=i;
                    cnt_aftDotSign++;
                }
            }
            else if(isdigit(s[i]))
                cnt_digits++;
            else if(isalpha(s[i])) // other character
                return false;
                
        }
        // cout<<cnt_e<<" "<<cnt_dots<<" "<<pos_dot<<" "<<pos_e<<endl;
        if(cnt_digits==0 || cnt_e > 1 || cnt_dots > 1 || (cnt_dots && pos_dot > pos_e)) 
            return false; // more than atmost one e/E, dots and dot if any should be before e/E
        // cout<<cnt_befDotSign<<" 1 "<<cnt_aftDotSign<<endl;
        if(cnt_befDotSign>1 || cnt_aftDotSign>1)
            return false; // if more sign
        // cout<<cnt_befDotSign<<" 2 "<<pos_befDotSign<<endl;
        if(cnt_befDotSign && pos_befDotSign!=0)
            return false; //sign not in front if present
        // cout<<cnt_aftDotSign<<" 3 "<<pos_aftDotSign<<endl;
        if(cnt_aftDotSign && pos_aftDotSign!=pos_e+1)
            return false; //sign not after e if present
        
        string bef_e = s.substr(0, pos_e); // if e present else whole string
        string aft_e = s.substr(pos_e + (cnt_e>0)); // if e present then e+after_string
        
        // cout<<bef_e<<" be\n ";
        // cout<<aft_e<<endl;
        
        // if dot present then check for decimal else integer
        if(((cnt_dots && is_decimal(bef_e) or is_integer(bef_e)) and is_integer(aft_e)))
            return true;
        else
           return false;
        
        
    }//end
           
    bool is_integer(string &s)
   {
        if(s.length()==1 && (s[0]=='+' || s[0]=='-' ))
           return false;
        
       for(int i=0; i<s.length(); i++)
        {
            if(s[i] == '+' or s[i] == '-')
                continue;
            else if(!isdigit(s[i]))
                return false;
       }

       return true;
   }
           
   bool is_decimal(string &s)
   {
       if(s.length()==1 && (s[0]=='+' || s[0]=='-' || s[0]=='.'))
           return false;
       
       for(int i=0; i<s.length(); i++)
        {
            if(s[i] == '+' or s[i] == '-' or s[i]=='.')
                continue;
            else if(!isdigit(s[i]))
                return false;
       }

       return true;
   }
    
    bool isNumber(string s) {
        bool foundDigit = false; //atleast one digit
        bool foundPeriod = false; // for period book keeping
        bool foundE = false; // for e/E 
        bool checkSign = true; // check for sign
        
        for(char c: s)
        {
            // check the sign once, then turns itself off
            if(checkSign and (c=='-' or c=='+'))
            {
                checkSign = false;
                continue;
            }
            checkSign = false;
            
            if(c == '.')
            {
                if(not foundE and not foundPeriod) // e/E se phle and first time 
                    foundPeriod=true;
                else
                    return false; // e/E ke baad, second time, 
                continue;
            }
            
            if(c == 'e' or c=='E')
            {
                if(not foundE and foundDigit) // phele e/E nhi mila and ek digit to mila ho
                    foundE = true;
                else
                    return false;
                checkSign = true; // check for sign once again.
                foundDigit = false; // check for digit once again.
                continue;
            }
            
            if(isdigit(c))
            {
                foundDigit = true;
                continue;
            }
            return false;
        }
        return foundDigit;
    }
};