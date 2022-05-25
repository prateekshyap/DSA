/*https://leetcode.com/problems/majority-element/*/
/*https://binarysearch.com/problems/Majority-Vote*/

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

//binary search
import java.util.*;

class Solution {
    public int solve(int[] nums) {

        //moore's voting solution
        int i, n = nums.length;
        int maj = nums[0], counter = 1;
        for (i = 1; i < n; ++i)
        {
            if (maj == nums[i]) ++counter; else --counter;
            if (counter == 0)
            {
                maj = nums[i];
                counter = 1;
            }
        }

        //check for actual majority
        counter = 0;
        for (i = 0; i < n; ++i) if (nums[i] == maj) ++counter;

        if (counter > n/2) return maj;
        return -1;

        //hashing solution
        /*HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int i, n = nums.length;
        for (i = 0; i < n; ++i)
            map.put(nums[i], map.containsKey(nums[i]) ? (Integer)map.get(nums[i])+1 : 1 );
        Iterator it = map.entrySet().iterator();
        int result = 0, val = 0;
        while (it.hasNext())
        {
            Map.Entry elem = (Map.Entry)it.next();
            if ((Integer)elem.getValue() > result)
                {
                    result = (Integer)elem.getValue();
                    val = (Integer)elem.getKey();
                }
        }
        if (result > n/2) return val;
        return -1;*/
    }
}