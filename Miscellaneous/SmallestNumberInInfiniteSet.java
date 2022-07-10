/*https://leetcode.com/problems/smallest-number-in-infinite-set/*/

class SmallestInfiniteSet {
    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        set = new TreeSet<Integer>();
        for (int i = 1; i <= 1001; ++i) set.add(i);
    }
    
    public int popSmallest() {
        return set.pollFirst();
    }
    
    public void addBack(int num) {
        set.add(num);
    }
}

class SmallestInfiniteSet {
    int[] arr;
    int index;
    public SmallestInfiniteSet() {
        arr = new int[1002];
        for (int i = 1; i <= 1001; ++i) arr[i] = i;
        index = 1;
    }
    
    public int popSmallest() {
        int result = arr[index];
        arr[index] = -1;
        while (arr[index] == -1) ++index;
        return result;
    }
    
    public void addBack(int num) {
        arr[num] = num;
        if (num < index)
            index = num;
    }
}
