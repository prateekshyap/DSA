/*https://practice.geeksforgeeks.org/problems/smallest-factorial-number5929/1*/

class Solution
{
    int zeros(int mid)
    {
        int count = 0;
        while (mid != 0)
        {
            mid /= 5;
            count += mid;
        }
        return count;
    }
    
    int findNum(int n)
    {
        // Complete this function
        int low = 1, high = n*5, mid, result = -1;

        while(low <= high)
        {
            mid = low+((high-low)/2);
            
            if (zeros(mid) >= n)
            {
                result = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return result;
    }
}