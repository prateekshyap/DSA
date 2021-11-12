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