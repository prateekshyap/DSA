/*https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/*/

class Solution
{
    public int[] replaceElements(int[] arr)
    {
    	//store the rightmost element in max and store -1 in the last position
        int max = arr[arr.length-1];
        arr[arr.length-1] = -1;

        //return if array is of size 1
        if (arr.length == 1) return arr;

        //for every position except the last one
        for (int i = arr.length-2; i >= 0; --i)
        {
        	//hold the current element
            int curr = arr[i];

            //store the max at the current position
            arr[i] = max;

            //update the max
            max = Math.max(max,curr);
        }
        return arr;
    }
}