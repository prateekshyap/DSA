/*https://leetcode.com/problems/compare-version-numbers/*/

class Solution {
    public int compareVersion(String version1, String version2) {
        int[] v1 = getNumbers(version1.toCharArray());
        int[] v2 = getNumbers(version2.toCharArray());
        if (v1.length < v2.length)
        {
            int[] temp = new int[v2.length];
            for (int i = 0; i < v1.length; ++i)
                temp[i] = v1[i];
            v1 = temp;
        }
        else if (v2.length < v1.length)
        {
            int[] temp = new int[v1.length];
            for (int i = 0; i < v2.length; ++i)
                temp[i] = v2[i];
            v2 = temp;
        }
        for (int i = 0; i < v1.length; ++i)
            if (v1[i] < v2[i]) return -1;
            else if (v1[i] > v2[i]) return 1;
        return 0;
    }
    private int[] getNumbers(char[] version)
    {
        int[] v = new int[2];
        int N = version.length, n = 0, i, num = 0;
        for (i = 0; i < N; ++i)
        {
            if (version[i] == '.')
            {
                if (n == v.length) v = resize(v);
                v[n++] = num;
                num = 0;
            }
            else
            {
                num = num*10+(version[i]-'0');
            }
        }
        if (n == v.length) v = resize(v);
        v[n++] = num;
        return v;
    }
    private int[] resize(int[] v)
    {
        int[] temp = new int[v.length*2];
        for (int j = 0; j < v.length; ++j)
            temp[j] = v[j];
        v = temp;
        return v;
    }
}