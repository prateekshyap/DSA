/*https://leetcode.com/problems/find-k-pairs-with-smallest-sums/*/

class Data implements Comparable<Data>
{
    int i, j, sum;
    Data(int i, int j)
    {
        this.i = i;
        this.j = j;
        this.sum = i+j;
    }
    
    @Override
    public int compareTo(Data d)
    {
        return d.sum-this.sum;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int i;
        Integer key;
        for (i = 0; i < nums2.length; ++i)
            map.put(nums2[i],i);
        boolean flag = true;
        PriorityQueue<Data> heap = new PriorityQueue<Data>();
        for (int val1 : nums1)
        {
            key = heap.isEmpty() ? null : map.lowerKey((heap.peek().sum)-val1+1);
            if (key == null && heap.size() >= k)
            {
                if (!flag) continue;
                flag = false;
                i = nums2.length-1;
            }
            else if (heap.size() < k) i = nums2.length-1;
            else i = map.get(key);
            for (; i >= 0; --i)
            {
                heap.add(new Data(val1,nums2[i]));
                if (heap.size() > k)
                    heap.poll();
            }
        }
        Data d;
        while (!heap.isEmpty())
        {
            List<Integer> list = new ArrayList<Integer>();
            d = heap.poll();
            list.add(d.i);
            list.add(d.j);
            result.add(list);
        }
        return result;
    }
}

class Data implements Comparable<Data>
{
    int i, j, jIn, sum;
    Data(int i, int j, int jIn)
    {
        this.i = i;
        this.j = j;
        this.jIn = jIn;
        this.sum = i+j;
    }
    
    @Override
    public int compareTo(Data d)
    {
        return this.sum-d.sum;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i;
        boolean flag = true;
        PriorityQueue<Data> heap = new PriorityQueue<Data>();
        for (i = 0; i < nums1.length && i < k; ++i)
            heap.add(new Data(nums1[i],nums2[0],0));
        Data d;
        while (k-- > 0 && !heap.isEmpty())
        {
            List<Integer> list = new ArrayList<Integer>();
            d = heap.poll();
            list.add(d.i);
            list.add(d.j);
            result.add(list);
            if (d.jIn < nums2.length-1) heap.add(new Data(d.i,nums2[d.jIn+1],d.jIn+1));
        }
        return result;
    }
}