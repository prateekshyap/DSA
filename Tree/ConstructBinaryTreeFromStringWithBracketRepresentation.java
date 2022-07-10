/*https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-string-with-bracket-representation/1/*/

class Solution {
    public static Node treeFromString(String s) {
        // code here
        return buildTree(s.toCharArray(), 0, s.length()-1);
    }
    public static Node buildTree(char[] arr, int start, int end)
    {
        int val = 0, i = start;

        //collect the integer value present in the beginning of the string
        while (i < arr.length && arr[i] != '(' && arr[i] != ')')
        {
            val *= 10;
            val += arr[i]-'0';
            ++i;
        }
        
        Node node = new Node(val); //create a node with it
        if (i >= arr.length) return node; //if string is completely parsed, return the node
        if (arr[i] == ')') return node; //if the next character is a closing bracket return the node
        
        int bCount = 1; //this will keep track of the opening brackets count
        int leftStart = ++i; //since the string is valid, current index will be an opening bracket for sure, so start from the next index
        while (bCount > 0) //till the bracket count is neutralized
        {
            if (arr[i] == '(') ++bCount; //increase if opening bracket
            else if (arr[i] == ')') --bCount; //decrease if closing bracket
            ++i; //move
        }
        int leftEnd = i-1; //end at the previous index
        node.left = buildTree(arr, leftStart, leftEnd); //recursion for left subtree
        bCount = 1; //set bracket count to 1 again
        int rightStart = ++i; //start from the next index
        if (rightStart >= arr.length || arr[rightStart-1] == ')') return node; //if the starting index is crossing the string length or starting with a closing bracket, right subtree will be null
        while (bCount > 0) //till the bracket count is neutralized
        {
            if (arr[i] == '(') ++bCount; //increase if opening bracket
            else if (arr[i] == ')') --bCount; //decrease if closing bracket
            ++i; //move
        }
        int rightEnd = i-1; //end at the previous index
        node.right = buildTree(arr, rightStart, rightEnd); //recursion for right subtree
        return node;
    }
}