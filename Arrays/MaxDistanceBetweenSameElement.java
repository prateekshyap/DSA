/*https://practice.geeksforgeeks.org/problems/max-distance-between-same-elements/1*/

class Solution
{
    int maxDistance(int arr[], int n)
    {
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    int max = 0;
	    for (int i = 0; i < n; ++i)
	    {
	        if (!map.containsKey(arr[i])) map.put(arr[i],i);
	        else if (i-(Integer)map.get(arr[i]) > max) max = i-(Integer)map.get(arr[i]);
	    }
	    return max;
    }
}