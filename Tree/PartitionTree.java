/*https://binarysearch.com/problems/Partition-Tree*/

class Solution {
    int[] res;
    public int[] solve(Tree root) {
        res = new int[2];
        recur(root);
        return res;
    }
    public void recur(Tree root)
    {
        if (root == null) return;
        recur(root.left);
        if (root.left == null && root.right == null) ++res[0];
        else ++res[1];
        recur(root.right);
    }
}

/*

class Solution {
    ArrayList<Integer> al;
    public int[] solve(Tree root) {
        al=new ArrayList<>();
        inorder(root);
        int ans[]=new int[al.size()];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=al.get(i);
        }
        return ans;
    }
    public void inorder(Tree root)
    {
        if(root==null)
        return;
        
        Stack<Tree> stack=new Stack<>();
        Tree current=root;
        while(current!=null)
        {
            stack.push(current);
            current=current.left;
        }

        while(!stack.isEmpty())
        {
            current=stack.pop();
            al.add(current.val);
            current=current.right;
            while(current!=null)
            {
                stack.push(current);
                current=current.left;
            }
        }

    }
}
*/