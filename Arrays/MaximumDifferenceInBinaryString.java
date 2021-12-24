/*https://practice.geeksforgeeks.org/problems/maximum-difference-of-zeros-and-ones-in-binary-string4111/1*/

//modified Kadane's algorithm
class Solution {
    int maxSubstring(String S) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < S.length(); ++i)
        {
            count += S.charAt(i) == '0' ? 1 : -1;
            result = Math.max(count,result);
            if (count < 0) count = 0; //kadane step
        }
        return result;
    }
}