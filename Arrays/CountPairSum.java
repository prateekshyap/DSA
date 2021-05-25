/*https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1*/

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        for (int i = 0; i < n; ++i)
        {
            //if pair exists, add the count
            if (map.containsKey(k-arr[i]))
                count += map.get(k-arr[i]);

            //store by incrementing the count by 1
            map.put(arr[i],(map.containsKey(arr[i]) ? map.get(arr[i])+1 : 1));
        }
        return count;
    }
}