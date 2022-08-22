/*https://leetcode.com/problems/power-of-four/*/

//binary search
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n < 0) return false;
        int low = 0, high = 15, mid, pow;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            pow = (int)Math.pow(4,mid);
            if (pow == n) return true;
            else if (pow > n) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}

//recursion
class Solution {
    public boolean isPowerOfFour(int n) {
   
       if(n==0){
           return false; 
        }
        if (n==1){
            return true ;
        }
        if (n%4!=0){
            return false;
        }
        return isPowerOfFour(n/4);
    }
}

//one liner
class Solution {
    public boolean isPowerOfFour(int n) {
        return (n > 0) && ((n&(n-1)) == 0) && ((n-1)%3 == 0);
    }
}