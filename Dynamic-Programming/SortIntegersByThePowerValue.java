/*https://leetcode.com/problems/sort-integers-by-the-power-value/*/

class Power implements Comparable<Power>
{
    int elem, power;
    Power(int e, int p)
    {
        this.elem = e;
        this.power = p;
    }
    @Override
    public int compareTo(Power p)
    {
        if (this.power < p.power) return -1;
        else if (this.power > p.power) return 1;
        return this.elem-p.elem;
    }
}

class Solution {
    HashMap<Integer,Integer> map;
    public int getKth(int lo, int hi, int k) {
        map = new HashMap<Integer,Integer>();
        PriorityQueue<Power> maxHeap = new PriorityQueue<Power>(Collections.reverseOrder());
        int i, power;
        for (i = lo; i < lo+k; ++i)
        {
            power = getPower(i);
            maxHeap.add(new Power(i,power));
        }
        for (i = lo+k; i <= hi; ++i)
        {
            power = getPower(i); 
            if ((maxHeap.peek().power > power) || (maxHeap.peek().power == power && maxHeap.peek().elem > i))
            {
                maxHeap.poll();
                maxHeap.add(new Power(i,power));
            }
        }
        return maxHeap.poll().elem;
    }
    public int getPower(int num)
    {
        if (map.containsKey(num)) return map.get(num);
        if (num == 1) return 0;
        int power = 0;
        if (num%2 == 0) power = 1+getPower(num/2);
        else power = 1+getPower((3*num)+1);
        map.put(num,power);
        return power;
    }
}