/*https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1*/

class Pair implements Comparable<Pair>
{
    int val;
    int count;
    Pair(int v, int c)
    {
        val = v;
        count = c;
    }
    public int compareTo(Pair p)
    {
        if (this.count > p.count) return -1;
        if (this.count < p.count) return 1;
        return p.val-this.val;
    }
}

class Solution {
    public int[] topK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (Integer num : nums)
        {
            if (map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry elem = (Map.Entry)it.next();
            pq.add(new Pair((Integer)elem.getKey(), (Integer)elem.getValue()));
        }
        int[] result = new int[k];
        for (int i = 0; i < k; ++i)
            result[i] = pq.poll().val;
        return result;
    }
}