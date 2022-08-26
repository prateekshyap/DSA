/*https://leetcode.com/problems/reordered-power-of-2/*/

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int i, copy, target = 1;
        int[] hash = new int[10];
        while (n > 0)
        {
            ++hash[n%10];
            n /= 10;
        }
        boolean flag = true;
        int[] powHash = new int[10];
        for (int pow = 0; pow <= 30; ++pow)
        {
            flag = true;
            powHash = new int[10];
            copy = target;
            while (copy > 0)
            {
                ++powHash[copy%10];
                copy /= 10;
            }
            for (i = 0; i < 10; ++i)
                if (hash[i] != powHash[i])
                    flag = false;
            if (flag) return true;
            target <<= 1;
        }
        return false;
    }
}