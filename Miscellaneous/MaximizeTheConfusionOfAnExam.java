/*https://leetcode.com/problems/maximize-the-confusion-of-an-exam/*/

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] answer = answerKey.toCharArray();
        int n = answer.length, max = 0, trueCount = 0, falseCount = 0, start = 0, end = 0;
        
        while (end < n)
        {
            if (answer[end] == 'T') ++trueCount;
            else ++falseCount;
            while (trueCount > k && falseCount > k)
            {
                if (answer[start] == 'T') --trueCount;
                else --falseCount;
                ++start;
            }
            max = Math.max(max,end-start+1);
            ++end;
        }
        
        return max;
    }
}