/*https://codeforces.com/problemset/problem/115/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;

public class Party
{
	static int maxLevel = 0;
	static boolean[] visited;
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		visited = new boolean[n+1];
		int[] e = new int[n];
		for (int i = 0; i < n; ++i)
			e[i] = Integer.parseInt(reader.readLine());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; ++i)
			graph.add(new ArrayList<Integer>());
		for (int i = 0; i < n; ++i)
		{
			if (e[i] == -1)
				graph.get(0).add(i+1);
			else
				graph.get(e[i]).add(i+1);
		}
		visited[0] = true;
		recur(graph,0,0);
		//System.out.println(graph);
		System.out.println(maxLevel);
	}
	public static void recur(ArrayList<ArrayList<Integer>> graph, int node, int level)
	{
		ArrayList<Integer> adjNodes = graph.get(node);
		boolean leafNode = true;
		for (Integer adjNode : adjNodes)
		{
			if (!visited[adjNode])
			{
				leafNode = false;
				visited[adjNode] = true;
				recur(graph,adjNode,level+1);
			}
		}
		if (leafNode)
			maxLevel = Math.max(level, maxLevel);
	}
}