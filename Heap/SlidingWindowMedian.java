/*https://leetcode.com/problems/sliding-window-median/*/

/*Heap Solution*/
class Solution {
    PriorityQueue<Long> minHeap, maxHeap;
    public double[] medianSlidingWindow(int[] nums, int k) {
        minHeap = new PriorityQueue<Long>();
        maxHeap = new PriorityQueue<Long>(Collections.reverseOrder());
        
        maxHeap.add((long)nums[0]);
        double[] result = new double[nums.length-k+1];
        
        for (int i = 1; i < k; ++i)
        {
            if (nums[i] < maxHeap.peek())
                maxHeap.add((long)nums[i]);
            else minHeap.add((long)nums[i]);
            rebalanceHeaps();
        }
        if (maxHeap.size() == minHeap.size()) result[0] = (double)(maxHeap.peek()+minHeap.peek())/2;
        else if (maxHeap.size() > minHeap.size()) result[0] = maxHeap.peek();
        else result[0] = minHeap.peek();
        
        for (int i = k; i < nums.length; ++i)
        {
            if (maxHeap.size() > 0 && nums[i-k] <= maxHeap.peek()) maxHeap.remove(new Long(nums[i-k]));
            else if (minHeap.size() > 0 && nums[i-k] >= minHeap.peek()) minHeap.remove(new Long(nums[i-k]));
            rebalanceHeaps();
            if (maxHeap.size() > 0 && nums[i] < maxHeap.peek())
                maxHeap.add((long)nums[i]);
            else minHeap.add((long)nums[i]);
            rebalanceHeaps();
            if (maxHeap.size() == minHeap.size()) result[i-k+1] = (double)(maxHeap.peek()+minHeap.peek())/2;
            else if (maxHeap.size() > minHeap.size()) result[i-k+1] = maxHeap.peek();
            else result[i-k+1] = minHeap.peek();
        }
        return result;
    }
    public void rebalanceHeaps()
    {
        if (maxHeap.size() == minHeap.size()+2)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() == maxHeap.size()+2)
            maxHeap.add(minHeap.poll());
    }
}

/*Efficient approach*/
class Solution {
    static class Window {

        final int[] arr;
        final int size;
        final int medianIndex;
        final boolean hasMedian;

        Window(int[] array) {
            this.arr = array;
            this.size = array.length;
            this.hasMedian = size % 2 == 1;
            this.medianIndex = (size - 1) / 2;
            Arrays.sort(this.arr);
        }

        double replace(int from, int to) {
            int index = Arrays.binarySearch(arr, from);
            if (index != size - 1) {
                System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
            }
            arr[size - 1] = Integer.MAX_VALUE;
            index = Arrays.binarySearch(arr, to);
            index = index >= 0 ? index : - index - 1;
            System.arraycopy(arr, index, arr, index + 1, size - 1 - index);
            arr[index] = to;
            return median();
        }

        double median() {
            if (hasMedian) {
                return arr[medianIndex];
            } else {
                return ((double) arr[medianIndex] + (double) arr[medianIndex + 1]) / 2;
            }
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int resultPtr = 0;

        int[] windowArr = new int[k];
        System.arraycopy(nums, 0, windowArr, 0, k);
        Window window = new Window(windowArr);
        result[resultPtr++] = window.median();
        for (int i = k; i < nums.length; i++) {
            result[resultPtr++] = window.replace(nums[i - k], nums[i]);
        }
        return result;
    }
}