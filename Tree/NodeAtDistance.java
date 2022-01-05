/*https://practice.geeksforgeeks.org/problems/node-at-distance/1*/

class Solution
{
    HashSet<Node> set;
    ArrayList<Node> list;
    //Function to return count of nodes at a given distance from leaf nodes.
    int printKDistantfromLeaf(Node root, int k)
    {
        // Write your code here
        set = new HashSet<Node>();
        list = new ArrayList<Node>();
        inOrder(root,k);
        return set.size();
    }
    void inOrder(Node root, int k)
    {
        if (root == null) return;
        list.add(root);
        if (root.left == null && root.right == null)
        {
            if (list.size() > k) set.add(list.get(list.size()-k-1));
        }
        inOrder(root.left,k);
        inOrder(root.right,k);
        list.remove(list.size()-1);
    }
}
