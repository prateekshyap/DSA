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