/*https://leetcode.com/problems/construct-quad-tree/*/

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return buildTree(grid,0,0,grid.length);
    }
    private Node buildTree(int[][] grid, int topLeftRow, int topLeftColumn, int length)
    {
        if (length == 1) return new Node(grid[topLeftRow][topLeftColumn] == 1 ? true : false, true);
        
        int zeroCounter = 0, oneCounter = 0;
        
        int bottomRightRow = topLeftRow+length;
        int bottomRightColumn = topLeftColumn+length;
        
        for (int r = topLeftRow; r < bottomRightRow; ++r)
        {
            for (int c = topLeftColumn; c < bottomRightColumn; ++c)
            {
                if (grid[r][c] == 1) ++oneCounter; else ++zeroCounter;
                if (oneCounter > 0 && zeroCounter > 0) break;
            }
            if (oneCounter > 0 && zeroCounter > 0) break;
        }
        if (oneCounter == 0) return new Node(false,true);
        if (zeroCounter == 0) return new Node(true,true);
        
        Node node = new Node(true,false);
        int halfLength = length/2;
        
        node.topLeft = buildTree(grid,topLeftRow,topLeftColumn,halfLength);
        node.topRight = buildTree(grid,topLeftRow,topLeftColumn+halfLength,halfLength);
        node.bottomLeft = buildTree(grid,topLeftRow+halfLength,topLeftColumn,halfLength);
        node.bottomRight = buildTree(grid,topLeftRow+halfLength,topLeftColumn+halfLength,halfLength);
        
        return node;
    }
}

