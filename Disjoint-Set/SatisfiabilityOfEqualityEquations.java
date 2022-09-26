/*https://leetcode.com/problems/satisfiability-of-equality-equations/*/

class Solution {
    int[] parent, rank;
    public boolean equationsPossible(String[] equations) {
        parent = IntStream.rangeClosed(0,25).toArray();
        rank = new int[26];
        // Arrays.sort(equations,(a,b)->(a.charAt(1) == '=' ? -1 : b.charAt(1) == '=' ? 1 : 0));
        Arrays.sort(equations,(a,b)->(b.charAt(1)-a.charAt(1)));
        for (String equation : equations)
        {
            boolean isPossible = union(equation.charAt(0)-'a',equation.charAt(3)-'a',equation.charAt(1) == '!' ? false : true);
            if (!isPossible) return false;
        }
        return true;
    }
    private boolean union(int x, int y, boolean status)
    {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY && !status) return false;
        if (status)
        {
            if (rank[parentX] > rank[parentY])
            {
                parent[parentY] = parentX;
            }
            else
            {
                parent[parentX] = parentY;
                if (rank[parentX] == rank[parentY])
                    ++rank[parentY];
            }
        }
        return true;
    }
    private int find(int x)
    {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}

class Solution {
    int[] parent, rank;
    public boolean equationsPossible(String[] equations) {
        parent = IntStream.rangeClosed(0,25).toArray();
        rank = new int[26];
        for (String equation : equations)
        {
            if (equation.charAt(1) == '=')
            {
                int x = equation.charAt(0)-'a';
                int y = equation.charAt(3)-'a';
                int parentX = find(x);
                int parentY = find(y);
                if (rank[parentX] > rank[parentY])
                    parent[parentY] = parentX;
                else
                {
                    parent[parentX] = parentY;
                    if (rank[parentX] == rank[parentY])
                        ++rank[parentY];
                }
            }
        }
        for (String equation : equations)
        {
            if (equation.charAt(1) == '!')
            {
                int x = equation.charAt(0)-'a';
                int y = equation.charAt(3)-'a';
                int parentX = find(x);
                int parentY = find(y);
                if (parentX == parentY) return false;
            }
        }
        return true;
    }
    private int find(int x)
    {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}