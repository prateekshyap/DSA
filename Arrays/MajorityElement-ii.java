/* https://leetcode.com/problems/majority-element-ii/ */
/* Using Extra space */
class Solution {
    public List<Integer> majorityElement(int[] nums) 
    {
        int n = nums.length, k = n/3;
        List<Integer> list = new LinkedList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }
            else
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            if(map.get(nums[i])==k+1)
            {
                list.add(nums[i]);
            }
        }
        return list;
    }
}

/* Without extra space but nlogn time */
class Solution {
    public List<Integer> majorityElement(int[] nums) 
    {
        Arrays.sort(nums);
        int i = 0;
        int n = nums.length, k = n/3;
        List<Integer> list = new LinkedList<Integer>();
        while(i+k<n)
        {
            if(nums[i]==nums[i+k])
            {
                list.add(nums[i]);
                i = k==0?i+1:i+k;
                while(i>0 && i<n && nums[i]==nums[i-1])i++;
            }
            else
            {
                i++;
            }
        }
        return list;
    }
}

/* Please Notify me once you get any O(N) time and O(1) space solution */