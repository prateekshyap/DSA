/*https://leetcode.com/problems/lru-cache/*/

//LinkedHashMap implementation
class LRUCache {
    static LinkedHashMap<Integer,Integer> map;
    static int capacity;
    static Iterator iterator;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<Integer,Integer>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        //get the value
        int result = map.containsKey(key) ? map.get(key) : -1;
        
        //if key is present
        if (result != -1)
        {
            //remove and reinsert it
            map.remove(key);
            map.put(key,result);
        }
        return result;
    }
    
    public void put(int key, int value) {
        //if the key is present
        if (map.containsKey(key))
        {
            //remove and reinsert it
            map.remove(key);
            map.put(key,value);
        }

        //if key is not present and no overflow
        else if (map.size() < capacity)
        {
            //add the key
            map.put(key,value);
        }

        //all other cases
        else
        {
            //remove the element at 0th index
            iterator = map.entrySet().iterator();
            if (iterator.hasNext())
            {
                int remove = (Integer)((Map.Entry)iterator.next()).getKey();
                map.remove(remove);
            }

            //add the new key
            map.put(key,value);
        }
    }
}

//scratch implementation
class Node
{
    Node prev;
    int key;
    int value;
    Node next;
    Node(int k, int v)
    {
        key = k;
        value = v;
    }
}

class Cache
{
    private Node head, tail;
    private Node[] hashTable;
    private int capacity;
    private int size;
    
    Cache(int capacity)
    {
        this.capacity = capacity;
        size = 0;
        //two dummy nodes to handle edge cases
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        hashTable = new Node[10001];
    }
    private void bubbleUp(int key)
    {
        hashTable[key].prev.next = hashTable[key].next;
        hashTable[key].next.prev = hashTable[key].prev;
        hashTable[key].prev = tail.prev;
        hashTable[key].next = tail;
        hashTable[key].prev.next = hashTable[key];
        tail.prev = hashTable[key];
    }
    public void add(int key, int value)
    {
        hashTable[key] = new Node(key,value);
        hashTable[key].prev = tail.prev;
        hashTable[key].next = tail;
        hashTable[key].prev.next = hashTable[key];
        tail.prev = hashTable[key];
        ++size;
    }
    public void updateAndBubbleUp(int key, int value)
    {
        hashTable[key].value = value;
        bubbleUp(key);
    }
    public void removeLRU()
    {
        //the next node to head dummy is the least recently used node
        int key = head.next.key;
        hashTable[key].next.prev = head;
        head.next = hashTable[key].next;
        hashTable[key].prev = null;
        hashTable[key].next = null;
        hashTable[key] = null;
    }
    public int getValue(int key)
    {
        bubbleUp(key);
        return hashTable[key].value;
    }
    public boolean isPresent(int key)
    {
        return hashTable[key] == null ? false : true;
    }
    public boolean isOverflow()
    {
        return size > capacity ? true : false;
    }
}

class LRUCache {
    Cache cache;
    
    public LRUCache(int capacity) {
        cache = new Cache(capacity);
    }
    
    public int get(int key) {
        if (cache.isPresent(key))
            return cache.getValue(key);
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.isPresent(key))
            cache.updateAndBubbleUp(key,value);
        else
        {
            cache.add(key,value);
            if (cache.isOverflow())
                cache.removeLRU();
        }
    }
}

/*https://practice.geeksforgeeks.org/problems/page-faults-in-lru5603/1*/

/*almost same kind of cache and node implementation
along with this solution class*/

class Solution{
    static int pageFaults(int N, int C, int pages[]){
        Cache cache = new Cache(C);
        int faults = 0;
        for (int key : pages)
        {
            if (cache.isPresent(key)) cache.bubbleUp(key);
            else
            {
                cache.add(key);
                if (cache.isOverflow()) cache.removeLRU();
                ++faults;
            }
        }
        return faults;
    }
}