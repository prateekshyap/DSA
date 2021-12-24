/*https://practice.geeksforgeeks.org/problems/pairs-with-specific-difference1533/1*/

class Solution { 
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        //add everything to max heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (Integer num : arr)
            pq.add(num);
        int big = -1, small = -1;
        int sum = 0;

        //till the heap has more elements
        while (!pq.isEmpty())
        {
            /*this logic ensures disjoint pairing*/
            big = small;
            small = pq.poll();
            if (big == -1) continue;
            if (big-small < K)
            {
                sum += big;
                sum += small;
                big = small = -1;
            }
        }
        return sum;
    }
}