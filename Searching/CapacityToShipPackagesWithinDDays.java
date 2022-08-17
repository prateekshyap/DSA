/*https://practice.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1*/
/*https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/*/

class Solution {
    static int leastWeightCapacity(int[] arr, int N, int D) {
        // code here
        int min = 0, max = 0, mid, days, nextDays;
        int i, j;
        for (i = 0; i < N; ++i)
        {
            if (arr[i] > min)
                min = arr[i]; //minimum capacity should be the maximum value present in arr[i]
            max += arr[i]; //maximum capacity can be the sum of all arr[i] values
        }
        while (min <= max) //binary search
        {
            mid = min+((max-min)/2); //get mid
            days = getDays(arr,N,mid); //get number of days required for mid capacity
            nextDays = getDays(arr,N,mid-1); //get number of days required for mid-1 capacity
            if (days <= D && nextDays > D) return mid; //return mid if days is within limit but next days is not
            else if (days <= D) max = mid-1; //if both are within limit, decrease max, so that next time we shall check for a lower capacity
            else min = mid+1; //if none of them are within limit then increase min, so that capacity can be increased
        }
        return -1;
    }
    static int getDays(int[] arr, int N, int mid)
    {
        int currWeight = 0;
        int daysCount = 0;
        
        for (int i = 0; i < N; ++i) //for each arr[i] value
        {
            if (arr[i] > mid) return Integer.MAX_VALUE; //id it exceeds the capacity, return infinity
            if (currWeight+arr[i] <= mid) //if it can be added to current total weight
                currWeight += arr[i]; //add it
            else //otherwise
            {
                ++daysCount; //ship current weight in one day
                currWeight = arr[i]; //store next value in current weight
            }
        }
        ++daysCount; //ship the remaining amount in one day
        if (currWeight > mid) //if current weight exceeds capacity
            daysCount += currWeight/mid; //ship everything according to capacity
        return daysCount; //return the number of days taken to ship everything
    }
}

class Solution {
    int[] weights;
    int days;
    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;
        this.days = days;
        int n = weights.length, low = 0, high = 0, mid, result = -1;
        for (int weight : weights)
        {
            low = Math.max(low,weight);
            high += weight;
        }
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (isFeasible(mid))
            {
                result = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return result;
    }
    private boolean isFeasible(int target)
    {
        int requiredDays = 1, ship = 0;
        for (int weight : weights)
        {
            ship += weight;
            if (ship > target)
            {
                ++requiredDays;
                ship = weight;
            }
        }
        return requiredDays <= days;
    }
}