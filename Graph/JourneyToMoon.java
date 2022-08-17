/*https://www.hackerrank.com/challenges/journey-to-the-moon/problem*/

class Result {
    static boolean[] visited;
    static int visitCount;
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
    	//create a graph from the given astronaut data
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        for (List<Integer> edge : astronaut)
        {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        //find the sizes of the connected components
        visited = new boolean[n];
        visitCount = 0;
        ArrayList<Integer> components = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                int prevCount = visitCount;
                visited[i] = true;
                ++visitCount;
                runDFS(graph,i);
                components.add(visitCount-prevCount);
            }
        }

        /*
		The whole idea is- 
        since we cannot add the edges from the same component
		i.e. we cannot send two astronauts from the same country
		so if we can find out the number of edges
        that belong to the same country
		and subtract that number from
        the total possible number of edges for n astronauts
        the remaining number will be the total number of edges
        that cross through the components, which is the answer
        */
        int sumEdges = 0;
        for (int i = 0; i < components.size(); ++i)
        {
            int size = (Integer)components.get(i);
            sumEdges += size*(size-1)/2;
        }
        return ((long)n*(long)(n-1)/2)-sumEdges;
    }

    public static void runDFS(ArrayList<ArrayList<Integer>> graph, int src)
    {
        for (Integer adjacentNode : graph.get(src))
        {
            if (!visited[adjacentNode])
            {
                visited[adjacentNode] = true;
                ++visitCount;
                runDFS(graph,adjacentNode);
            }
        }
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
    static boolean[] visited;
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
    // Write your code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        visited = new boolean[n];
        for (; i < n; ++i)
            graph.add(new ArrayList<Integer>());
        for (List<Integer> a : astronaut)
        {
            graph.get(a.get(0)).add(a.get(1));
            graph.get(a.get(1)).add(a.get(0));
        }
        List<List<Integer>> connectedComponents = new ArrayList<List<Integer>>();
        for (i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                List<Integer> newComponent = new ArrayList<Integer>();
                dfs(graph,i,newComponent);
                connectedComponents.add(newComponent);
            }
        }
        long result = 0;
        for (List<Integer> component : connectedComponents)
        {
            result = result+((long)(component.size()*(n-component.size())));
            n -= component.size();
        }
        return result;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> graph, int src, List<Integer> component)
    {
        visited[src] = true;
        component.add(src);
        
        for (Integer adjNode : graph.get(src))
            if (!visited[adjNode])
                dfs(graph,adjNode,component);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
    static int[] parent, size;
    static HashSet<Integer> roots;
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
    // Write your code here
        parent = IntStream.rangeClosed(0, n-1).toArray();
        size = new int[n]; Arrays.fill(size,1);
        roots = new HashSet<Integer>();
        for (int i = 0; i < n; ++i)
            roots.add(i);
        
        for (List<Integer> a : astronaut)
            union(a.get(0),a.get(1));
            
        long deduct = (long)n*(long)(n-1)/2;
        for (Integer p : roots)
            deduct -= ((long)size[p]*(long)(size[p]-1))/2;
        
        return deduct;
    }
    private static void union(int x, int y)
    {
        int xParent = find(x);
        int yParent = find(y);
        
        if (xParent != yParent)
        {
            parent[yParent] = xParent;
            roots.remove(yParent);
            size[xParent] += size[yParent];
        }
    }
    private static int find(int x)
    {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}