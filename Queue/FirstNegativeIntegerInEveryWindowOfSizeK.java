/*https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1/*/

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> queue = new LinkedList<Long>();
        long[] result = new long[N-K+1];
        int i, j = 0;
        for (i = 0; i < K; ++i) if (A[i] < 0) queue.add(A[i]);
        result[0] = queue.isEmpty() ? 0 : queue.peek();
        for (i = K; i < N; ++i)
        {
            if (!queue.isEmpty() && queue.peek() == A[i-K]) queue.poll();
            if (A[i] < 0) queue.add(A[i]);
            result[++j] = queue.isEmpty() ? 0 : queue.peek();
        }
        return result;
    }
}