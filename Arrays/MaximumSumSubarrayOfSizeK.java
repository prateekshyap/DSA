/*https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1*/
/*Prateekshya's Solution*/
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
/*Pratik's Solution*/
class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N)
    {
        int max = Integer.MIN_VALUE;
        // code here
        int cur = 0;
        for(int i = 0;i < K;i++)
        {
            cur+=Arr.get(i);
        }
        if(max<cur)max = cur;
        cur-=Arr.get(0);
        int left = 1,right = K;
        while(right<N)
        {
            cur+=Arr.get(right);
            if(cur>max)max=cur;
            cur-=Arr.get(left);
            left++;
            right++;
        }
        return max;
    }
}