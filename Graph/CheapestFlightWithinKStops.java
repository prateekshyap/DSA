/*https://leetcode.com/problems/cheapest-flights-within-k-stops/*/

//BFS Solution
 class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> flightDest = new HashMap<>();
        
        for(int[] flight : flights){
            int source = flight[0], dest = flight[1], price = flight[2];
            flightDest.computeIfAbsent(source, k -> new ArrayList<>()).add(new int[]{dest, price});
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        queue.add(new int[]{src, 0});
        visited[src] = 0;
        
        while(!queue.isEmpty() && K >= 0) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currStop = curr[0], currStopPrice = curr[1];
                
                for(int[] toFlightStop: flightDest.getOrDefault(currStop, new ArrayList<>())) {
                    int toDest = toFlightStop[0], toDestPrice = toFlightStop[1];
                    int newPrice = currStopPrice + toDestPrice;

                    if(visited[toDest] == Integer.MAX_VALUE || newPrice < visited[toDest]) {
                        visited[toDest] = newPrice;
                        queue.add(new int[]{toDest, newPrice});
                    }
                }
            }
            K--;
        }

        return visited[dst] == Integer.MAX_VALUE ? -1 : visited[dst];
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<List<Integer>>> graph = new ArrayList<List<List<Integer>>>();
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<List<Integer>>());
        for (int[] flight : flights)
            graph.get(flight[0]).add(Arrays.asList(flight[1],flight[2]));
        int[] costs = new int[n];
        Arrays.fill(costs,50000000);
        int len, i;
        int[] node;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{src,0});
        while (!queue.isEmpty() && K >= 0)
        {
            len = queue.size();
            for (i = 0; i < len; ++i)
            {
                node = queue.poll();
                for (List<Integer> nextNode : graph.get(node[0]))
                {
                    if (node[1]+nextNode.get(1) < costs[nextNode.get(0)])
                    {
                        costs[nextNode.get(0)] = node[1]+nextNode.get(1);
                        queue.add(new int[]{nextNode.get(0),costs[nextNode.get(0)]});
                    }
                }
            }
            --K;
        }
        
        return costs[dst] == 50000000 ? -1 : costs[dst];
    }
}

//bellman ford
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dis = new int[2][n];
        Arrays.fill(dis[0], Integer.MAX_VALUE / 2);
        Arrays.fill(dis[1], Integer.MAX_VALUE / 2);
        dis[1][src] = dis[0][src] = 0;
        for (int i = 0; i < K + 1; i++){
            for (int[] flight : flights){
                dis[i % 2][flight[1]] = Math.min(dis[(i + 1) % 2][flight[0]] + flight[2], dis[i % 2][flight[1]]);
            }
        }
        return dis[K % 2][dst] == Integer.MAX_VALUE / 2 ? -1 : dis[K % 2][dst];
    }
}

//bellman ford with optimization
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dis = new int[2][n];
        Arrays.fill(dis[0], Integer.MAX_VALUE / 2);
        Arrays.fill(dis[1], Integer.MAX_VALUE / 2);
        dis[1][src] = dis[0][src] = 0;
        boolean isUpdated = true;
        for (int i = 0; i < K + 1; i++){
            isUpdated = true;
            for (int[] flight : flights){
                if (dis[(i + 1) % 2][flight[0]] + flight[2] < dis[i % 2][flight[1]])
                {
                    isUpdated = false;
                    dis[i % 2][flight[1]] = dis[(i + 1) % 2][flight[0]] + flight[2];
                }
            }
            if (isUpdated) break;
        }
        return dis[K % 2][dst] == Integer.MAX_VALUE / 2 ? -1 : dis[K % 2][dst];
    }
}

//dp
class Solution {
 public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= k; i++) {
            if (noChange(flights, dist))
                break;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
    private static boolean noChange(int[][] flights, int[] dp) {
        boolean answer = true;
        int[] copy = Arrays.copyOf(dp, dp.length);
        for (int[] entry : flights) {
            int src = entry[0];
            int dst = entry[1];
            int cost = entry[2];
            if (copy[src] < Integer.MAX_VALUE) {
                if (copy[src]+cost < dp[dst]) {
                    dp[dst] = cost+copy[src];
                    answer = false;
                }
            }
        }

        return answer;
    }
}