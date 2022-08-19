/*https://leetcode.com/problems/interval-list-intersections/*/

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int f = 0, s = 0, F = firstList.length, S = secondList.length;
        int[] first, second, newEntry;
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[][] result;
        while (f < F && s < S)
        {
            first = firstList[f];
            second = secondList[s];
            
            if (!(first[1] < second[0] || second[1] < first[0]))
            {
                newEntry = new int[2];
                newEntry[0] = Math.max(first[0],second[0]);
                newEntry[1] = Math.min(first[1],second[1]);
                list.add(newEntry);
                if (newEntry[1] == first[1]) ++f;
                else if (newEntry[1] == second[1]) ++s;
            }
            else
            {
                if (first[1] < second[0]) ++f;
                else if (second[1] < first[0]) ++s;
            }
        }
        result = new int[list.size()][2];
        int i = 0;
        for (int[] entry : list)
            result[i++] = entry;
        return result;
    }
}

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int f = 0, s = 0, F = firstList.length, S = secondList.length;
        int[] first, second, newEntry;
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[][] result;
        while (f < F && s < S)
        {
            first = firstList[f];
            second = secondList[s];
            
            if (first[1] < second[0]) ++f;
            else if (second[1] < first[0]) ++s;
            else
            {
                newEntry = new int[2];
                newEntry[0] = Math.max(first[0],second[0]);
                newEntry[1] = Math.min(first[1],second[1]);
                list.add(newEntry);
                if (newEntry[1] == first[1]) ++f;
                else if (newEntry[1] == second[1]) ++s;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}