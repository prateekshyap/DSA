/*https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/*/

class Solution {
    public int fillCups(int[] amount) {
        int result = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        heap.add(amount[0]);
        heap.add(amount[1]);
        heap.add(amount[2]);
        int one = -1, two = -1;
        while (!heap.isEmpty())
        {
            one = heap.poll();
            if (one == 0) break;
            if (!heap.isEmpty()) two = heap.poll();
            else two = Integer.MAX_VALUE;
            result += 1;
            one -= 1;
            if (two != Integer.MAX_VALUE) two -= 1;
            if (one > 0) heap.add(one);
            if (two != Integer.MAX_VALUE && two > 0) heap.add(two);
        }
        
        return result;
    }
}

class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        
        if (amount[0]+amount[1] >= amount[2]) return (amount[0]+amount[1]+amount[2]+1)/2;
        return amount[2];
    }
}