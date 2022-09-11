/*https://leetcode.com/problems/minimum-operations-to-convert-number/*/

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(start);
        int steps = 0;
        boolean[] visited = new boolean[1001];
        visited[start] = true;
        while (!set.isEmpty())
        {
            Set<Integer> adjSet = new HashSet<Integer>();
            for (Integer node : set)
            {
                for (int num : nums)
                {
                    int adjNode = node+num;
                    if (adjNode == goal) return steps+1;
                    if (adjNode >= 0 && adjNode <= 1000 && !visited[adjNode])
                    {
                        adjSet.add(adjNode);
                        visited[adjNode] = true;
                    }
                    adjNode = node-num;
                    if (adjNode == goal) return steps+1;
                    if (adjNode >= 0 && adjNode <= 1000 && !visited[adjNode])
                    {
                        adjSet.add(adjNode);
                        visited[adjNode] = true;
                    }
                    adjNode = node^num;
                    if (adjNode == goal) return steps+1;
                    if (adjNode >= 0 && adjNode <= 1000 && !visited[adjNode])
                    {
                        adjSet.add(adjNode);
                        visited[adjNode] = true;
                    }
                }
            }
            set = adjSet;
            ++steps;
        }
        return -1;
    }
}