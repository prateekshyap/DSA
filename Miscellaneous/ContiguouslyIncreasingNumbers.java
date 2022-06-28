/*https://binarysearch.com/problems/Contiguously-Increasing-Numbers*/

import java.util.*;

class Solution {
    public int[] solve(int start, int end) {
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i, dig;
        String temp;

        for (i = 1; i <= 9; ++i)
        {
            queue.add(i);
            if (i >= start && i <= end) result.add(i);
        }

        while (!queue.isEmpty())
        {
            i = (Integer)queue.poll();
            dig = i%10;
            ++dig;
            if (dig > 9) continue;
            i *= 10;
            i += dig;
            if (i >= start && i <= end)
                result.add(i);
            if (i <= end) queue.add(i);
        }


        int[] arr = new int[result.size()];
        for (i = 0; i < arr.length; ++i)
            arr[i] = (Integer)result.get(i);
        return arr;
    }
}

import java.util.*;

class Solution {
    public int[] solve(int start, int end) {
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i, dig;
        String temp;

        for (i = 1; i <= 9; ++i) queue.add(i);

        while (!queue.isEmpty())
        {
            i = (Integer)queue.poll();
            if (i >= start && i <= end) result.add(i);

            if (i%10 == 9) continue;
            i = (i*10)+((i%10)+1);

            if (i <= end) queue.add(i);
        }


        int[] arr = new int[result.size()];
        for (i = 0; i < arr.length; ++i)
            arr[i] = (Integer)result.get(i);
        return arr;
    }
}