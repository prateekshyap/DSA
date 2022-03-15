/*https://practice.geeksforgeeks.org/problems/binary-tree-k-level-sum3857/1*/

class Solution {
    static int kLevelSum(int K, String S) {
        // code here
        int openCount = 0, sum = 0;
        for (int i = 0; i < S.length(); ++i)
        {
            char ch = S.charAt(i);
            if (ch == '(') ++openCount;
            else if (ch == ')') --openCount;
            else if (openCount == K+1) //for Kth level
            {
                String number = "";
                int start = i; //start from current index
                while (S.charAt(i) >= '0' && S.charAt(i) <= '9') ++i; //till digit is present, increase i
                int end = --i; //store last index
                number = S.substring(start,end+1); //get the substring
                sum += Integer.parseInt(number); //convert into number and add to sum
            }
        }
        return sum;
    }
}