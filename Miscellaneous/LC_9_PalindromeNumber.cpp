/*
9. Palindrome Number
https://leetcode.com/problems/palindrome-number/
*/

class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0 || (x%10 ==0 and x!=0)) return false;
        // long rev = 0;
        // int copy = x;
        // while(copy)
        // {
        //     rev = rev*10 + copy%10;
        //     copy = copy/10;
        // }
        // return x == rev;
         int rev = 0;
         while(x>rev)
        {
            rev = rev*10 + x%10;
            x = x/10;
        }
        
        return (x==rev || x==rev/10);
    }
};