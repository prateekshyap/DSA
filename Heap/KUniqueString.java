/*https://binarysearch.com/problems/K-Unique-String*/

import java.util.*;

class Solution {
    public int solve(String s, int k) {
        int[] hash = new int[26];
        int i, uniqueCount = 0, count = 0, p;
        for (i = 0; i < s.length(); ++i)
            ++hash[s.charAt(i)-'a'];
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (i = 0; i < 26; ++i)
        {
            if (hash[i] > 0)
            {
                heap.add(hash[i]);
                ++uniqueCount;
            }
        }
        while (uniqueCount-- > k)
        {
            p = heap.poll();
            count += p;
        }
        return count;
    }
}