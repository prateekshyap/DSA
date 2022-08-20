/*https://leetcode.com/problems/valid-perfect-square/*/

class Solution {
    public boolean isPerfectSquare(int num) {
        long sq, low = 1, high = Math.min(Math.max(1,num/2),1073741822), mid;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            sq = mid*mid;
            if (sq == num) return true;
            else if (sq < 0 || sq > num) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
}