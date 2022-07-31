/*https://www.interviewbit.com/problems/pick-from-both-sides/*/

public class Solution {
    public int solve(int[] A, int B) {
        int currSum = 0, n = A.length, i, sum, rightBorder = n-B;
        int[] suffixSum = new int[n];
        suffixSum[n-1] = A[n-1];
        for (i = n-2; i >= 0; --i)
            suffixSum[i] = suffixSum[i+1]+A[i];
        sum = suffixSum[rightBorder++];
        for (i = 0; i < B-1; ++i, ++rightBorder)
        {
            currSum += A[i];
            if (currSum+suffixSum[rightBorder] > sum)
                sum = currSum+suffixSum[rightBorder];
        }
        if (currSum+A[B-1] > sum) sum = currSum+A[B-1];
        return sum;
    }
}
