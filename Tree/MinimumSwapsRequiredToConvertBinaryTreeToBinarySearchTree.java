/*https://practice.geeksforgeeks.org/problems/minimum-swap-required-to-convert-binary-tree-to-binary-search-tree/1/*/

/*iterative inorder traversal and cycle finding*/
class Solution {
    private static int left(int i) { return 2*i+1; }
    private static int right(int i) { return 2*i+2; }
    private static int parent(int i) { return (i-1)/2; }
    public static int minSwaps(int n, int[] A) {
        // code here
        int[] inorder = new int[n];
        Stack<Integer> dataStack = new Stack<Integer>();
        Stack<Integer> indexStack = new Stack<Integer>();
        int data, index = 0, inorderIndex = 0, i;
        
        while (index < n)
        {
            dataStack.push(A[index]);
            indexStack.push(index);
            index = left(index);
        }
        
        while (!dataStack.isEmpty())
        {
            index = indexStack.pop();
            data = dataStack.pop();
            inorder[inorderIndex++] = data;
            index = right(index);
            while (index < n)
            {
                dataStack.push(A[index]);
                indexStack.push(index);
                index = left(index);
            }
        }
        
        int result = 0, curr, inCurr = -1, len = 0;
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (i = 0; i < n; ++i)
            map.put(A[i],i);
        boolean[] visited = new boolean[n];
        for (i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                curr = A[i];
                index = i;
                inCurr = -1;
                visited[i] = true;
                len = 0;
                while (inCurr != curr)
                {
                    ++len;
                    inCurr = inorder[index];
                    visited[index] = true;
                    index = (Integer)map.get(inCurr);
                }
                if (len > 1) result += len-1;
            }
        }
        return result;
    }
}

class Solution {
    static int[] inorder;
    static int inorderIndex;
    public static int minSwaps(int n, int[] A) {
        // code here
        inorder = new int[n];
        int i;
        inorderIndex = 0;
        
        traverseInorder(A,0);
        
        int result = 0, curr, inCurr = -1, len = 0;
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (i = 0; i < n; ++i)
            map.put(A[i],i);
        boolean[] visited = new boolean[n];
        for (i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                curr = A[i];
                index = i;
                inCurr = -1;
                visited[i] = true;
                len = 0;
                while (inCurr != curr)
                {
                    ++len;
                    inCurr = inorder[index];
                    visited[index] = true;
                    index = (Integer)map.get(inCurr);
                }
                if (len > 1) result += len-1;
            }
        }
        return result;
    }
    public static void traverseInorder(int[] a, int index)
    {
        if (index >= a.length) return;
        traverseInorder(a,2*index+1);
        inorder[inorderIndex++] = a[index];
        traverseInorder(a,2*index+2);
    }
}
