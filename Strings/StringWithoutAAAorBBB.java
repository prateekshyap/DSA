/*https://leetcode.com/problems/string-without-aaa-or-bbb/*/

class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0)
        {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L-1) == ans.charAt(L-2))
            {
                if (ans.charAt(L-1) == 'b')
                    writeA = true;
            }
            else
            {
                if (A >= B)
                    writeA = true;
            }

            if (writeA)
            {
                A--;
                ans.append('a');
            }
            else
            {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }
}

class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int x = Math.min(a, Math.min(b, Math.abs(a - b))); 
        if (a > b){
            sb.append("aab".repeat(x));
            b -= x;
            a -= 2 * x;
        }
        if (a < b){
            sb.append("bba".repeat(x));
            b -= 2 * x;
            a -= x;
        }
        if (a == b){
            sb.append("ab".repeat(a));
        }
        if (a == 0){
            sb.append("b".repeat(b));
        }
        if (b == 0){
            sb.append("a".repeat(a));
        }
        return sb.toString();
    }
}