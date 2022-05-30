/*https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative/0/*/

//modification approach
class Tree
{
    ArrayList<Integer> inOrder(Node root)
    {
        Stack<Node> stack = new Stack<Node>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        stack.push(root);
        while (!stack.isEmpty())
        {
            Node temp = stack.peek();
            if (temp.left != null && temp.left.data > 0)
                stack.push(temp.left);
            else
            {
                Node curr = stack.pop();
                list.add(curr.data);
                curr.data *= -1;
                if (curr.right != null && curr.right.data > 0)
                    stack.push(curr.right);
            }
        }
        return list;
    }
}

//pointer approach
class Tree
{
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack =new Stack<Node>();
        if (root == null)
            return list;
        Node curr = root;
        while (curr != null || !stack.isEmpty())
        {
        	//if pointer is not null
            if (curr != null)
            {
            	//push into stack and go left
                stack.push(curr);
                curr = curr.left;
            }
            else //otherwise
            {
            	//pop from stack and add to list
                curr = stack.pop();
                list.add(curr.data);

                //go right
                curr = curr.right;
            }
        }
        return list;
    }
}

//best approach

class Solution {
    ArrayList<Integer> list;
    public int[] solve(Tree root) {
        if (root == null) return new int[0];
        list = new ArrayList<Integer>();

        Stack<Tree> stack = new Stack<Tree>();
        Tree curr = root;
        while (curr != null)
        {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty())
        {
            curr = stack.pop();
            list.add (curr.val);
            curr = curr.right;
            while (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; ++i)
            result[i] = (Integer)list.get(i);
        return result;
    }
}