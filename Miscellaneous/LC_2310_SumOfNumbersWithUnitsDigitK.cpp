/*
https://leetcode.com/problems/sum-of-numbers-with-units-digit-k/
2310. Sum of Numbers With Units Digit K

*/

class Solution {
public:
    int minimumNumbers_1(int num, int k) {
        if(num == 0) 
            return 0;
        if(k==0 && (num%10)!=0) return -1;
        
        int lastdigit = num%10;
        for(int s=1; s<=50; s++)
            if(k*s <= num && (k*s)%10 == lastdigit)
                return s;
        
        return -1;
    }
    
    int minimumNumbers(int num, int k) {
        if(num == 0) 
            return 0;
        if(k==0 && (num%10)!=0) return -1;
        
        int size=0;
        while(num>=k)
        {
            if(num%10 == k)
                return size+1;
            num -= k;
            size++;
        }
        
        return -1;
    }
};