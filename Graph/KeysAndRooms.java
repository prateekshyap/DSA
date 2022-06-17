/*https://leetcode.com/problems/keys-and-rooms/*/

class Solution {
    int[] color;
    int visitCount;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        color = new int[n];
        visitCount = 0;
        
        dfs(rooms, 0);
        
        return visitCount == n;
    }
    public void dfs(List<List<Integer>> rooms, int node)
    {
        color[node] = 1; //entry color
        
        for (Integer adjacentNode : rooms.get(node))
            if (color[adjacentNode] == 0) //if not visited
                dfs(rooms,adjacentNode);
        
        color[node] = 2; //exit color
        ++visitCount;
    }
}