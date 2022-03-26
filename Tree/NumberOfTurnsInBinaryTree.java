/*https://practice.geeksforgeeks.org/problems/number-of-turns-in-binary-tree/1*/

class Solution
{
    static int count;
    static int NumberOfTurns(Node root, int first, int second)
    {
        Node LCA = findLCA(root, first, second);
 
        // there is no path between these two node
        if (LCA == null)
            return -1;
        count = 0;
 
        // case 1:
        if (LCA.data != first && LCA.data != second) {
 
            // count number of turns needs to reached
            // the second node from LCA
            if (countTurn(LCA.right, second, false)
                    || countTurn(LCA.left, second, true))
                ;
 
            // count number of turns needs to reached
            // the first node from LCA
            if (countTurn(LCA.left, first, true)
                    || countTurn(LCA.right, first, false))
                ;
            return count + 1;
        }
 
        // case 2:
        if (LCA.data == first) {
 
            // count number of turns needs to reached
            // the second node from LCA
            countTurn(LCA.right, second, false);
            countTurn(LCA.left, second, true);
            return count;
        } else {
 
            // count number of turns needs to reached
            // the first node from LCA1
            countTurn(LCA.right, first, false);
            countTurn(LCA.left, first, true);
            return count;
        }
    }
    // Utility function to find the LCA of
    // two given values n1 and n2.
    static Node findLCA(Node root, int n1, int n2) {
        // Base case
        if (root == null)
            return null;
 
        // If either n1 or n2 matches with
        // root's key, report the presence by
        // returning root (Note that if a key
        // is ancestor of other, then the
        // ancestor key becomes LCA
        if (root.data == n1 || root.data == n2)
            return root;
 
        // Look for keys in left and right subtrees
        Node leftLca = findLCA(root.left, n1, n2);
        Node rightLca = findLCA(root.right, n1, n2);
 
        // If both of the above calls return
        // Non-NULL, then one key is present
        // in once subtree and other is present
        // in other, So this node is the LCA
        if (leftLca != null && rightLca != null)
            return root;
 
        // Otherwise check if left subtree or right
        // subtree is LCA
        return (leftLca != null) ? leftLca : rightLca;
    }
 
    // function count number of turn need to reach
    // given node from it's LCA we have two way to
    static boolean countTurn(Node root, int key, boolean turn) {
        if (root == null)
            return false;
 
        // if found the key value in tree
        if (root.data == key)
            return true;
 
        // Case 1:
        if (turn == true) {
            if (countTurn(root.left, key, turn))
                return true;
            if (countTurn(root.right, key, !turn)) {
                count += 1;
                return true;
            }
        } else // Case 2:
        {
            if (countTurn(root.right, key, turn))
                return true;
            if (countTurn(root.left, key, !turn)) {
                count += 1;
                return true;
            }
        }
        return false;
    }
}