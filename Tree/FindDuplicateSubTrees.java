/*https://leetcode.com/problems/find-duplicate-subtrees/*/

class Solution {
    HashMap<String,Boolean> subtrees;
    Set<TreeNode> result;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subtrees = new HashMap<String,Boolean>();
        result = new HashSet<TreeNode>();

        //serialize and check presence in hashmap
        String res = dupSubUtil(root,subtrees);

        //convert the hashset to arraylist and return
        List<TreeNode> list = new ArrayList<TreeNode>();
        Iterator<TreeNode> it = result.iterator();
        while (it.hasNext())
            list.add(it.next());
        return list;
    }
    
    String dupSubUtil(TreeNode root, HashMap<String,Boolean> subtrees)
    {
        String s = "";

        //base case
        if (root == null)
            return s + "()";
        
        //get the serialized left subtree
        String lStr = dupSubUtil(root.left,subtrees);

        //if the left subtree serialization is also empty string, return empty string
        if (lStr.equals(s))
            return s;

        //get the serialized right subtree
        String rStr = dupSubUtil(root.right,subtrees);
        
        //if the right subtree serialization is also empty string, return empty string
        if (rStr.equals(s))
            return s;

        //attach root, left and right subtrees
        s = s+"("+root.val+"("+lStr+")("+rStr+"))";

        //if this subtree is already present, add it to the result and mark it as false
        if (subtrees.containsKey(s) && subtrees.get(s))
        {
            subtrees.put(s,false);
            result.add(root);
        }
        
        //if the current subtree is already added and has value as false
        //then put false otherwise put true
        subtrees.put(s,subtrees.containsKey(s) && !subtrees.get(s) ? false : true);
        return s;
    }
}