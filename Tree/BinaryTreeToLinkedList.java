/*https://binarysearch.com/problems/Binary-Tree-to-Linked-List*/

class Solution {
    public LLNode solve(Tree root) {
        LLNode[] finalList = recur(root);
        return finalList[0];
    }
    public LLNode[] recur(Tree root)
    {
        if (root == null) return new LLNode[2];
        LLNode[] left = recur(root.left);
        LLNode[] right = recur(root.right);
        LLNode curr = new LLNode(root.val);
        if (left[1] != null) left[1].next = curr;
        curr.next = right[0];
        LLNode[] result = new LLNode[2];
        result[0] = left[0] == null ? curr : left[0];
        result[1] = right[1] == null ? curr : right[1];
        return result;
    }
}

class Solution {
    LLNode temp = new LLNode(1);
    LLNode head = temp;
    public LLNode solve(Tree root) {
        if (root == null) {
            return null;
        }
        solve(root.left);
        temp.next = new LLNode(root.val);
        temp = temp.next;
        solve(root.right);
        return head.next;
    }
}