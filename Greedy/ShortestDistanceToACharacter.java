/*https://leetcode.com/problems/shortest-distance-to-a-character/*/

class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length(), i, one = -1, two = -1, left, right, dist;
        int[] result = new int[n];
        for (i = 0; i < n; ++i)
        {
            if (s.charAt(i) == c)
            {
                one = two;
                two = i;
                left = one;
                right = two;
                dist = 0;
                if (left == -1)
                    while (right != -1)
                        result[right--] = dist++;
                else while (left <= right)
                    result[left++] = result[right--] = dist++;
            }
        }
        dist = 0;
        if (s.charAt(n-1) != c)
            while (two != n)
                result[two++] = dist++;
        return result;
    }
}