/*https://leetcode.com/problems/all-possible-full-binary-trees/*/

class Solution {
    StringBuffer key;
    int count, n;
    List<TreeNode> list;
    TreeNode cloneTree;
    HashMap<String,Integer> map;
    public List<TreeNode> allPossibleFBT(int n) {
        if (n%2 == 0) return new ArrayList<TreeNode>(); //even number of nodes is not possible
        map = new HashMap<String,Integer>(); //create a map for dp
        this.n = n; //store n globally
        TreeNode root = new TreeNode(0); //create a root node
        list = new ArrayList<TreeNode>(); //create a list of nodes
        recurTreeGenerator(root,1); //recursion call
        return list;
    }
    public void recurTreeGenerator(TreeNode root, int currTreeSize)
    {
        String treeKey = generateTreeKey(root); //get the key of current tree
        if (map.containsKey(treeKey)) return; //if key is already checked, return
        if (currTreeSize == n) //if current tree size is n
        {
            cloneTree = new TreeNode(0); //create a new node
            clone(root,cloneTree); //clone the current tree
            list.add(cloneTree); //add to list
            map.put(treeKey,1); //add to dp
            return;
        }
        
        map.put(treeKey,1); //add to dp
        Stack<TreeNode> stack = new Stack<TreeNode>(); //create a stack
        
        //push root to stack
        stack.push(root);
        while (!stack.isEmpty())
        {
        	//pop from stack and add to the list
            TreeNode temp = stack.pop();
            
            if (temp.left == null && temp.right == null) //if current node is a leaf
            {
            	//attach two children
                temp.left = new TreeNode(0);
                temp.right = new TreeNode(0);

                /*recursion call*/
                recurTreeGenerator(root, currTreeSize+2);

                //backtracking
                temp.left = null;
                temp.right = null;
            }

            //add its children, first right then left
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }
    public void clone(TreeNode root, TreeNode copy)
    {
        if (root.left != null) //if left child is present
        {
            copy.left = new TreeNode(0); //create a left child in clone tree
            clone(root.left,copy.left); //recur on left child
        }
        if (root.right != null) //if right child is present
        {
            copy.right = new TreeNode(0); //create a right child in clone tree
            clone(root.right,copy.right); //recur on right child
        }        
    }
    public String generateTreeKey(TreeNode root)
    {
        key = new StringBuffer("#");
        recurKeyGenerator(root);
        return key.toString();
    }
    public void recurKeyGenerator(TreeNode root)
    {
        if (root == null) //if root is null
        {
            key.append("0"); //append 0
            key.append("#");
            return;
        }
        key.append("1"); //append 1
        key.append("#");
        recurKeyGenerator(root.left); //recur on left child
        recurKeyGenerator(root.right); //recur on right child
    }
}

class Solution {
    private List<TreeNode>[] dp;
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new LinkedList<>();
        }
        dp = new LinkedList[n+1];
        return buildTree(n);
    }
    
    private List<TreeNode> buildTree(int n) {
        List<TreeNode> list = new LinkedList<>();
        if (n <= 0) {
            return list;
        }
        
        if (n == 1) {
            TreeNode root = new TreeNode(0);
            list.add(root);
            return list;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        
        for (int i = 1; i < n; i += 2) {
            int j = n - i - 1;
            List<TreeNode> left = buildTree(i);
            List<TreeNode> right = buildTree(j);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        dp[n] = list;
        return list;
    }
}

class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N==1){
            res.add(new TreeNode(0));
            return res;
        }
        N=N-1;
        for(int i=1; i<N;i+=2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N-i);
            for(TreeNode nl: left){
                for(TreeNode nr:right){
                    TreeNode cur = new TreeNode(0);
                    cur.left=nl;
                    cur.right=nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}