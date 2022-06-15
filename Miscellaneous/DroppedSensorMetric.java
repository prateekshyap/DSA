/*https://binarysearch.com/problems/Dropped-Sensor-Metric*/

import java.util.*;

class Solution {
    public int solve(int[] a, int[] b) {
        int i = 0, j = 0, m = a.length, n = b.length;
        while (i < m && j < n)
        {
            if (a[i] != b[j])
            {
                if (a[i+1] == b[j]) return a[i];
                else return b[j];
            }
            ++i;
            ++j;
        }
        return -1;
        // HashSet<Integer> set1 = new HashSet<Integer>(), set2 = new HashSet<Integer>();
        // for (int elem : a) set1.add(elem);
        // for (int elem : b) set2.add(elem);
        // if (!set2.contains(a[a.length-1]))
        //     for (int elem : b)
        //         if (!set1.contains(elem))
        //             return elem;

        // for (int elem : a)
        //     if (!set2.contains(elem))
        //         return elem;

        // return -1;
    }
}