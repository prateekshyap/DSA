/*https://leetcode.com/problems/number-of-recent-calls/*/

class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t-3000)
            queue.poll();
        queue.add(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */