/*https://leetcode.com/problems/stock-price-fluctuation/*/

class StockPrice {
    TreeMap<Integer,Set<Integer>> priceMap;
    TreeMap<Integer,Integer> timestampMap;
    public StockPrice() {
        priceMap = new TreeMap<Integer,Set<Integer>>();
        timestampMap = new TreeMap<Integer,Integer>();
    }
    
    public void update(int timestamp, int price) {
        if (timestampMap.containsKey(timestamp))
        {
            int oldPrice = timestampMap.get(timestamp);
            timestampMap.remove(timestamp);
            timestampMap.put(timestamp,price);
            priceMap.get(oldPrice).remove(timestamp);
            if (priceMap.get(oldPrice).size() == 0) priceMap.remove(oldPrice);
            priceMap.putIfAbsent(price,new HashSet<Integer>());
            priceMap.get(price).add(timestamp);
        }
        else
        {
            timestampMap.put(timestamp,price);
            priceMap.putIfAbsent(price,new HashSet<Integer>());
            priceMap.get(price).add(timestamp);
        }
    }
    
    public int current() {
        return timestampMap.get(timestampMap.lastKey());
    }
    
    public int maximum() {
        return priceMap.lastKey();
    }
    
    public int minimum() {
        return priceMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */



class StockPrice {
    HashMap<Integer,Integer> timestampMap;
    PriorityQueue<int[]> maxHeap, minHeap;
    int latestTime;
    public StockPrice() {
        timestampMap = new HashMap<Integer,Integer>();
        maxHeap = new PriorityQueue<int[]>((a,b)->(b[1]-a[1]));
        minHeap = new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
        latestTime = 0;
    }
    
    public void update(int timestamp, int price) {
        timestampMap.put(timestamp,price);
        latestTime = Math.max(latestTime,timestamp);
        int[] newEntry = new int[]{timestamp,price};
        maxHeap.add(newEntry);
        minHeap.add(newEntry);
    }
    
    public int current() {
        return timestampMap.get(latestTime);
    }
    
    public int maximum() {
        int[] result = maxHeap.peek();
        while (timestampMap.get(result[0]) != result[1])
        {
            maxHeap.poll();
            result = maxHeap.peek();
        }
        return result[1];
    }
    
    public int minimum() {
        int[] result = minHeap.peek();
        while (timestampMap.get(result[0]) != result[1])
        {
            minHeap.poll();
            result = minHeap.peek();
        }
        return result[1];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */