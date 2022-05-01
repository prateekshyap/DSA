/*https://codeforces.com/problemset/problem/1144/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.ArrayList;

public class ParityAlternatedDeletions
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] tokens = reader.readLine().trim().split(" +");
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(tokens[i]);

		Arrays.sort(arr);
		ArrayList<Integer> oddList = new ArrayList<Integer>();
		ArrayList<Integer> evenList = new ArrayList<Integer>();

		for (int i = 0; i < n; ++i)
		{
			if (arr[i]%2 == 0) evenList.add(arr[i]);
			else oddList.add(arr[i]);
		}
		int maxPairDeletions = Math.min(oddList.size(),evenList.size());
		if (maxPairDeletions == evenList.size() && maxPairDeletions == oddList.size()) System.out.println("0");
		else
		{
			int sum = 0;
			if (maxPairDeletions == oddList.size())
				for (int i = 0; i < n-(2*maxPairDeletions)-1; ++i)
					sum += (Integer)evenList.get(i);
			else
				for (int i = 0; i < n-(2*maxPairDeletions)-1; ++i)
					sum += (Integer)oddList.get(i);
			System.out.println(sum);
		}
	}
}