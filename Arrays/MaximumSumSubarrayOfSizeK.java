/*https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1*/

class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        int currSum = 0, maxSum = 0;
        for (int i = 0; i < K; ++i)
            currSum += Arr.get(i);
        if (currSum > maxSum)
            maxSum = currSum;
        for (int i = K; i < N; ++i)
        {
            currSum -= Arr.get(i-K);
            currSum += Arr.get(i);
            if (currSum > maxSum)
                maxSum = currSum;
        }
        return maxSum;
    }
}