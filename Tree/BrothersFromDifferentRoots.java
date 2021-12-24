/*https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1#*/
 
class GfG
{
    static ArrayList<Integer> tree1;
    static HashSet<Integer> tree2;

    public static int countPairs(Node root1, Node root2, int x)
    {
        tree1 = new ArrayList<Integer>();
        tree2 = new HashSet<Integer>();
        
        //traverse inorder the second tree
        inOrder(root2);

        //add it to the hashset
        tree2.addAll(tree1);

        //clear the arraylist and add everything from first tree in inorder
        tree1.clear();
        inOrder(root1);

        //count the pairs if the corresponding value is present in the hashset 
        int count = 0;
        for (Integer node : tree1)
            if (tree2.contains(x-node))
                ++count;
            
        return count;
    }
    public static void inOrder(Node root)
    {
        if (root != null)
        {
            inOrder(root.left);
            tree1.add(root.data);
            inOrder(root.right);
        }
    }
}