/*https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int N = nums.length;
        int[] numCopy = new int[N], result = new int[N];
        for (int i = 0; i < N; ++i)
            numCopy[i] = nums[i];
        Arrays.sort(numCopy);
        int count = 0;
        for (int i = 0; i < N; ++i)
        {
            if (i == 0 || numCopy[i] != numCopy[i-1])
                result[i] = count;
            else result[i] = result[i-1];
            ++count;
        }
        int[] map = new int[101];
        Arrays.fill(map,-1);
        for (int i = 0; i < N; ++i)
            map[numCopy[i]] = result[i];
        for (int i = 0; i < N; ++i)
            result[i] = map[nums[i]];
        return result;
    }
}

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
		int ans[]=new int[nums.length];
		int freq[]=new int[101];
		for(int i=0;i<nums.length;i++)
			freq[nums[i]]++;
		for(int i=1;i<freq.length;i++)
			freq[i]=freq[i]+freq[i-1];
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]==0)
				ans[i]=0;
			else
				ans[i]=freq[nums[i]-1];
		}
		return ans;
    }
}