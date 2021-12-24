/*https://leetcode.com/problems/insert-delete-getrandom-o1/*/

/*Prateekshya*/

class Hash
{
    int[] primes = {2,3,5,7,11,13,17,19,23,29,31};
    int capacity = 200000;
    int[] hash;
    int[] location;
    int[] status;
    Hash()
    {
        hash = new int[capacity];
        location = new int[capacity];
        status = new int[capacity];
    }
    public boolean contains(int val)
    {
        int index = getHash1(val);
        if (status[index] == 1 && hash[index] == val)
            return true;
        index = getHash2(val);
        if (status[index] == 1 && hash[index] == val)
            return true;
        int probe = 2;
        for (int i = 0; i < 5; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && hash[index] == val)
                return true;
        }
        while (status[index] == 1 || status[index] == 2)
        {
            if (status[index] == 1 && hash[index] == val)
                return true;
            ++index;
        }
        return false;
    }
    public int getLocation(int val)
    {
        int index = getHash1(val);
        if (status[index] == 1 && hash[index] == val)
            return location[index];
        index = getHash2(val);
        if (status[index] == 1 && hash[index] == val)
            return location[index];
        int probe = 2;
        for (int i = 0; i < 5; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && hash[index] == val)
                return location[index];
        }
        while (status[index] == 1 || status[index] == 2)
        {
            if (status[index] == 1 && hash[index] == val)
                return location[index];
            ++index;
        }
        return -1;
    }
    public void store(int val, int loc)
    {
        int index = getHash1(val);
        if (status[index] != 1)
        {
            status[index] = 1;
            hash[index] = val;
            location[index] = loc;
            return;
        }
        index = getHash2(val);
        if (status[index] != 1)
        {
            status[index] = 1;
            hash[index] = val;
            location[index] = loc;
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
                hash[index] = val;
                location[index] = loc;
                return;
            }
        }
        while (status[++index] == 1);
        status[index] = 1;
        hash[index] = val;
        location[index] = loc;
        return;
    }
    public boolean remove(int val)
    {
        int index = getHash1(val);
        if (status[index] == 1 && hash[index] == val)
        {
            status[index] = 2;
            return true;
        }
        index = getHash2(val);
        if (status[index] == 1 && hash[index] == val)
        {
            status[index] = 2;
            return true;
        }
        int probe = 2;
        for (int i = 0; i < 5; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && hash[index] == val)
            {
                status[index] = 2;
                return true;
            }
        }
        while (status[index] == 1 || status[index] == 2)
        {
            if (hash[index] == val)
            {
                status[index] = 2;
                return true;
            }
            ++index;
        }
        return false;
    }
    public void update(int val, int loc)
    {
        int index = getHash1(val);
        if (status[index] == 1 && hash[index] == val)
        {
            location[index] = loc;
            return;
        }
        index = getHash2(val);
        if (status[index] == 1 && hash[index] == val)
        {
            location[index] = loc;
            return;
        }
        int probe = 2;
        for (int i = 0; i < 5; ++i)
        {
            index += probe;
            index %= capacity;
            probe <<= 1;
            if (status[index] == 1 && hash[index] == val)
            {
                location[index] = loc;
                return;
            }
        }
        while (status[index] == 1 || status[index] == 2)
        {
            if (hash[index] == val)
            {
                location[index] = loc;
                return;
            }
            ++index;
        }
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

class RandomizedSet {
    Hash hash;
    int[] arr;
    int capacity = 1, size;
    public RandomizedSet() {
        arr = new int[capacity];
        size = 0;
        hash = new Hash();
    }
    
    public boolean insert(int val) {
        if (hash.contains(val))
            return false;
        if (size == capacity)
        {
            int[] temp = new int[capacity*2];
            for (int i = 0; i < capacity; ++i)
                temp[i] = arr[i];
            arr = temp;
            capacity *= 2;
        }
        arr[size] = val;
        hash.store(val,size);
        ++size;
        return true;
    }
    
    public boolean remove(int val) {
        int location = hash.getLocation(val);
        if (location == -1)
            return false;
        hash.remove(val);
        arr[location] = arr[size-1];
        hash.update(arr[location],location);
        --size;
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();        
        int n = random.nextInt(size);
        return arr[n];
    }
}

/*Efficient solution*/

class RandomizedSet {
    
    private ArrayList<Integer> arrayList;
    private HashMap<Integer, Integer> hashMap;
    private Random random;
    
    public RandomizedSet() {
        this.arrayList = new ArrayList<Integer>();
        this.hashMap = new HashMap<Integer, Integer>();
        this.random = new Random();
    }
    public boolean insert(int val) {
        if(hashMap.containsKey(val)) return false;
        
        hashMap.put(val, arrayList.size());
        arrayList.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hashMap.containsKey(val)) return false;
        
        int last = arrayList.get(arrayList.size()-1);
        int index = hashMap.get(val);
        
        arrayList.set(index, last);
        hashMap.put(last, index);
        
        arrayList.remove(arrayList.size()-1);
        hashMap.remove(val);
        return true;
    }
    
    public int getRandom() {
        
        return arrayList.get(random.nextInt(arrayList.size()));
    }
    
}