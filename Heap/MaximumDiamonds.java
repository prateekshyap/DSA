/*https://practice.geeksforgeeks.org/problems/chinky-and-diamonds3340/1*/

class Solution
{
    static int maxDiamonds(int[] A, int N, int K)
    {
        // code here
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int total = 0, curr = 0;
        
        for (int i = 0; i < A.length; ++i)
            heap.add(A[i]);
            
        for (int i = 0; i < K; ++i)
        {
            curr = (Integer)heap.poll();
            heap.add(curr/2);
            total += curr;
        }
        
        return total;
    }
}