/*https://leetcode.com/problems/design-hashmap/*/

/*Prateekshya*/

class MyHashMap {
    int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
    int capacity = 10000;
    int[] keys;
    int[] values;
    int[] status;
    
    public MyHashMap() {
        keys = new int[capacity];
        values = new int[capacity];
        status = new int[capacity];
    }
    
    public void put(int key, int value) {
        remove(key);
        int index = getHash1(key);
        if (status[index] != 1)
        {
            status[index] = 1;
            keys[index] = key;
            values[index] = value;
            return;
        }
        index = getHash2(key);
        if (status[index] != 1)
        {
            status[index] = 1;
            keys[index] = key;
            values[index] = value;
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
                values[index] = value;
                return;
            }
        }
        while (status[++index] == 1);
        status[index] = 1;
        keys[index] = key;
        values[index] = value;
        return;
    }
    
    public int get(int key) {
        int index = getHash1(key);
        if (status[index] == 1 && keys[index] == key)
            return values[index];
        index = getHash2(key);
        if (status[index] == 1 && keys[index] == key)
            return values[index];
        int probe = 2;
        for (int i = 0; i < 5; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && keys[index] == key)
                return values[index];
        }
        while (status[index] == 1 || status[index] == 2)
        {
            if (status[index] == 1 && keys[index] == key)
                return values[index];
            ++index;
        }
        return -1;
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

/*Simple solution*/

class MyHashMap {

    class Node {
        public int key;
        public int value;
        public Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    public Node[] buckets;
    
    public MyHashMap() {
        buckets = new Node[10000];
    }
    
    public void put(int key, int value) {
        int hashKey = hashCode(key);
        if(buckets[hashKey]==null){
            buckets[hashKey] = new Node(key, value);
        }else{
            Node node = buckets[hashKey];
            while(node.next!=null &&
                  node.next.key!=key){
                node = node.next;    
            }
            if(node.key == key){
                node.value = value;
            } else if(node.next!=null && node.next.key == key){
                node.next.value = value;
            } else {
                Node newNode = new Node(key,value);
                node.next = newNode;
            }
        }
    }
    
    public int get(int key) {
        int hashKey = hashCode(key);
        if(buckets[hashKey]==null)
            return -1;
        else{
            Node node = buckets[hashKey];
            while(node!=null){
                if(node.key == key)
                    return node.value;
                node = node.next;
            }
            return -1;
        }
    }
    
    public void remove(int key) {
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
    
    private void printNode(Node node){
        Node temp = node;
        while(temp!=null){
            System.out.print(temp.key + " -> ");
            temp = temp.next;
        }
        System.out.print("\n");
    }
    
    private int hashCode(int key){
        return key % buckets.length;
    }
    
}