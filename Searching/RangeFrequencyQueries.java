/*https://leetcode.com/problems/range-frequency-queries/*/

class RangeFreqQuery {
    Map<Integer,TreeSet<Integer>> rough;
    Map<Integer,int[]> map;
    public RangeFreqQuery(int[] arr) {
        rough = new HashMap<Integer,TreeSet<Integer>>();
        map = new HashMap<Integer,int[]>();
        for (int i = 0; i < arr.length; ++i)
        {
            rough.putIfAbsent(arr[i],new TreeSet<Integer>());
            rough.get(arr[i]).add(i);
        }
        for (Map.Entry entry : rough.entrySet())
        {
            TreeSet<Integer> set = (TreeSet)entry.getValue();
            int[] value = new int[set.size()];
            int index = 0;
            for (Integer val : set)
                value[index++] = val;
            map.put((Integer)entry.getKey(),value);
        }
        // for (Map.Entry entry : map.entrySet())
        // {
        //     System.out.print(entry.getKey()+"->");
        //     for (int obj : (int[])entry.getValue())
        //         System.out.print(obj+",");
        //     System.out.println();
        // }
    }
    
    public int query(int left, int right, int value) {
        int[] indices = map.get(value);
        if (indices == null) return 0;
        int low = 0, high = indices.length-1, mid, start = -1, end = -1;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (indices[mid] >= left)
            {
                start = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        low = 0; high = indices.length-1;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (indices[mid] <= right)
            {
                end = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        if (start != -1 && end != -1)
            return end-start+1;
        else return 0;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */