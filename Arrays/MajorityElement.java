/*https://leetcode.com/problems/majority-element/*/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int size = nums.length;
        for (int i = 0; i < size; ++i)
        {
            if (!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
                if (1 > size/2)
                    return nums[i];
            }
            else
            {
                int temp = (Integer)map.get(nums[i])+1;
                map.put(nums[i],temp);
                if (temp > size/2)
                    return nums[i];
            }
        }
        return -1;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int size = nums.length;
        int majorityElement = nums[0], counter = 1;
        for (int i = 1; i < size; ++i)
        {
            if (majorityElement == nums[i])
                ++counter;
            else
                --counter;
            if (counter == 0)
            {
                majorityElement = nums[i];
                counter = 1;
            }
        }
        counter = 0;
        for (int i = 0; i < size; ++i)
            if (nums[i] == majorityElement)
                ++counter;
        if (counter > size/2)
            return majorityElement;
        return -1;
    }
}