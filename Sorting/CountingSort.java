/*https://practice.geeksforgeeks.org/problems/counting-sort/1*/

class Solution
{
    public static String countSort(String s)
    {
        char[] arr = s.toCharArray();
        int[] charCount = new int[26];
        for (char ch : arr)
            ++charCount[ch-'a'];
        int index = 0;
        for (int i = 0; i < 26; ++i)
        {
            if (charCount[i] > 0)
            {
                while (charCount[i]-- > 0)
                    arr[index++] = (char)(i+'a');
            }
        }
        return String.valueOf(arr);
    }
}