/*https://leetcode.com/problems/parallel-courses-iii/*/

/*TLE approach*/
class Solution {
    boolean[] visited;
    List<List<Integer>> components, graph;
    int weight, maxWeight, componentsMax;
    public int minimumTime(int n, int[][] relations, int[] time) {
        components = new ArrayList<List<Integer>>();
        graph = new ArrayList<List<Integer>>();
        visited = new boolean[n];
        int i, noc = 0;
        maxWeight = componentsMax = Integer.MIN_VALUE;
        
        //create a undirected graph for the given edges
        for (i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        
        for (int[] edge : relations)
        {
            graph.get(edge[0]-1).add(edge[1]-1);
            graph.get(edge[1]-1).add(edge[0]-1);
        }
        
        //find out the connected components
        for (i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                ++noc;
                visited[i] = true;
                List<Integer> comp = new ArrayList<Integer>();
                comp.add(i);
                findComponents(i,comp);
                components.add(comp);
            }
        }

        //make the graph directed
        for (int[] edge : relations)
            graph.get(edge[1]-1).remove(new Integer(edge[0]-1));
        
        //find the indegrees for each node
        int[] indegrees = new int[n];
        
        for (List<Integer> adjNodes : graph)
            for (Integer node : adjNodes)
                ++indegrees[node];

        visited = new boolean[n];
        
        for (List<Integer> component : components) //for each component
        {
            maxWeight = Integer.MIN_VALUE; //redefine maxWeight
            for (Integer node : component) //for each node in the component
            {
                if (indegrees[node] == 0) //if the indegree is 0
                {
                    weight = 0;
                    visited[node] = true;
                    checkWeight(node,time); //find out the maximum weight required
                }
            }
            if (maxWeight > componentsMax) //update the maximum over all components
                componentsMax = maxWeight;
        }
        
        return componentsMax;
    }
    public void checkWeight(int src, int[] time)
    {
        weight += time[src]; //add weight
        boolean isAvail = false;
        List<Integer> adjNodes = graph.get(src);
        
        for (Integer node : adjNodes) //for each adjacent node
        {
            if (!visited[node]) //if not visited
            {
                isAvail = true; //mark
                visited[node] = true; //mark visited
                checkWeight(node,time); //recursion
                visited[node] = false; //backtrack
            }
        }
        
        if (!isAvail) //if recursion was not called
        {
            if (weight > maxWeight) //update the maximum weight for this component
                maxWeight = weight;
        }
        
        weight -= time[src]; //backtrack
    }
    public void findComponents(int src, List<Integer> comp)
    {
        List<Integer> adjNodes = graph.get(src);
        for (int node : adjNodes)
        {
            if (!visited[node])
            {
                visited[node] = true;
                comp.add(node);
                findComponents(node,comp);
            }
        }
    }
}

/*Small modification for DP*/
class Solution {
    boolean[] visited;
    List<List<Integer>> components, graph;
    int weight, maxWeight, componentsMax;
    int[] dp;
    public int minimumTime(int n, int[][] relations, int[] time) {
        components = new ArrayList<List<Integer>>();
        graph = new ArrayList<List<Integer>>();
        visited = new boolean[n];
        dp = new int[n];
        int i, noc = 0;
        maxWeight = componentsMax = Integer.MIN_VALUE;
        
        for (i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        
        for (int[] edge : relations)
        {
            graph.get(edge[0]-1).add(edge[1]-1);
            graph.get(edge[1]-1).add(edge[0]-1);
        }
        
        for (i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                ++noc;
                visited[i] = true;
                List<Integer> comp = new ArrayList<Integer>();
                comp.add(i);
                findComponents(i,comp);
                components.add(comp);
            }
        }

        for (int[] edge : relations)
            graph.get(edge[1]-1).remove(new Integer(edge[0]-1));
        
        int[] indegrees = new int[n];
        
        for (List<Integer> adjNodes : graph)
            for (Integer node : adjNodes)
                ++indegrees[node];

        visited = new boolean[n];
        
        for (List<Integer> component : components)
        {
            maxWeight = Integer.MIN_VALUE;
            for (Integer node : component)
            {
                if (indegrees[node] == 0)
                {
                    weight = 0;
                    visited[node] = true;
                    checkWeight(node,time);
                }
            }
            if (maxWeight > componentsMax)
                componentsMax = maxWeight;
        }
        
        return componentsMax;
    }
    public void checkWeight(int src, int[] time)
    {
        weight += time[src];
        dp[src] = weight;
        boolean isAvail = false;
        List<Integer> adjNodes = graph.get(src);
        
        for (Integer node : adjNodes)
        {
            if (!visited[node])
            {
                isAvail = true;
                visited[node] = true;
                if (dp[node] < weight+time[node]) //recursion only if the current weight is larger than the previously stored weight
                    checkWeight(node,time);
                visited[node] = false;
            }
        }
        
        if (!isAvail)
        {
            if (weight > maxWeight)
                maxWeight = weight;
        }
        
        weight -= time[src];
    }
    public void findComponents(int src, List<Integer> comp)
    {
        List<Integer> adjNodes = graph.get(src);
        for (int node : adjNodes)
        {
            if (!visited[node])
            {
                visited[node] = true;
                comp.add(node);
                findComponents(node,comp);
            }
        }
    }
}

/*Efficient Solution*/
class Solution 
{
    public int minimumTime(int n, int[][] relations, int[] time) 
    {
    	//create a graph and find out indegrees
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        int[] inDegrees = new int[n];
        for(int[] a : relations)
        {
            graph[a[0]-1].add(a[1]-1);
            ++inDegrees[a[1]-1];
        }
        List<Integer> list = new ArrayList<>();
        int[] dist = new int[n];
        int maxValue = 0;
        for(int i = 0; i < n; i++) //for each node
        {
            if(inDegrees[i] == 0) //if indegree is 0
            {
                list.add(i); //add to list
                dist[i] = time[i]; //store distance
                maxValue = Math.max(maxValue, dist[i]); //update the maximum value
            }
        }
        
        for(int i = 0; i < list.size(); i++) //for each node with 0 indegree
        {
            int preReq = list.get(i);
            for(int a : graph[preReq]) //for each adjacent node in graph
            {
                --inDegrees[a]; //reduce indegree
                dist[a] = Math.max(dist[preReq]+time[a], dist[a]); //update the weight in the array
                maxValue = Math.max(maxValue, dist[a]); //update the maximum value
                if(inDegrees[a] == 0) list.add(a); //if indegrees is 0, add to list
            }
        }
        return maxValue;
    }
}