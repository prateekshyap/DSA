/*Tree Sum

Medium

Given a binary tree root, return the sum of all values in the tree.

Constraints

    n ≤ 100,000 where n is the number of nodes in root

Example 1
Input
Visualize

root =

1

2

3

5
Output

11

Explanation

11 = 1 + 2 + 3 + 5

https://practice.geeksforgeeks.org/problems/sum-of-binary-tree/1/

*/

class Solution {
    int sum;
    public int solve(Tree root) {
        sum = 0;
        recur(root);
        return sum;
    }
    public void recur(Tree root)
    {
        if (root == null) return;
        recur(root.left);
        sum += root.val;
        recur(root.right);
    }
}