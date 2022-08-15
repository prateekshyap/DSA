/*https://leetcode.com/problems/plates-between-candles/*/

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] nextRightCandleIndex = new int[s.length() + 1];
        int[] nextLeftCandleIndex = new int[s.length() + 1];
        int[] platesSum = new int[s.length() + 1];
        
        Arrays.fill(nextRightCandleIndex, -1);
        Arrays.fill(nextLeftCandleIndex, -1);
        
        for (int i = 0; i < s.length(); i++) {
            nextLeftCandleIndex[i + 1] = (s.charAt(i) == '|') ? i : nextLeftCandleIndex[i];
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            nextRightCandleIndex[i] = (s.charAt(i) == '|') ? i : nextRightCandleIndex[i + 1];
        }
        
        for (int i = 0; i < s.length(); i++) {
            platesSum[i + 1] = (s.charAt(i) == '*') ? platesSum[i] + 1 : platesSum[i];
        }
        // for (int i = 0; i <= s.length(); ++i)
        //     System.out.println(i+" "+nextLeftCandleIndex[i]+" "+nextRightCandleIndex[i]+" "+platesSum[i]);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int rightCandleIndex = nextRightCandleIndex[q[0]];
            int leftCandleIndex = nextLeftCandleIndex[q[1] + 1];
            System.out.println(leftCandleIndex+" "+rightCandleIndex);
            result[i] = (rightCandleIndex < leftCandleIndex && rightCandleIndex != -1) ? 
                platesSum[leftCandleIndex] - platesSum[rightCandleIndex] :
                0;
        }
        
        return result;
    }
}