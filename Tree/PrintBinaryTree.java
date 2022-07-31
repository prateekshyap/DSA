/*https://leetcode.com/problems/print-binary-tree/*/

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int i, j, length = (int)Math.pow(2,height)-1;
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> temp;
        for (i = 0; i < height; ++i)
        {
            temp = new ArrayList<String>();
            for (j = 0; j < length; ++j)
                temp.add("");
            list.add(temp);
        }
        update(list,root,0,0,length-1);
        return list;
    }
    public void update(List<List<String>> list, TreeNode root, int level, int start, int end)
    {
        if (root == null) return;
        int mid = (start+end)/2;
        list.get(level).set(mid,Integer.toString(root.val));
        update(list,root.left,level+1,start,mid-1);
        update(list,root.right,level+1,mid+1,end);
    }
    public int getHeight(TreeNode root)
    {
        if (root == null) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}