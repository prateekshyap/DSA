/*https://practice.geeksforgeeks.org/problems/stack-permutations/1/*/

class Solution {
    public static int isStackPermutation(int N, int[] A, int[] B) {
        // code here
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int i = 0, j = 0;
        while (i < N)
        {
            while (i < N && stack.peek() != B[j]) stack.push(A[i++]);
            while (j < N && stack.peek() == B[j])
            {
                stack.pop();
                ++j;
            }
        }
        if (stack.peek() == -1 && j == N) return 1;
        return 0;
    }
}
        
