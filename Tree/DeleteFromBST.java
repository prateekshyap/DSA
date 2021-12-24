/*https://leetcode.com/problems/delete-node-in-a-bst/*/

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = searchNode(root,key); //spot the node with value key
        if (node == null) return root; //if not present return the tree
        TreeNode parent = searchParent(root,node); //spot the parent of the node
        if (node.left == null && node.right == null) //if node is a leaf node
        {
            //if parent is null (this is the case where only one value exists in the tree), return null
            if (parent == null) return null;
            
            //otherwise detach the node from the parent and return
            parent = transplant(parent,node,null);
            return root;
        }
        if (node.left == null) //if nonleaf node with right child present
        {
            //if parent is null (this is the case where only two values exist in the tree i.e. root and its right child), return the right child
            if (parent == null) return node.right;
            
            //otherwise, attach the right child of the node to the parent and return
            parent = transplant(parent,node,node.right);
            return root;
        }
        if (node.right == null) //if nonleaf node with left child present
        {
            //if parent is null (this is the case where only two values exist in the tree i.e. root and its left child), return the left child
            if (parent == null) return node.left;
            
            //otherwise, attach the left child of the node to the parent and return
            parent = transplant(parent,node,node.left);
            return root;
        }
        
        //if nonleaf with both subtrees present
        TreeNode successor = searchSuccessor(root,node); //spot the successor of the node (it won't be null since the node has at least two children, if not two subtrees)
        TreeNode parentSuccessor = searchParent(root,successor); //spot the parent of the successor node
        
        //since the parent of the successor and the node to be deleted can be the same node, we shall first detach the successor from the tree and then replace it with the node to be deleted
        
        //since the successor is always the leftmost node or a leaf node, it will never have a left child, hence attach its right child to its parent
        parentSuccessor = transplant(parentSuccessor,successor,successor.right);
        
        //if parent is not null (i.e. the node to be deleted is not the root), attach the successor node to the parent (it will automatically detach the node to be deleted from the tree, later we can retrive its left and right subtrees)
        if (parent != null) parent = transplant(parent,node,successor);
        
        //attach the left and right subtrees of the node to be deleted to the successor node
        successor.left = node.left;
        successor.right = node.right;
        
        //if parent is null, return the successor node, because that is the new root, else return the original root
        return parent == null ? successor : root;
    }
    
    public TreeNode transplant(TreeNode parent, TreeNode child, TreeNode grandChild) {
        if (parent.left == child)
            parent.left = grandChild;
        else
            parent.right = grandChild;
        return parent;
    }
    
    public TreeNode searchSuccessor(TreeNode root, TreeNode node) {
        //leftmost node of the right subtree of node
        TreeNode temp = node.right;
        while (temp.left != null)
            temp = temp.left;
        return temp;
    }
    
    public TreeNode searchNode(TreeNode root, int key) {
        TreeNode temp = root;
        while (temp != null && temp.val != key)
        {
            if (key < temp.val) temp = temp.left;
            else temp = temp.right;
        }
        return temp;
    }
    
    public TreeNode searchParent(TreeNode root, TreeNode node) {
        if (node == root) return null; // root has no parent so return null
        
        //find parent of node and return
        TreeNode temp = root;
        TreeNode parent = root;
        while (temp != node)
        {
            parent = temp;
            if (node.val < temp.val) temp = temp.left;
            else temp = temp.right;
        }
        return parent;
    }
}

//simple recursive version
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
    	//edge case
        if(root == null){
            return null;
        }
        
        //if key is smaller, delete from left subtree
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }

        //if key is greater, delete from right subtree
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }

        //if key is equal to root, perform delete
        else if (root.val == key){
            root = delete(root);
        }
        return root;
    }
    
    public TreeNode delete(TreeNode root){
    	//if no children, delete straightaway
        if(root.left == null && root.right == null){
            return null;
        }

        //if only right child present, return right child
        else if(root.left == null){
            return root.right;
        }

        //if only left child present, return left child
        else if(root.right == null){
             return root.left;
        }

        //otherwise
        else{
            TreeNode leftChild = root.left; 
            TreeNode rightChild = root.right;
            
            //find the predecessor node
            TreeNode predecessor = leftChild;
            
            while(predecessor.right != null){
                predecessor = predecessor.right;
            }
            
            //attach the right child of the node to be deleted to right of predecessor
            predecessor.right = rightChild;
            
            //return left child
            return leftChild;
        }
    }
}