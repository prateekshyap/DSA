/*https://leetcode.com/problems/subarray-sum-equals-k/submissions/*/

public class Solution {
    public int subarraySum(int[] arr, int s) {
        int count = 0, n = arr.length, sum = 0;
        HashMap<Integer,Integer> map = new HashMap <Integer,Integer>();
        map.put(0,1);
        for (int i = 0; i < n; ++i)
        {
        	//get the sum till the current point
            sum += arr[i];

            //if sum is present somewhere
            if (map.containsKey(sum-s))
                count += map.get(sum-s); //add the stored count

            //store the sum and its count to the hashtable
            map.put(sum,(map.containsKey(sum) ? map.get(sum)+1 : 1));
        }
        return count;
    }
}