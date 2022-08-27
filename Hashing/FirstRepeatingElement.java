/*https://practice.geeksforgeeks.org/problems/first-repeating-element4018/1?*/

class Solution {
    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        int index = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; ++i)
        {
            if (map.containsKey(arr[i]))
                index = Math.min(index,map.get(arr[i])+1);
            if (!map.containsKey(arr[i])) map.put(arr[i],i);
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}