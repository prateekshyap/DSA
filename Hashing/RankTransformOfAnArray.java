/*https://leetcode.com/problems/rank-transform-of-an-array/*/

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int i, j, n = arr.length;
        int[] result = new int[n];
        HashMap<Integer,ArrayList<Integer>> indices = new HashMap<Integer,ArrayList<Integer>>();
        for (i = 0; i < n; ++i)
        {
            if (!indices.containsKey(arr[i])) indices.put(arr[i],new ArrayList<Integer>());
            indices.get(arr[i]).add(i);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        indices.forEach((k, v) -> { heap.add(k); });
        j = 1;
        while (!heap.isEmpty())
        {
            i = (Integer)heap.poll();
            for (Integer index : indices.get(i))
                result[index] = j;
            ++j;
        }
        return result;
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return arr;
        
        int[] copy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(copy);
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int last = copy[0], curr = 1;
        map.put(last,curr);
        
        for (int i = 1; i < copy.length; ++i)
        {
            if (copy[i] != last)
            {
                last = copy[i];
                ++curr;
                map.put(last, curr);
            }
        }
        
        for (int i = 0; i < arr.length; ++i)
            arr[i] = map.get(arr[i]);
        
        return arr;
    }
}