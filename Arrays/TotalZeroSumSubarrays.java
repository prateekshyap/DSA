/*https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1*/

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        long count = 0,sum = 0;
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        map.put((long)0,1);
        for (int i = 0; i < n; ++i)
        {
            //store the prefixSum
            sum += arr[i];
            
            //check if the same sum is present somewhere
            if (map.containsKey(sum))
                count += map.get(sum);
            
            //add to the hashmap
            map.put(sum,(map.containsKey(sum) ? map.get(sum)+1 : 1));
        }
        return count;
    }
}