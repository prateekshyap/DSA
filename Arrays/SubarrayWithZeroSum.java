/*https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1*/

class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        map.put(0,-1);
        for (int i = 0; i < n; ++i)
        {
            //store the prefixSum
            sum += arr[i];
            
            //check if the same sum is present somewhere
            if (map.containsKey(sum))
                return true;
            
            //add to the hashmap
            map.put(sum,i);
        }
        return false;
    }
}