/*https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/*/

class Solution {
    public String robotWithString(String s) {
        
        int[] min = new int[s.length()];
        min[s.length()-1] = Math.min(s.charAt(s.length()-1),'z');
		for (int i = s.length() - 1; i > 0; i--) {
			min[i - 1] = Math.min(s.charAt(i), min[i]);
		}
        
		StringBuilder sb = new StringBuilder();
        
		Stack<Character> stack = new Stack<>();
        
		for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            while(!stack.isEmpty() && stack.peek() <= min[i]){
                sb.append(stack.pop());
            }
		}
        
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
        
		return sb.toString();
    }
}