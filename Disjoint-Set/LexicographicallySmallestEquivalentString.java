/*https://leetcode.com/problems/lexicographically-smallest-equivalent-string/*/

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int N = 26;
        int[] parent = new int[N];
        int[] rank = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;
        Arrays.fill(rank,1);
        int S = s1.length();
        for (int i = 0; i < S; ++i)
            union(parent,rank,s1.charAt(i),s2.charAt(i));
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray())
        {
            int val = ch-'a';
            int root = find(parent,val);
            result.append((char)(root+'a'));
        }
        return result.toString();
    }
    private void union(int[] parent, int[] rank, char x, char y)
    {
        int px = find(parent,x-'a');
        int py = find(parent,y-'a');
        if (px > py)
        {
            int temp = px;
            px = py;
            py = temp;
        }
        if (px != py)
        {
            parent[py] = px;
            if (rank[px] == rank[py])
                ++rank[px];
        }
    }
    private int find(int[] parent, int x)
    {
        if (parent[x] == x) return x;
        parent[x] = find(parent,parent[x]);
        return parent[x];
    }
}