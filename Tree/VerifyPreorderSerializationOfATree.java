/*https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/*/

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split("[,]");
        return recur(nodes,0) == nodes.length;
    }
    public int recur(String[] nodes, int index)
    {
        if (index >= nodes.length) return index;
        if (nodes[index].equals("#")) return index+1;
        int temp = ++index;
        index = recur(nodes,index);
        index = recur(nodes,index);
        if (index-temp >= 2) return index;
        return Integer.MAX_VALUE;
    }
}