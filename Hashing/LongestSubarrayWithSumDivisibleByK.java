/*https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1*/

class Solution
{
    int longSubarrWthSumDivByK(int a[], int n, int k)
	{
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] modArr = new int[n];
        int result = 0, sum = 0;

        //create mod array
        for (int i = 0; i < n; ++i)
        {
            sum += a[i];
            modArr[i] = ((sum%k)+k)%k;
        }

        //use mod values for hashing
        for (int i = 0; i < n; ++i)
        {
            if (modArr[i] == 0) result = i+1;
            else if (!map.containsKey(modArr[i])) map.put(modArr[i],i);
            else result = Math.max(result,i-map.get(modArr[i]));
        }
        
        return result;
    }
}