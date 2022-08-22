/*https://leetcode.com/problems/power-of-three/*/

//binary search
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 0) return false;
        int low = 0, high = 19, mid, pow;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            pow = (int)Math.pow(3,mid);
            if (pow == n) return true;
            else if (pow > n) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}

//recursion
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        return n%3 == 0 && isPowerOfThree(n/3);
    }
}

//one liner
public class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}