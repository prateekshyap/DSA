/*https://practice.geeksforgeeks.org/problems/smallest-subset-with-greater-sum/1/*/

class Solution
{ 
    int minSubset(int[] Arr,int N)
    { 
        Arrays.sort(Arr);
        int i, j, breakPoint = 1, temp;
        for (i = 0, j = N-1; i < j; ++i, --j)
        {
            temp = Arr[i];
            Arr[i] = Arr[j];
            Arr[j] = temp;
        }
        long leftSum = 0, rightSum = 0;
        for (i = 1; i < N; ++i) rightSum += Arr[i];
        leftSum = Arr[0];
        if (leftSum > rightSum) return breakPoint;
        for (i = 1; i < N; ++i)
        {
            ++breakPoint;
            leftSum += Arr[i];
            rightSum -= Arr[i];
            //System.out.println(leftSum+" "+rightSum);
            if (leftSum > rightSum) return breakPoint;
        }
        return N;
    }
}