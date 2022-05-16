/*https://leetcode.com/problems/super-ugly-number/*/

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        if (n == 1) return 1;
        minHeap.add((long)1);
        long currentElement = -1;
        HashSet<Long> set = new HashSet<Long>();
        set.add((long)1);
        long newElement;
        while (n-- > 0)
        {
            currentElement = minHeap.poll();
            for (int prime : primes)
            {
                newElement = currentElement*prime;
                if (!set.contains(newElement))
                {
                    minHeap.add(newElement);
                    set.add(newElement);
                }
            }
        }
        return (int)currentElement;
    }
}