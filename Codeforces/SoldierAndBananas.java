/*https://codeforces.com/problemset/problem/546/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class SoldierAndBananas
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().trim().split(" +");
		int k = Integer.parseInt(tokens[0]);
		int n = Integer.parseInt(tokens[1]);
		int w = Integer.parseInt(tokens[2]);
		int result = ((w*(w+1)*k)/2)-n;
		System.out.println(result < 0 ? "0" : result);
	}
}