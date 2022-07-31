/*
https://leetcode.com/problems/multiply-strings/
43. Multiply Strings

*/

class Solution {
public:
    /*
    string multiply(string num1, string num2) {
        
        if(num1[0]=='0' or num2[0]=='0') return "0";
        
        int n1 = num1.size();
        int n2 = num2.size();
        
        vector<int> pad(n1+n2, 0);
        for(int i=n1-1; i>=0; i--)
        {   
            int xi = num1[i]-'0';
            for(int j=n2-1; j>=0; j--)
            {
                int ind = i+j+1;
                pad[ind] += (xi)*(num2[j]-'0'); 
                pad[ind-1] += pad[ind]/10; //carry
                pad[ind] %= 10; // value
            }
        }
        
        string ans;
        int i=0;
        while(i<pad.size() && pad[i]==0)
            i++;
        while(i<pad.size())
            ans += pad[i++]+'0';
        
        return ans;
        
    }
    */
    /*
     string multiply(string num1, string num2) {
        
        if(num1[0]=='0' or num2[0]=='0') return "0";
        
        int n1 = num1.size();
        int n2 = num2.size();
        
        vector<int> pad(n1+n2, 0);
        for(int i=n1-1; i>=0; i--)
        {   
            for(int j=n2-1; j>=0; j--)
            {
                pad[i+j+1] += (num1[i]-'0')*(num2[j]-'0'); 
            }
        }
         
         int carry=0;
         for(int p=pad.size()-1; p>=0; p--)
            {
                carry += pad[p];
                pad[p] = carry%10; //value
                carry /= 10; // carry
            }
        
        string ans;
        int i=0;
        while(i<pad.size() && pad[i]==0)
            i++;
        while(i<pad.size())
            ans += pad[i++]+'0';
        
        return ans;
        
    }
    */
    
    string multiply(string num1, string num2) {
        
        if(num1[0]=='0' or num2[0]=='0') return "0";
        
        int n1 = num1.size();
        int n2 = num2.size();
        int val, ind;
        string result(n1+n2, '0');
        
        for(int i=n1-1; i>=0; i--)
        {   
            for(int j=n2-1; j>=0; j--)
            {
                ind = i+j+1;
                // mul of two digits + exisiting val there
                val = (num1[i]-'0')*(num2[j]-'0') + (result[ind]-'0'); 
                result[ind] = (val%10)+'0'; // store digit
                // add carry to front digit
                result[ind-1] = ((result[ind-1]-'0')+val/10) + '0';
            }
        }
         
        auto it = result.find_first_not_of("0");
        return result.substr(it);
        
    }
};