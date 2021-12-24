/*https://leetcode.com/problems/majority-element/*/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int size = nums.length;
        for (int i = 0; i < size; ++i)
        {
            if (!map.containsKey(nums[i])) //if the element is not present
            {
                //add the element to hashmap
                map.put(nums[i],1);
                if (1 > size/2)
                    return nums[i];
            }
            else
            {
                int temp = (Integer)map.get(nums[i])+1; //increment the count
                map.put(nums[i],temp);
                //if the count becomes more than half of the size, return it
                if (temp > size/2)
                    return nums[i];
            }
        }
        return -1;
    }
}

//moore voting algo
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int size = nums.length;
        int majorityElement = nums[0], counter = 1;
        for (int i = 1; i < size; ++i)
        {
            //if the current element and candidate are same, upvote
            if (majorityElement == nums[i])
                ++counter;
            else
                --counter; //downvote using existing votes

            //when unable to downvote further
            if (counter == 0)
            {
                majorityElement = nums[i]; //change the candidate
                counter = 1; //reset the votes
            }
        }

        //check if the candidate is actually the majority element
        counter = 0;
        for (int i = 0; i < size; ++i)
            if (nums[i] == majorityElement)
                ++counter;
        if (counter > size/2)
            return majorityElement;
        return -1;
    }
}