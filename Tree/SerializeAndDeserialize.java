/*https://leetcode.com/problems/serialize-and-deserialize-binary-tree/*/

public class Codec {
    StringBuffer result;
    TreeNode root;
    int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        result = new StringBuffer("");
        serPreorder(root);
        System.out.println(result);
        return result.toString();
    }
    public void serPreorder(TreeNode root)
    {
        if (root == null)
            result.append("n#");
        else
        {
            result.append(root.val);
            result.append("#");
            serPreorder(root.left);
            serPreorder(root.right);
        }
    }
    public TreeNode deserPreOrder(String[] tokens)
    {
        if (index == tokens.length) return null;
        if (tokens[index].equals("n")) return null;
        if (root == null)
        {
            root = new TreeNode(Integer.parseInt(tokens[index]));
            ++index;
            root.left = deserPreOrder(tokens);
            ++index;
            root.right = deserPreOrder(tokens);
            return root;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(tokens[index]));
        ++index;
        newNode.left = deserPreOrder(tokens);
        ++index;
        newNode.right = deserPreOrder(tokens);
        return newNode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split("[#]");
        index = 0;
        root = deserPreOrder(tokens);
        return root;
    }
}

/*https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1*/

class Tree 
{
    StringBuffer result;
    Node root;
    int index;

    public Node deserPreOrder(ArrayList<Integer> tokens)
    {
        if (index == tokens.size()) return null;
        if ((Integer)tokens.get(index) == -1) return null;
        if (root == null)
        {
            root = new Node((Integer)tokens.get(index));
            ++index;
            root.left = deserPreOrder(tokens);
            ++index;
            root.right = deserPreOrder(tokens);
            return root;
        }
        Node newNode = new Node((Integer)tokens.get(index));
        ++index;
        newNode.left = deserPreOrder(tokens);
        ++index;
        newNode.right = deserPreOrder(tokens);
        return newNode;
    }
    
    //Function to serialize a tree and return a list containing nodes of tree.
    public void serialize(Node root, ArrayList<Integer> A) 
    {
        //code here
        if (root == null)
            A.add(-1);
        else
        {
            A.add(root.data);
            serialize(root.left,A);
            serialize(root.right,A);
        }
    }
    
    //Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        index = 0;
        root = deserPreOrder(A);
        return root;
    }
};