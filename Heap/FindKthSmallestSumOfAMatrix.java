/*https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/*/

class Array implements Comparable<Array>
{
    int[] elems, indices;
    int last;
    int sum;
    public static int n;
    Array()
    {
        this.last = 0;
        this.elems = new int[n];
        this.indices = new int[n];
    }
    Array(Array array)
    {
        this.n = array.n;
        this.elems = new int[n];
        this.indices = new int[n];
        this.last = 0;
        for (int val : array.elems)
            this.elems[last++] = val;
        this.last = 0;
        for (int val : array.indices)
            this.indices[last++] = val;
    }
    public void addElement(int elem)
    {
        elems[last++] = elem;
        if (last == n) this.sum = calculateSum();
    }
    public int calculateSum()
    {
        int result = 0;
        for (int val : elems)
            result += val;
        return result;
    }
    @Override
    public int compareTo(Array other)
    {
        return this.sum-other.sum;
    }
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder("");
        result.append("[");
        for (int val : elems)
        {
            result.append(val);
            result.append(" ");
        }
        String str = result.toString().trim();
        str += "]";
        return str;
    }
}
class Solution {
    HashSet<String> visited;
    public int kthSmallest(int[][] mat, int k) {
        int i, R = mat.length, C = mat[0].length;
        Array.n = R;
        String key;
        visited = new HashSet<String>();
        PriorityQueue<Array> heap = new PriorityQueue<Array>();
        Array array = new Array();
        for (i = 0; i < R; ++i)
            array.addElement(mat[i][0]);
        heap.add(array);
        while (k-- > 0 && !heap.isEmpty())
        {
            array = heap.poll();
            for (i = 0; i < R; ++i)
            {
                Array newArray = new Array(array);
                if (newArray.indices[i] < C-1)
                {
                    ++newArray.indices[i];
                    newArray.elems[i] = mat[i][newArray.indices[i]];
                    newArray.sum = newArray.calculateSum();
                    key = generateKey(newArray.indices);
                    if (visited.contains(key)) continue;
                    visited.add(key);
                    heap.add(newArray);
                }
            }
        }
        return array.sum;
    }
    public String generateKey(int[] indices)
    {
        StringBuilder result = new StringBuilder("");
        for (int val : indices)
        {
            result.append(val);
            result.append(",");
        }
        return result.toString();
    }
}