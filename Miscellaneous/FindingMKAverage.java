/*https://leetcode.com/problems/finding-mk-average/*/

class MKAverage {

    int sum, total, m, k;
    TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
    Queue<Integer> queue = new LinkedList<Integer>();
    
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.sum = this.total = 0;
        this.map = new TreeMap<Integer,Integer>();
        this.queue = new LinkedList<Integer>();
    }

    public void addElement(int num) {
        ++total;
        sum += num;
        queue.add(num);
        map.put(num,map.getOrDefault(num,0)+1);
        if (total > m)
        {
            --total;
            int first = queue.poll();
            sum -= first;
            map.put(first,map.get(first)-1);
            if (map.get(first) == 0) map.remove(first);
        }
    }

    public int calculateMKAverage() {

        if (total < m) return -1;
        int count = k, sumCopy = sum;
        for (Map.Entry entry : map.entrySet())
        {
            if (count == 0) break;
            int key = (Integer)entry.getKey();
            int value = (Integer)entry.getValue();
            int min = Math.min(count,value);
            count -= min;
            sumCopy -= min*key;
        }
        count = k;
        for (Map.Entry entry : map.descendingMap().entrySet())
        {
            if (count == 0) break;
            int key = (Integer)entry.getKey();
            int value = (Integer)entry.getValue();
            int min = Math.min(count,value);
            count -= min;
            sumCopy -= min*key;
        }
        return (sumCopy/(m-2*k));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */