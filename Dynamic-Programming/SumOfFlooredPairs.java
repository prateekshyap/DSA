/*https://leetcode.com/problems/sum-of-floored-pairs/*/

//TLE
class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        Arrays.sort(nums);
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        int i, mult = 1, start, end;
        for (i = 0; i < nums.length; ++i)
            map.put(nums[i],(map.containsKey(nums[i]) ? (Integer)map.get(nums[i])+1 : 1));
        int[][] pairs = new int[map.size()][2];
        i = 0;
        for (Map.Entry elem : map.entrySet())
        {
            pairs[i][0] = (Integer)elem.getKey();
            pairs[i][1] = (Integer)elem.getValue();
            map.put(pairs[i][0],i);
            ++i;
        }
        long result = 0, sum = 0;
        int j, elem;
        for (i = 0; i < pairs.length; ++i)
        {
            j = i;
            elem = pairs[i][0];
            mult = 0;
            sum = 0;
            while (j < pairs.length)
            {
                sum = 0;
                ++mult;
                while (j < pairs.length && pairs[j][0] < elem*mult)
                {
                    sum += pairs[j][1];
                    ++j;
                }
                sum *= (mult-1)*(pairs[i][1]);
                result = (result+sum%1000000007)%1000000007;
            }
        }
        
        return (int)result;
    }
}

//efficient solution

/*
example if we have 2,5,9 in input 
 
 our range will be till 9
 
    0 1 2 3 4 5 6 7 8 9 
 2      1   1   1   1
 5            1
 9                    1
 -------------------------
    0 0 1   2 3 4   5 6      

once we have this acculmutaed array which gives us count of quotient till one number , 
now i loop over number and add the count on each number and return the sum 

example in this example i will take  ( 1 from 2 position, 3 from 5 position , 6 from 9th position ), return 10 as result 
*/

class Solution {
	public int sumOfFlooredPairs(int[] nums) {
		long mod = 1000000007;
		Arrays.sort(nums);
		int max = nums[nums.length-1];
		int[] counts = new int[max+1];
		long[] quotients = new long[max+1];
		for (int k : nums)
			++counts[k];
        int i, j;
		for (i = 1; i < max+1; ++i)
        {
			if (counts[i] == 0)
				continue;
			j = i;
			while (j <= max)
            {
				quotients[j] += counts[i];
				j = j+i;
			}
		}
		for (i = 1; i < max+1; ++i)
			quotients[i] = (quotients[i]+quotients[i-1])%mod;
		long sum = 0;
		for (int k : nums)
			sum = (sum+quotients[k])%mod;
		return (int)sum;
	}
}