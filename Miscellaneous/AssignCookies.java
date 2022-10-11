/*https://leetcode.com/problems/assign-cookies/*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> children = new PriorityQueue<>(), cookies = new PriorityQueue<>();
        for (int child : g)
            children.add(child);
        for (int cookie : s)
            cookies.add(cookie);
        int contentChildren = 0;
        while (!children.isEmpty())
        {
            int child = children.poll();
            while (!cookies.isEmpty())
            {
                int cookie = cookies.poll();
                if (cookie >= child)
                {
                    ++contentChildren;
                    break;
                }
            }
        }
        return contentChildren;
    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        int i = 0, j = 0;
        if (s.length == 0) return 0;
        while (i < s.length && j < g.length)
        {
            if (s[i] >= g[j])
            {
                ++count;
                ++j;
            }
            ++i;
        }
        return count;
    }
}