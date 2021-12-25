/*https://codeforces.com/problemset/problem/617/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Elephant
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		System.out.println(((int)x/5)+(x%5 == 0 ? 0 : 1));
	}
}