/*https://codeforces.com/problemset/problem/50/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class DominoPiling
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().trim().split(" +");
		int m = Integer.parseInt(tokens[0]);
		int n = Integer.parseInt(tokens[1]);
		System.out.println((m*n)/2);
	}
}