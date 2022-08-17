/*https://leetcode.com/problems/binary-trees-with-factors/*/

class Solution {
    HashMap<Integer,Integer> map;
    Long[] table;
    boolean[] rooted;
    int[] arr;
    private static final int m = (int)1e9+7;
    public int numFactoredBinaryTrees(int[] arr) {
        map = new HashMap<Integer,Integer>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; ++i)
            map.put(arr[i],i);
        rooted = new boolean[arr.length+1];
        long result = 0;
        this.arr = arr;
        table = new Long[arr.length];
        for (int i = arr.length-1; i >= 0; --i)
        {
            table[i] = count(i);
            result = (result+table[i])%m;
        }
        return (int)result;
    }
    private long count(int index)
    {
        if (table[index] != null) return table[index];
        long result = 1;
        
        for (int j = 0; j < index; ++j)
        {
            if (arr[index]%arr[j] == 0)
            {
                int k = arr[index]/arr[j];
                if (map.containsKey(k))
                    result = (result+count(j)*count(map.get(k)))%m;
            }
        }
        return table[index] = result;
    }
}