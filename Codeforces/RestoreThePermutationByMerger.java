/*https://codeforces.com/problemset/problem/1385/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashSet;

public class RestoreThePermutationByMerger
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		String[] tokens;
		int n, i, j, k, elem;
		int[] arr1, arr2;
		HashSet<Integer> set;

		while (tests-- > 0)
		{
			n = Integer.parseInt(reader.readLine());
			arr1 = new int[n]; arr2 = new int[n];
			i = j = 0;
			set = new HashSet<Integer>();
			tokens = reader.readLine().trim().split(" +");
			for (k = 0; k < 2*n; ++k)
			{
				elem = Integer.parseInt(tokens[k]);
				if (set.contains(elem))
					arr2[j++] = elem;
				else
				{
					arr1[i++] = elem;
					set.add(elem);
				}
			}
			for (i = 0; i < n; ++i)
				System.out.print(arr1[i]+" ");
			System.out.println();
		}
	}
}