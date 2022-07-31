/*https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1/*/

 class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        long painterCount = 0, time = 0, low = -1, high = 0, mid = -1, result = 0;
        for (int num : arr)
        {
            if (num > low) low = num;
            high += num;
        }
        while (low <= high)
        {
            mid = low+(high-low)/2;
            time = 0; painterCount = 1;
            for (int num : arr)
            {
                time += num;
                if (time > mid)
                {
                    time = num;
                    ++painterCount;
                }
            }
            if (painterCount <= k)
            {
                result = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return result;
    }
}