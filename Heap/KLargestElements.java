/*https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1/*/

class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        //add the first k elements to min heap
        for (int i = 0; i < k; ++i)
            minHeap.add(arr[i]);

        //for rest of the elements
        for (int i = k; i < arr.length; ++i)
        {
            //if the element is greate than the root of the minheap
            if (arr[i] > (Integer)minHeap.peek())
            {
                //remove it and add the current element
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        /*this ensures that the largest k elements stay in the heap*/

        //return the root
        int[] result = new int[k];
        for (int i = k-1; i >= 0; --i)
        {
            result[i] = (Integer)minHeap.poll();
        }
        return result;
    }
}