/*https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/*/

class Data
{
    ListNode head;
    ListNode mid;
    ListNode prevMid;
    TreeNode parent;
    Data(ListNode head, TreeNode parent)
    {
        this.head = head;
        this.parent = parent;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            this.prevMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        this.mid = slow;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = null;
        Stack<Data> dataStack = new Stack<Data>();
        dataStack.push(new Data(head,null));
        while (!dataStack.isEmpty())
        {
            Data curr = dataStack.pop();

            TreeNode currNode = new TreeNode(curr.mid.val);
            if (root == null) root = currNode;
            else
            {
                if (currNode.val < curr.parent.val)
                    curr.parent.left = currNode;
                else
                    curr.parent.right = currNode;
            }
            
            //if the right subtree has more than one nodes then push the right subtree range
            if (curr.mid.next != null) dataStack.push(new Data(curr.mid.next,currNode));
            //if the left subtree has more than one nodes then push the left subtree range
            if (curr.head != curr.mid)
            {
                curr.prevMid.next = null;
                dataStack.push(new Data(curr.head,currNode));
            }
        }
        return root;
    }
}