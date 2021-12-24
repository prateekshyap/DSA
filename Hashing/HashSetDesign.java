/*https://leetcode.com/problems/design-hashset/*/

/*Prateekshya*/

class MyHashSet {
    int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
    int capacity = 10000;
    int[] keys;
    int[] status;

    public MyHashSet() {
        keys = new int[capacity];
        status = new int[capacity];
    }
    
    public void add(int key) {
        remove(key);
        int index = getHash1(key);
        if (status[index] != 1)
        {
            status[index] = 1;
            keys[index] = key;
            return;
        }
        index = getHash2(key);
        if (status[index] != 1)
        {
            status[index] = 1;
            keys[index] = key;
            return;
        }
        int probe = 2;
        for (int i = 0; i < 5; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] != 1)
            {
                status[index] = 1;
                keys[index] = key;
                return;
            }
        }
        while (status[++index] == 1);
        status[index] = 1;
        keys[index] = key;
        return;
    }
    
    public void remove(int key) {
        int index = getHash1(key);
        if (status[index] == 1 && keys[index] == key)
        {
            status[index] = 2;
            return;
        }
        index = getHash2(key);
        if (status[index] == 1 && keys[index] == key)
        {
            status[index] = 2;
            return;
        }
        int probe = 2;
        for (int i = 0; i < 5; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && keys[index] == key)
            {
                status[index] = 2;
                return;
            }
        }
        while (status[index] == 1 || status[index] == 2)
        {
            if (keys[index] == key)
            {
                status[index] = 2;
                return;
            }
            ++index;
        }
        return;
    }
    
    public boolean contains(int key) {
        int index = getHash1(key);
        if (status[index] == 1 && keys[index] == key)
            return true;
        index = getHash2(key);
        if (status[index] == 1 && keys[index] == key)
            return true;
        int probe = 2;
        for (int i = 0; i < 5; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && keys[index] == key)
                return true;
        }
        while (status[index] == 1 || status[index] == 2)
        {
            if (status[index] == 1 && keys[index] == key)
                return true;
            ++index;
        }
        return false;
    }
    
    private int getHash1(int val)
    {
        int copy = Math.abs(val);
        int sum1 = 0, sum2 = 0;
        boolean trigger = true;
        while (copy > 0)
        {
            if (trigger)
            {
                sum1 += copy%10;
            }
            else
            {
                sum2 += copy%10;
            }
            trigger = trigger ? false : true;
            copy /= 10;
        }
        return val < 0 ? (Math.abs(val)+Math.abs(sum1-sum2))%capacity : Math.abs(sum1-sum2)%capacity;
    }
    
    private int getHash2(int val)
    {
        int copy = Math.abs(val);
        int sum = 0, i = 0;
        while (copy > 0)
        {
            sum += primes[i++]*(copy%10);
            copy /= 10;
        }
        return sum%capacity;
    }
}

/*Simple Solution, modified from Hashmap*/

class MyHashSet
{
    class Node {
        public int key;
        public boolean value;
        public Node next;
        
        public Node(int key, boolean value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    public Node[] buckets;
    
    public MyHashSet()
    {
        buckets = new Node[10000];
    }
    
    public void add(int key)
    {
        int hashKey = hashCode(key);
        if(buckets[hashKey]==null){
            buckets[hashKey] = new Node(key,true);
        }else{
            Node node = buckets[hashKey];
            while(node.next!=null &&
                  node.next.key!=key){
                node = node.next;    
            }
            if(node.key == key){
                node.value = true;
            } else if(node.next!=null && node.next.key == key){
                node.next.value = true;
            } else {
                Node newNode = new Node(key,true);
                node.next = newNode;
            }
        }
    }
    
    public void remove(int key)
    {
        int hashKey = hashCode(key);
        if(buckets[hashKey] == null)
            return;
        else{
            Node node = buckets[hashKey];
            while(node.key!=key && node.next!=null && node.next.key!=key){
                node = node.next;
            }
            if(node.key == key){
                buckets[hashKey] = node.next;
            } else if(node.next!=null && node.next.key==key){
                node.next = node.next.next;
            }
        }
    }
    
    public boolean contains(int key)
    {
        int hashKey = hashCode(key);
        if(buckets[hashKey]==null)
            return false;
        else{
            Node node = buckets[hashKey];
            while(node!=null){
                if(node.key == key)
                    return true;
                node = node.next;
            }
            return false;
        }
    }
    
    private int hashCode(int key){
        return key % buckets.length;
    }
}