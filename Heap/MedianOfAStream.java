/*https://leetcode.com/problems/find-median-from-data-stream/*/

class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
    	//add the first element to the minheap
        if (minHeap.isEmpty() && maxHeap.isEmpty())
            minHeap.add(num);
        //for rest of the elements
        else
        {
        	//if the element is greater than the root of the minheap
            if (num > minHeap.peek())
            	//add it to the minheap
                minHeap.add(num);
            //otherwise
            else
            	//add it to the maxheap
                maxHeap.add(num);
        }

        //balance the heaps
        rebalance();
    }
    
    private void rebalance()
    {
    	//if the size gap is more than 1, move one element from the larger heap to the smaller heap
        if (minHeap.size()-maxHeap.size() == 2)
            maxHeap.add(minHeap.poll());
        else if (maxHeap.size()-minHeap.size() == 2)
            minHeap.add(maxHeap.poll());
    }
    
    public double findMedian() {
    	//if sizes are same then pick both roots and take average
        if (minHeap.size() == maxHeap.size())
            return ((double)(minHeap.peek()+maxHeap.peek()))/2;

        //otherwise root of the larger heap will be the answer
        return minHeap.size()-maxHeap.size() == 1 ? minHeap.peek() : maxHeap.peek();
    }
}