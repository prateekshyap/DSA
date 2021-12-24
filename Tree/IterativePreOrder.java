/*https://practice.geeksforgeeks.org/problems/preorder-traversal-iterative/0/*/

class Tree
{
    ArrayList<Integer> preOrder(Node root)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if (root == null)
            return list;
        
        //push root to stack
        stack.push(root);
        while (!stack.isEmpty())
        {
        	//pop from stack and add to the list
            Node temp = stack.pop();
            list.add(temp.data);

            //add its children, first right then left
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
        return list;
    }
}