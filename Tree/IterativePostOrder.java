/*https://practice.geeksforgeeks.org/problems/postorder-traversal-iterative/0/*/
 
class Tree {
    ArrayList<Integer> postOrder(Node root) {
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

            //add its children, first left then right
            if (temp.left != null)
                stack.push(temp.left);
            if (temp.right != null)
                stack.push(temp.right);
        }

        //revese the list
        Collections.reverse(list);
        return list;
    }
}