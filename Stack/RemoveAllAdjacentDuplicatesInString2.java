/*https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/*/

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<int[]>();
        for (char ch : s.toCharArray())
        {
            if (!stack.isEmpty() && stack.peek()[0] == ch-'a' && stack.peek()[1] == k-1) stack.pop();
            else if (!stack.isEmpty() && stack.peek()[0] == ch-'a') ++stack.peek()[1];
            else stack.push(new int[]{ch-'a',1});
        }
        StringBuilder build = new StringBuilder("");
        while (!stack.isEmpty())
        {
            int recur = stack.peek()[1];
            char ch = (char)(stack.peek()[0]+'a');
            while (recur-- > 0)
                build.append(ch);
            stack.pop();
        }
        build.reverse();
        return build.toString();
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
            // System.out.println("======"+i+","+j+"======");
            // for (int p = 0; p < stack.length; ++p)
            //     System.out.print(stack[p]+" ");
            // System.out.println();
            // for (int p = 0; p < count.length; ++p)
            //     System.out.print(count[p]+" ");
            // System.out.println();
        }
        return new String(stack, 0, i);
    }
}