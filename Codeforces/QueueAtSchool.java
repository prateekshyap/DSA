/*https://codeforces.com/problemset/problem/266/B*/

import java.io.*;
public class QueueAtSchool
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().trim().split(" +");
		int n = Integer.parseInt(tokens[0]);
		int t = Integer.parseInt(tokens[1]);
		String s = br.readLine();
		char[] arr = s.toCharArray();
		boolean flag = false;
		while (t-- > 0)
		{
			flag = false;
			for (int i = n-1; i >= 1; --i)
			{
				if (arr[i] == 'G' && arr[i-1] == 'B')
				{
					flag = true;
					arr[i] = 'B'; arr[i-1] = 'G';
					--i;
				}
			}
			/*for (int k = 0; k < n; ++k)
			System.out.print(arr[k]);
			System.out.println();*/
			if (!flag) break;
		}
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i]);
	}
}