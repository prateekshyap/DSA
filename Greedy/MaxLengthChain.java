/*https://practice.geeksforgeeks.org/problems/max-length-chain/1*/

//similar to activity selection problem
class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new CompareByFirst());
        int res = 0;
        for (int i = 0; i < n; ++i)
            pq.add(arr[i]);
        Pair currPair = null, prevPair = null;
        currPair = pq.poll();
        ++res;
        prevPair = currPair;
        while (!pq.isEmpty())
        {
            currPair = pq.poll();
            if (currPair.x > prevPair.y)
            {
                ++res;
                prevPair = currPair;
            }
        }
        return res;
    }
}