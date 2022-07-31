/*https://leetcode.com/problems/ugly-number-ii/*/

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        if (n == 1) return 1;
        minHeap.add((long)1);
        long currentElement = -1;
        HashSet<Long> set = new HashSet<Long>();
        set.add((long)1);
        while (n-- > 0)
        {
            currentElement = minHeap.poll();
            long newElement = currentElement*2;
            if (!set.contains(newElement))
            {
                minHeap.add(newElement);
                set.add(newElement);
            }
            newElement = currentElement*3;
            if (!set.contains(newElement))
            {
                minHeap.add(newElement);
                set.add(newElement);
            }
            newElement = currentElement*5;
            if (!set.contains(newElement))
            {
                minHeap.add(newElement);
                set.add(newElement);
            }
        }
        return (int)currentElement;
    }
}

class Solution {
    static int[] uglyNums = new int[1690];
    public int nthUglyNumber(int n) {
        if(uglyNums[0] == 1) return uglyNums[n-1];
        int a = 0, b = 0, c = 0;
        uglyNums[0] = 1;
        for(int i = 1; i < 1690; i++){
            int mul2 = uglyNums[a] * 2;
            int mul3 = uglyNums[b] * 3;
            int mul5 = uglyNums[c] * 5;
            int min = Math.min(mul2, Math.min(mul3, mul5));
            if(min == mul2)a++;
            if(min == mul3)b++;
            if(min == mul5)c++;
            uglyNums[i] = min;
        }
        return uglyNums[n-1];
    }
}