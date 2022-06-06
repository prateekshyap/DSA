/*https://binarysearch.com/problems/Smallest-Intersecting-Element*/

import java.util.*;

class Solution {
    public int solve(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] row : matrix) {
            int prev = Integer.MAX_VALUE;
            for (int v : row) {
                if (v == prev) //to avoid duplicates in a single row
                    continue;
                map.put(v, map.containsKey(v) ? (Integer)map.get(v)+1 : 1);
                prev = v;
            }
        }

        int res = Integer.MAX_VALUE;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry elem = (Map.Entry)it.next();
            if ((Integer)elem.getValue() == matrix.length) //if present in all row
                res = Math.min(res,(Integer)elem.getKey()); // update result
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

class Solution {
    public int solve(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return -1;
        int cols = matrix[0].length;

        // Going through each elements of first row
        for (int i = 0; i < cols; i++) {
            int target = matrix[0][i];
            // Count is to maintain the number of rows in which target is found
            int ct = 1;

            // Finding whether the element is present in all other rows
            // Using Binary Search, since rows are sorted
            for (int j = 1; j < rows; j++) {
                boolean found = findElement(target, matrix[j]);
                if (found) ct++;
            }

            // If the element is present in all rows, that is your answer
            // Since it will be the smallest
            if (ct == rows) return target;
        }

        return -1;
    }

    // Basic Binary Search to find element in a particular row
    boolean findElement(int val, int[] arr) {
        int len = arr.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == val)
                return true;
            if (arr[mid] > val)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }
}