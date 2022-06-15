/*https://binarysearch.com/problems/Reverse-Graph*/

import java.util.*;

class Solution {
    public int[][] solve(int[][] graph) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < graph.length; ++i)
            list.add(new ArrayList<Integer>());
        for (int i = 0; i < graph.length; ++i)
        {
            for (int j = 0; j < graph[i].length; ++j)
                list.get(graph[i][j]).add(i);                  
        }
        int[][] result = new int[list.size()][list.size()];
        int i = 0;
        for (ArrayList<Integer> l : list)
        {
            int[] temp = new int[l.size()];
            for (int j = 0; j < l.size(); ++j)
                temp[j] = (Integer)l.get(j);
            result[i] = temp;
            ++i;
        }
        return result;
    }
}