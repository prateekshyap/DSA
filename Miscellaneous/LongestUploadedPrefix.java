/*https://leetcode.com/problems/longest-uploaded-prefix/description/*/

class LUPrefix {
    boolean[] visited;
    int max;
    public LUPrefix(int n) {
        visited = new boolean[n+2];
        visited[0] = true;
        max = 1;
    }
    
    public void upload(int video) {
        visited[video] = true;
        while (visited[max]) ++max;
    }
    
    public int longest() {
        return max-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */