/*https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1*/

class Solution {
    public int findSubString(String str) {
        // Your code goes here
        int[] hash = new int[128], window = new int[128], refer = new int[128];
        int n = str.length(), min = str.length(), i;
        for (i = 0; i < n; ++i) hash[str.charAt(i)] = 1;
        int j = -1; i = 0;
        while (j < n-1)
        {
            ++j;
            window[str.charAt(j)] = 1;
            ++refer[str.charAt(j)];
            if (areSame(hash,window))
            {
                min = Math.min(j-i+1,min);
                while (areSame(hash,window))
                {
                    --refer[str.charAt(i)];
                    if (refer[str.charAt(i)] == 0) window[str.charAt(i)] = 0;
                    ++i;
                }
                min = Math.min(j-i+2,min);
            }
        }
        return min;
    }
    public boolean areSame(int[] hash, int[] window)
    {
        int i;
        for (i = 0; i < 128; ++i) if (hash[i] != window[i]) return false;
        return true;
    }
}