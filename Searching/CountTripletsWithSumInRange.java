/*https://practice.geeksforgeeks.org/problems/triplets-with-sum-with-given-range/1/*/

class Solution {
    static int countTriplets(int arr[], int n, int L, int R) {
        return count(arr,n,R+1) - count(arr,n,L);
    }
    static int count(int arr[], int n, int target)
    {
        int count = 0;
        if (arr.length < 3) return count;
        Arrays.sort(arr);
        for (int i = 0; i < n-2; ++i)
        {
            int start = i+1;
            int end = arr.length-1;
            
            while (start < end)
            {
                if (arr[i] + arr[start] + arr[end] >= target)
                    --end;
                else
                {
                    count += (end-start);
                    ++start;
                }
            }
        }
        return count;
    }
}