/*https://codeforces.com/problemset/problem/129/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DistanceAndAxis
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] tokens = reader.readLine().trim().split(" +");
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(tokens[i]);
		int oddCount = 0, evenCount = 0;
		for (int i = 0; i < n; ++i)
			if (arr[i]%2 == 0) ++evenCount; else ++oddCount;
		if (oddCount%2 == 0) System.out.println(evenCount);
		else System.out.println(oddCount);
	}
}