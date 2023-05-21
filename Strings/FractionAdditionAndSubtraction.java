/*https://leetcode.com/problems/fraction-addition-and-subtraction/*/

class Solution {
    public String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0, B = 1;
        while (sc.hasNext())
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A = A*b+a*B;
            B = B*b;
            int gcd = gcd(A,B);
            A /= gcd;
            B /= gcd;
        }
        return A+"/"+B;
    }
    private int gcd(int a, int b)
    {
        return b == 0 ? Math.abs(a) : gcd(b,a%b);
    }
}