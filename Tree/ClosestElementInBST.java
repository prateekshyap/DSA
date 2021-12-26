/*https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1*/

class Solution
{
    static int minDiff(Node  root, int K) 
    { 
        // Write your code here
        Node temp = root;
        int currElem = root.data;
        while (temp != null)
        {
            if (K == temp.data)
            {
                currElem = K;
                break;
            }
            else if (K < temp.data)
                temp = temp.left;
            else
                temp = temp.right;
            if (temp != null && Math.abs(temp.data-K) < Math.abs(currElem-K))
                currElem = temp.data;
        }
        return Math.abs(currElem-K);
    } 
}