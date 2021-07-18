/*https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1*/

//almost similar approach for any triplets question
class Solution
{
    long countTriplets(long arr[], int n, long target)
    {
        long count = 0;
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