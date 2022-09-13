/*https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/*/

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : s.toCharArray())
        {
            if (!stack.isEmpty() && stack.peek() == ch) stack.pop();
            else stack.push(ch);
        }
        StringBuilder build = new StringBuilder("");
        while (!stack.isEmpty())
            build.append(stack.pop());
        build.reverse();
        return build.toString();
    }
}