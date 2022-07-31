/*https://leetcode.com/problems/cheapest-flights-within-k-stops/*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) return 0;
        // Init dists and stop, and build graph. 
        int[] dists = new int[n];
        int[] stops = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        dists[src] = 0;
        stops[src] = 0;
        List<Node>[] graph = buildGraph(n, flights);  // node, neighor, dist
        // Build min heap and start from src node.
        PriorityQueue<Node> heap = new PriorityQueue<>((f1, f2) -> Integer.compare(f1.dist, f2.dist));
        heap.add(new Node(src, 0, 0));
        while (!heap.isEmpty())
        {
            Node node = heap.poll();
            if (node.label == dst)  return node.dist;
            if (node.stop > k) continue;
            for (Node neighbor : graph[node.label])
            {
                if (dists[neighbor.label] > node.dist + neighbor.dist)
                {
                    // if node.dist + neighbor.dist update dists array and explore the neighbor.
                    dists[neighbor.label] = node.dist + neighbor.dist;
                    heap.add(new Node(neighbor.label, dists[neighbor.label], node.stop + 1));
                }
                else if (node.stop < stops[neighbor.label])
                {
                    // if node.stop < stops[neighbor.label], explore the neighbor.
                    heap.add(new Node(neighbor.label, node.dist + neighbor.dist, node.stop + 1));
                }
                stops[neighbor.label] = node.stop;
            }
        }
        return dists[dst] == Integer.MAX_VALUE ? -1 : dists[dst];
    }
    
    private List<Node>[] buildGraph(int n, int[][] flights)
    {
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] f : flights)
            graph[f[0]].add(new Node(f[1], f[2], 0));
        return graph;
    }
    
    class Node
    {
        int label, dist, stop;
        Node(int label, int dist, int stop)
        {
            this.label = label;
            this.dist = dist;
            this.stop = stop;
        }
    }
}

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
                if (dp[dst] - cost > copy[src]) {
                    dp[dst] = cost + copy[src];
                    answer = false;
                }
            }
        }

        return answer;
    }
}