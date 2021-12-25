/*https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1*/

//converting into DLL approach
class Solution
{
    public Node head1, tail1, head2, tail2;
    public void addNode(int data)
    {
        tail1.right = new Node(data);
        tail1.right.left = tail1;
        tail1 = tail1.right;
    }
    public List<Integer> merge(Node root1,Node root2)
    {
        head1 = new Node(0);
        tail1 = head1;
        
        //convert both the trees to DLLs
        traverseInOrder(root2);
        root2 = null;
        head2 = head1.right;
        head2.left = null;
        tail2 = tail1;
        head1 = new Node(0);
        tail1 = head1;
        traverseInOrder(root1);
        head1 = head1.right;
        head1.left = null;
        root1 = null;
        
        //Merge two DLLs
        List<Integer> result = new ArrayList<Integer>();
        while (head1 != null && head2 != null)
        {
            if (head1.data <= head2.data)
            {
                result.add(head1.data);
                head1 = head1.right;
            }
            else
            {
                result.add(head2.data);
                head2 = head2.right;
            }
        }
        while (head1 != null)
        {
            result.add(head1.data);
            head1 = head1.right;
        }
        while (head2 != null)
        {
            result.add(head2.data);
            head2 = head2.right;
        }
        return result;
    }
    public void traverseInOrder(Node root)
    {
        if (root != null)
        {
            traverseInOrder(root.left);
            addNode(root.data);
            traverseInOrder(root.right);
        }
    }
}