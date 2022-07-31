/*https://practice.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1/*/

class Solution {
    public static int kthLargest(int N, int K, int[] Arr) {
        // code here
        int[] prefixSum = new int[N];
        int i, j, prevSetSize = -1, currSum = -1;
        prefixSum[0] = Arr[0];
        
        for (i = 1; i < N; ++i)
            prefixSum[i] = prefixSum[i-1]+Arr[i];
            
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for (i = 0; i < N; ++i)
        {
            minHeap.add(prefixSum[i]);
            if (minHeap.size() > K) minHeap.poll();
        }
        for (i = 0; i < N; ++i)
        {
            for (j = i+1; j < N; ++j)
            {
                minHeap.add(prefixSum[j]-prefixSum[i]);
                if (minHeap.size() > K) minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}

class Solution {
    public static int kthLargest(int N, int K, int[] Arr) {
        // code here
        int i, j, currSum;
            
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for (i = 0; i < N; ++i)
        {
            currSum = 0;
            for (j = i; j < N; ++j)
            {
                currSum += Arr[j];
                minHeap.add(currSum);
                if (minHeap.size() > K) minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}