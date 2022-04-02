/*https://codeforces.com/problemset/problem/34/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;

public class Sale
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = reader.readLine().trim().split(" +");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		tokens = reader.readLine().trim().split(" +");
		for (int i = 0; i < n; ++i)
			minHeap.add(Integer.parseInt(tokens[i]));
		int sum = 0, curr = 0;
		for (int i = 0; i < m; ++i)
			if ((curr = minHeap.poll()) <= 0) sum += (Integer)curr;
		else break;
		System.out.println(sum*(-1));
	}
}