/*https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/*/

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int p, q, Q = queries.length, P = points.length;
        double[][] dists = new double[Q][P];
        double x1, y1, x2, y2;
        int[] result = new int[Q];
        for (q = 0; q < Q; ++q)
        {
            for (p = 0; p < P; ++p)
            {
                x1 = points[p][0]; y1 = points[p][1];
                x2 = queries[q][0]; y2 = queries[q][1];
                if(Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)) <= queries[q][2])
                    ++result[q];
            }
        }
        return result;
    }
}

// faster due to computation
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int i = 0, Q = queries.length, P = points.length;
        int x1, y1, x2, y2, r;
        int[] result = new int[Q];
        for (int[] q : queries)
        {
            x2 = q[0]; y2 = q[1]; r = q[2]*q[2];
            for (int[] p : points)
            {
                x1 = p[0]; y1 = p[1];
                if((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1) <= r)
                    ++result[i];
            }
            ++i;
        }
        return result;
    }
}