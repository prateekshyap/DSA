/*https://leetcode.com/problems/kth-largest-element-in-a-stream/*/

class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<Integer>();
        this.k = k;

        //add the top k elements to the heap
        for (int i = 0; i < (k < nums.length ? k : nums.length); ++i)
            this.pq.add(nums[i]);

        //for rest of the elements, update the root
        for (int i = k; i < nums.length; ++i)
        {
            if (nums[i] > this.pq.peek())
            {
                this.pq.poll();
                this.pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {

        //if heap size is less than k then add the element
        if (this.pq.size() < k)
        {
            this.pq.add(val);
        }

        //otherwise check with the root and replace
        else if (val > this.pq.peek())
        {
            this.pq.poll();
            this.pq.add(val);
        }

        //return the root
        return this.pq.peek();
    }
}