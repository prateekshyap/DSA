/*
https://leetcode.com/problems/ugly-number/
263. Ugly Number

*/

class Solution {
public:
    bool isUgly(int n) {
        
        if(n<=0) return false; // for negative number
        
        while(n>1)
        {
            if(n%2==0)
                n=n/2;
            else if(n%3==0)
                n=n/3;
            else if(n%5==0)
                n=n/5;
            else
                return false;
        }
        return true;
        
//         for(int i=2; i<=5 && n!=0; i++)
//         {
//             while(n%i==0) n/=i;
//         }
        
//         return n==1;
    }//end
};