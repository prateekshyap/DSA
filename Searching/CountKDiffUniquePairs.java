/*https://leetcode.com/problems/k-diff-pairs-in-an-array/*/

/*
The logic is, if the pair should be unique having same difference then
their sum can not be same, so we can use it as a key to store only unique pairs
*/
class Solution {
    public int findPairs(int[] arr, int n) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        HashSet<Integer> result = new HashSet<Integer>();

        //put the first element
        map.put(arr[0],0);

        //for rest all elements
        for (int i = 1; i < arr.length; ++i)
        {
        	//if map contains the other element, add their sum to the result
            if (map.containsKey(arr[i]-n))
                result.add(arr[i]+arr[i]-n);
            if (map.containsKey(arr[i]+n))
                result.add(arr[i]+arr[i]+n);

            //put the current element in to the map
            map.put(arr[i],i);
        }

        //return the count
        return result.size();
    }
}