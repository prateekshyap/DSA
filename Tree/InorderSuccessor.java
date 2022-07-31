/*https://binarysearch.com/problems/Inorder-Successor*/

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public int solve(Tree root, int t) {
        Tree temp = root;
        Stack<Tree> stack = new Stack<Tree>();
        while (temp != null)
        {
            stack.add(temp); //add all nodes to stack
            //move properly
            if (t < temp.val) temp = temp.left;
            else if (t > temp.val) temp = temp.right;
            else break; //break when t is reached
        }
        temp = temp.right; //move one step right
        if (temp == null) //if it is null
        {
            Tree curr = stack.pop(), par = stack.peek();
            while (par != root) //till root
            {
                if (par.left == curr) return par.val; //find the first right turn
                //move up
                curr = stack.pop();
                par = stack.peek();
            }
            return par.val; //return root if nothing is remaining
        }
        //for the case where right subtree is not null
        while (temp.left != null) //move till the last left child
            temp = temp.left;
        return temp.val;
    }
}

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */

class Solution
{
    public int solve(Tree root, int t)
    {
        if (root == null) return -1; //return -1 for null node
        int curr = -1; //initialize current value to -1
        if (t == -1) //t = -1 indicates that we have found t in tree
        {
            if (root.left == null) return root.val; //if no left child remaining, return current node
            curr = solve(root.left,t); //otherwise recur for the left child with same t value
        }
        else if (t < root.val) //move left
        {
            curr = solve(root.left, t);
            if (curr == -2) return root.val; //curr = -2 indicates that we found t but it has no right subtree
        }
        else if (t > root.val) //move right, nothing to do here
            curr = solve(root.right, t);
        else //if t is found
        {
            if (root.right == null) return -2; //return -2 if right subtree is null
            curr = solve(root.right,-1); //otherwise recur for right subtree, but indicate that t is found
        }
        return curr;
    }
}