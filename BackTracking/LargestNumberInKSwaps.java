/*https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1*/

class Solution
{
    static String maxValue;
    public static void swapAndFind(char[] s, int k, int currSwaps)
    {
        if (currSwaps == k) return; //if all swaps exhausted, return
        for (int j = 0; j < s.length-1; ++j) //for every digit
        {
            for (int i = j+1; i < s.length; ++i) //for every next digit
            {
                if (s[j] < s[i]) //if the picked digit is less than its next ones
                {
                	/*backtracking step - 1*/
                    char temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                    //update the max
                    maxValue = maxValue.compareTo(String.valueOf(s)) < 0 ? String.valueOf(s) : maxValue;
                    swapAndFind(s,k,currSwaps+1); //baxktracking step - 2
                    /*backtracking step - 3*/
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
    }
    public static String findMaximumNum(String str, int k)
    {
        maxValue = str; //store the string in max
        swapAndFind(str.toCharArray(), k, 0); //recursion call
        return maxValue;
    }
}