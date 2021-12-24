/*https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/*/

class Solution {
    public int longestkSubstr(String s, int k) {
        int uniqueCount = 0, result = 0;
        int[] hash = new int[26];
        int i = 0, j = -1; //i is window start and j is window end
        int n = s.length();

        //for the entire string
        while (i < n && j < n-1)
        {
            /*if the character next to the window is encountered for the first time
            increase the unique count*/
            if (hash[s.charAt(++j)-'a'] == 0) ++uniqueCount;

            //increase the count in hash
            ++hash[s.charAt(j)-'a'];

            //update the result if unique count is k
            if (uniqueCount == k) result = Math.max(result,j-i+1);

            //till the string is exhausted and unique count is greater than k
            while (i < n && uniqueCount > k)
            {
                /*if the first character of the window is the only occurrence
                decrease the unique count*/
                if (hash[s.charAt(i)-'a'] == 1) --uniqueCount;

                //decrease the count in hash
                --hash[s.charAt(i++)-'a'];
            }
        }

        //return -1 if not such substrings present
        return result == 0 ? -1 : result;
    }
}