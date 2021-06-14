/*https://leetcode.com/problems/contiguous-array/*/
/*Prateekshya's Solution*/
class Solution {
    public int findMaxLength(int[] nums) {
        int len = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        //add the base case
        map.put(0,-1);
        for (int i = 0; i < nums.length; ++i)
        {
            //add 1 if 1 else subtract 1
            sum += nums[i] == 0 ? -1 : 1;

            //if sum is already present, update length
            if (map.containsKey(sum) && i-((Integer)map.get(sum)) > len)
                len = i-((Integer)map.get(sum));

            //if sum is not present then add it            
            else if (!map.containsKey(sum))
                map.put(sum,i);
        }
        return len;
    }
}

/*Pratik's Solution*/
class Solution {
    public int findMaxLength(int[] nums) 
    {
        int n = nums.length;
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,0);
        nums[0] = (nums[0]==0?-1:1);
        map.put(nums[0],1);
        for(int i=1;i<n;i++)
        {
            nums[i] = nums[i-1]+(nums[i]==0?-1:1);
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],i+1);
            }
            else
            {
                max = Math.max(max,i+1-map.get(nums[i]));
            }
            System.out.println(nums[i]+" "+map.get(nums[i]));
        }
        return max;
    }
}