/*
https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1#
Validate an IP Address 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
/* The function returns 1 if
IP string is valid else return 0
You are required to complete this method */
class Solution {
    public:
        int isValid(string s) {
            int n = s.length();
            if(n<=0) return 0; //empty string
            if(s[0]=='.' or s[n-1]=='.') return 0; //first or last char dot
            if(n<7 || n>15) return 0; // min ip to max ip length
            
            // calculating the number of dots
            int idot=0;
            // for(int i=1; i<n; i++)
            // {
            //     if(s[i-1]=='.' && s[i]=='.')
            //         return 0;
            //     if(s[i]=='.') idot++;
            // }
            // if(idot != 3) return 0;
            
            int num=0;
            for (int i=0; i<n; i++)  
            {  
                string t="";
                while(i<n && s[i]!='.' && s[i]>='0' && s[i] <= '9')
                    t += s[i++];
                    // cout<<t<<" ";
                if(t.length()>3 || t.length()==0) return 0; //""."".1.2
                num = stoi(t);
                if(num>255 || num<0) return 0;
                if(num==0 && t.length()>1) return 0; //00.00.00.00
                if(t[0] == '0' && t.length()>1) return 0; //01.02.03.04
                if(s[i]=='.') idot++;
            }  
            
            if(idot != 3) return 0;
            return 1;
        }
};

// { Driver Code Starts.

int main() {
    // your code goes here
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.isValid(s) << endl;
    }
    return 0;
}  // } Driver Code Ends