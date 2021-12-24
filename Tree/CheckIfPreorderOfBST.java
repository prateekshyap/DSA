/*https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1/*/

class Solution {
    static int canRepresentBST(int arr[], int N) {
        Stack<Integer> stack = new Stack<Integer>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < N; ++i)
        {
        	//if current value is less than root, return false
            if (arr[i] < root) {
                return 0;
            }
   
            /*
            If pre[i] is in right subtree of stack top,
            Keep removing items smaller than pre[i]
            and make the last removed item as new
            root.
            */
            while (!stack.empty() && stack.peek() < arr[i]) {
                root = stack.pop();
            }
   
            /*
            At this point either stack is empty or
            pre[i] is smaller than root, push pre[i]
            */
            stack.push(arr[i]);
        }
        return 1;
    }
}