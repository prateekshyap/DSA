/*https://leetcode.com/problems/fizz-buzz/*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; ++i)
            answer.add(i%15 == 0 ? "FizzBuzz" : 
                       i%3 == 0 ? "Fizz" : 
                       i%5 == 0 ? "Buzz" : Integer.toString(i));
        return answer;
    }
}