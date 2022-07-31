/*https://practice.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1/*/

class Solution{
    public int left(int i) { return 2*i+1; }
    public int right(int i) { return 2*i+2; }
    public int parent(int i) { return (i-1)/2; }
    public int[] mergeHeaps(int[] a, int[] b, int m, int n) {
        // your code here
        int[] newHeap = new int[m+n];
        int i, j, temp, index;
        for (i = 0; i < m; ++i) newHeap[i] = a[i];
        for (i = 0, j = m; i < n && j < m+n; ++i, ++j)
        {
            newHeap[j] = b[i];
            index = j;
            while (parent(index) >= 0 && newHeap[parent(index)] < newHeap[index])
            {
                temp = newHeap[index];
                newHeap[index] = newHeap[parent(index)];
                newHeap[parent(index)] = temp;
                index = parent(index);
            }
        }
        return newHeap;
    }
}