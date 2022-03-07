/*https://practice.geeksforgeeks.org/problems/check-if-subtree/1*/

class Solution {
    public static boolean match(Node T, Node S)
    {
        if (T == null && S == null) return true;
        if (T == null || S == null) return false;
        return (T.data == S.data) && match(T.left,S.left) && match(T.right,S.right);
    }
    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        return match(T,S) || (T.left != null && isSubtree(T.left,S)) || (T.right != null && isSubtree(T.right,S));
    }
}

/*
class Solution {
    //ArrayList<Integer> pre;
    //ArrayList<Integer> in;
    StringBuffer inOrder;
    StringBuffer preOrder;
    Solution()
    {
        //pre = new ArrayList<Integer>();
        //in = new ArrayList<Integer>();
        preOrder = new StringBuffer("#");
        inOrder = new StringBuffer("#");
    }
    public boolean isSubtree(Node T, Node S) {
        // add code here.
        Solution t = new Solution();
        Solution s = new Solution();
        new Solution().traverseAndStore(t,T);
        new Solution().traverseAndStore(s,S);
        String tStr = t.inOrder.toString();
        String sStr = s.inOrder.toString();
        //System.out.println(sStr);
        boolean isInSub = false, isPreSub = false;
        for (int i = 0; i <= tStr.length()-sStr.length(); ++i)
        {
            //System.out.println(tStr.substring(i,i+sStr.length()));
            if (tStr.substring(i,i+sStr.length()).equals(sStr))
            {
                isInSub = true;
                break;
            }
        }
        tStr = t.preOrder.toString();
        sStr = s.preOrder.toString();
        for (int i = 0; i <= tStr.length()-sStr.length(); ++i)
        {
            //System.out.println(tStr.substring(i,i+sStr.length()));
            if (tStr.substring(i,i+sStr.length()).equals(sStr))
            {
                isPreSub = true;
                break;
            }
        }
        return isInSub&&isPreSub;
    }
    public void traverseAndStore(Solution t, Node root)
    {
        if (root == null)
        {
            t.inOrder.append("N");
            t.inOrder.append("#");
            t.preOrder.append("N");
            t.preOrder.append("#");
            return;
        }
        t.preOrder.append(root.data);
        t.preOrder.append("#");
        traverseAndStore(t,root.left);
        t.inOrder.append(root.data);
        t.inOrder.append("#");
        traverseAndStore(t,root.right);
    }
}
*/