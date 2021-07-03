/*https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1*/

//using sliding window
class Solution {
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        int lastAdded = -1;
        int start = 0, end = -1;
        double product = 1;
        int count = 0;
        while (start < n && end < n)
        {
        	//extend the window
            while (end+1 < n && product*a[end+1] < k) 
            {
                ++end;
                product *= a[end];
            }

            //still if the window is reversed, start a new window from next position
            if (start > end)
            {
                lastAdded = start;
                ++start; ++end;
                product = 1;
                continue;
            }

            //current window length
            int windowLength = end-start+1;

            //window length of the already added elements
            int addedWindowLength = lastAdded-start+1;

            //calculate the number of subarrays and add it
            int totalTillNow = (int)(((double)windowLength*((double)windowLength+1)/2)-((double)addedWindowLength*((double)addedWindowLength+1)/2));
            count += totalTillNow;

            //mark the end of current window as the last added element
            lastAdded = end;

            //slide the window to right
            product /= a[start];
            ++start;

            //if window is reversed, reset product
            if (start > end) product = 1;
        }
        return count;
    }
}