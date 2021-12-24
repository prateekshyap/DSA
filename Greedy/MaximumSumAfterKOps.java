/*https://practice.geeksforgeeks.org/problems/maximize-sum-after-k-negations1149/1*/

class Solution {
    public static long maximizeSum(long a[], int n, int k)
    {
        Arrays.sort(a);
        long smallest = (long)Math.pow(10,12)+5, sum = 0;

        //for each element
        for(int i = 0; i < n; ++i)
        { 
            //if k is still remaining
            if(k > 0)
            {
                //make the number positive if it is negative and decrement k
                if(a[i] < 0)
                {
                    a[i] = (-1)*a[i];
                    k--;
                }
            }

            //update the smallest number
            smallest = Math.min(smallest,a[i]);

            //update the sum
            sum += a[i];
        }

        //if the remaining k is odd
        if (k%2 == 1)
        {
            //subtract twice the smallest number
            sum -= (2*smallest);
        }
        
        return sum;
    }
}