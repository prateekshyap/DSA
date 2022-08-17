/*https://leetcode.com/problems/circular-array-loop/*/

class Solution {
    enum Color { WHITE, GRAY, BLACK }
    Color[] visited;
    int[] nums;
    int n;
    int end;
    public boolean circularArrayLoop(int[] nums) {
        n = nums.length;
        end = -1;
        visited = new Color[n];
        this.nums = nums;
        Arrays.fill(visited,Color.WHITE);
        boolean temp = false, result = false;
        for (int i = 0; i < nums.length; ++i)
        {
            visited = new Color[n];
            Arrays.fill(visited,Color.WHITE);
            temp = dfs(nums,i);
            if (i == end)
                result |= temp;
            if (result) return result;
        }
        return result;
    }
    private boolean dfs(int[] nums, int node)
    {
        if (visited[node] == Color.GRAY)
        {
            end = node;
            return true;
        }
        visited[node] = Color.GRAY;
        int nextNode = -1, count = 0;
        if (nums[node] > 0)
        {
            nextNode = (node+nums[node])%n;
            if (nums[nextNode] > 0 && nextNode != node)
                return dfs(nums,nextNode);
        }
        else if (nums[node] < 0)
        {
            nextNode = node+nums[node];
            if (nextNode < 0)
            {
                count = (int)Math.floor(-nextNode/n)+1;
                nextNode += n*count;
                nextNode %= n;
            }
            if (nums[nextNode] < 0 && nextNode != node)
                return dfs(nums,nextNode);
        }
        visited[node] = Color.BLACK;
        return false;
    }
}