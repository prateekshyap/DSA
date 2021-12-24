/*https://practice.geeksforgeeks.org/problems/word-break1352/1*/

/*
Empty string is always present
For all other substrings
Check for each possible partition - 
the first part of the partition should be marked as 1
second part should be present in the hashset
If both the conditions are true then the current substring is present
So mark it as 1
*/

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        HashSet<String> set = new HashSet<String>();
        for (String str : B)
            set.add(str);
        int[] table = new int[A.length()+1];
        table[0] = 1;
        int n = A.length();
        for (int i = 1; i <= n; ++i)
        {
            for (int j = 0; j <= i; ++j)
            {
                if (table[i] == 0 && table[j] > 0 && set.contains(A.substring(j,i)))
                    table[i] = 1;
            }
        }
        return table[n];
    }
}