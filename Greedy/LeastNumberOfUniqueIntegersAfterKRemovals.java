/*https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k == arr.length) return 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int val : arr)
            map.put(val,map.getOrDefault(val,0)+1);
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>()
            {
                public int compare(int[] a, int[] b)
                {
                    return a[1]-b[1];
                }
            });
        for (Map.Entry elem : map.entrySet())
            heap.add(new int[]{(Integer)elem.getKey(),(Integer)elem.getValue()});
        while (!heap.isEmpty())
        {
            if (heap.peek()[1] <= k)
                k -= heap.poll()[1];
            else break;
        }
        return heap.size();
    }
}

class Solution {
    
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int a : arr) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        
        int remaining = count.size(), freq = 1;
        int[] freqs = new int[arr.length+1];
        for (int v : count.values()) {
            freqs[v]++; // how many numbers appear v times in the array
        }
        
        while (k > 0) {
            int f = freq * freqs[freq];
            
            if (f <= k) {
                k -= f;
                remaining -= freqs[freq++];
            } else {
                return remaining - k / freq;
            }
        }
        
        return remaining;
    }
}