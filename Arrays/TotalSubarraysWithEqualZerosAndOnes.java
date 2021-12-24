/*https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1*/

class Solution
{
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        int count = 0, sum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        for (int i = 0; i < n; ++i)
        {
            //add 1 for 1 and subtract 1 for 0
            sum += arr[i] == 1 ? 1 : -1;
            
            //check if the same sum is present somewhere
            if (map.containsKey(sum))
                count += map.get(sum);
            
            //add to the hashmap
            map.put(sum,(map.containsKey(sum) ? map.get(sum)+1 : 1));
        }
        return count;
    }
}