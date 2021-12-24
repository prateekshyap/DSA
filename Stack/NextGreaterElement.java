/*https://leetcode.com/problems/next-greater-element-i/*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        //push -1 for base case
        stack.push(-1);
        for (int i = nums2.length-1; i >= 0; --i)
        {
        	//till stack has elements and stack top is less or equal to the current element, pop stack
            while (stack.peek() != -1 && stack.peek() <= nums2[i])
                stack.pop();

            //add current query and stack top to the map
            map.put(nums2[i],stack.peek());

            //push the current element to stack
            stack.push(nums2[i]);
        }

        //store the results according to the queries and return
        for (int i = 0; i < nums1.length; ++i)
            res[i] = (Integer)map.get(nums1[i]);
        return res;
    }
}