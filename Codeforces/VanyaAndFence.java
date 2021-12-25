/*https://codeforces.com/problemset/problem/677/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class VanyaAndFence
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().trim().split(" +");
		int n = Integer.parseInt(tokens[0]);
		int fence = Integer.parseInt(tokens[1]);
		tokens = br.readLine().trim().split(" +");
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(tokens[i]);
		long result = 0;
		for (int i = 0; i < n; ++i)
			result += arr[i] > fence ? 2 : 1;
		System.out.println(result);
	}
}