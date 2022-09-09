/*https://leetcode.com/problems/largest-values-from-labels/*/

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                return b[0]-a[0];
            }
        });
        int N = values.length;
        for (int i = 0; i < N; ++i)
            heap.add(new int[]{values[i],labels[i]});
        int score = 0;
        int[] freq = new int[(int)(2*(1e4)+1)];
        while (!heap.isEmpty() && numWanted > 0)
        {
            int[] elem = heap.poll();
            if (freq[elem[1]] < useLimit)
            {
                ++freq[elem[1]];
                score += elem[0];
                --numWanted;
            }
        }
        return score;
    }
}