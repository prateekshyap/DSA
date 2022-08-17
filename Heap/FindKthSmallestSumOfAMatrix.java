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

class Solution {
    public int kthSmallest(int[][] M, int k) {
        return kthSmallest(M, M.length, M[0].length, k);
    }
    
    private int kthSmallest(int[][] M, int m, int n, int k) {
        int lo = m, hi = m * 5000, ans = -1; 
        
        while(lo <= hi) {
            int mi = lo + (hi - lo) / 2; 
            int count = countLessThanOrEqual(M, m, n, mi, k); 
            
            if(count >= k) {
                hi = mi - 1; 
                ans = mi; 
            } else {
                lo = mi + 1; 
            }
        }
        
        return ans; 
    }
    
    private int countLessThanOrEqual(int[][] M, int m, int n, int target, int k) {
        return countLessThanOrEqual(M, 0, m, n, 0, target, k); 
    }
    
    private int countLessThanOrEqual(int[][] M, int r, int m, int n, int sum, int target, int k) {
        
        if(sum > target)
            return 0; 
        if(r == m)
            return 1; 
        
        int result = 0; 
        for(int c = 0; c < n && result <= k; c++) {
            int count = countLessThanOrEqual(M, r + 1, m, n, sum + M[r][c], target, k - result); 
            
            if(count > 0) {
                result += count; 
            } else {
                break; 
            }
        }
            
        return result; 
    }
}