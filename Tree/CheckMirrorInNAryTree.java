/*https://practice.geeksforgeeks.org/problems/check-mirror-in-n-ary-tree1528/1*/

//solution after building the complete tree
class Node
{
    int data;
    ArrayList<Node> children;
    Node(int d)
    {
        data = d;
        children = new ArrayList<Node>();
    }
}

class Solution {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        // code here
        HashMap<Integer,Node> map1 = new HashMap<Integer,Node>();
        HashMap<Integer,Node> map2 = new HashMap<Integer,Node>();
        int i, max = n;
        e *= 2;
        for (i = 0; i < e; ++i)
        {
            if (A[i] > max) max = A[i];
            if (B[i] > max) max = B[i];
        }
        for (i = 1; i <= max; ++i)
        {
            map1.put(i,new Node(i));
            map2.put(i,new Node(i));
        }
        for (i = 0; i < e; i += 2)
        {
            ((Node)map1.get(A[i])).children.add((Node)map1.get(A[i+1]));
            ((Node)map2.get(B[i])).children.add((Node)map2.get(B[i+1]));
        }
        Node root1 = (Node)map1.get(A[0]);
        Node root2 = (Node)map2.get(B[0]);
        
        return recur(root1, root2);
    }
    public static int recur(Node root1, Node root2)
    {
        int r1 = root1.children.size(), r2 = root2.children.size();
        if (r1 == 0 && r2 == 0) return 1;
        if (r1 != r2) return 0;
        int sum = 0, i, j, res;
        boolean isEqual = false;
        for (i = 0, j = r1-1; i < r2 && j >= 0 ; ++i, --j)
        {
            if (root1.children.get(i).data == root2.children.get(j).data) isEqual = true;
            res = recur(root1.children.get(i), root2.children.get(j));
            sum += isEqual ? res : 0;
        }
        if (sum == r1) return 1;
        return 0;
    }
}

//solution without building a tree
class Solution {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        //code here
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
        int max = 1, i, j, k;
        e *= 2;
        for (i = 0; i < e; ++i)
        {
            if (A[i] > max) max = A[i];
            if (B[i] > max) max = B[i];
        }
        for (i = 0; i <= max; ++i)
        {
            list1.add(new ArrayList<Integer>());
            list2.add(new ArrayList<Integer>());
        }
        for (i = 0; i < e; i += 2)
        {
            list1.get(A[i]).add(A[i+1]);
            list2.get(B[i]).add(B[i+1]);
        }
        for (i = 0; i <= max; ++i)
        {
            for (j = 0, k = list1.get(i).size()-1; j < list2.get(i).size() && k >= 0; ++j, --k)
                if (list1.get(i).get(j) != list2.get(i).get(k)) return 0;
        }
        return 1;
    }
}