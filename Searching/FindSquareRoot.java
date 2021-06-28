/*https://practice.geeksforgeeks.org/problems/square-root/1/*/

//simple binary search approach
class Solution
{
    long x;
    long floorSqrt(long x)
    {
        this.x = x;
        return findSqrt(1,x);
    }
    long findSqrt(long low, long high)
    {
        if (low <= high)
        {
            long mid = (low+high)/2;
            if (mid*mid <= x && (mid+1)*(mid+1) > x) return mid;
            if (mid*mid < x) return findSqrt(mid+1,high);
            return findSqrt(low,mid-1);
        }
        return -1;
    }
}