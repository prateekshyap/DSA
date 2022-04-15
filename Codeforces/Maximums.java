/*https://codeforces.com/problemset/problem/1326/B*/

/*
b[0] = a[0]-x[0]
	 = a[0]-0
	 = a[0]

b[1] = a[1]-x[1]
	 = a[1]-max(0,a[0])
	 = a[1]-0 or a[1]-a[0]
=> a[1] = b[1] or b[1]+a[0]

b[2] = a[2]-x[2]
	 = a[2]-max(0,x[1],a[1])
	 = a[2]-0 or a[2]-x[1] or a[2]-a[1]
=> a[2] = b[2] or b[2]+x[1] or b[2]+a[1]

b[3] = a[3]-x[3]
	 = a[3]-max(0,x[2],a[2])
	 = a[3]-0 or a[3]-x[2] or a[3]-a[2]
=> a[3] = b[3] or b[3]+x[2] or b[3]+a[2]
.
.
.

x[0] = 0
x[1] = max(0,a[0])
x[2] = max(0,x[1],a[1])
x[3] = max(0,x[2],a[2])
.
.
.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Maximums
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] tokens = reader.readLine().trim().split(" +");
		int[] b = new int[n], x = new int[n], a = new int[n];
		int i;
		for(i = 0; i < n; ++i) b[i] = Integer.parseInt(tokens[i]);
		a[0] = b[0]; x[0] = 0;
		a[1] = Math.max(b[1],b[1]+a[0]); x[1] = Math.max(0,a[0]);
		for (i = 2; i < n; ++i)
		{
			a[i] = Math.max(b[i],Math.max(b[i]+x[i-1],b[i]+a[i-1]));
			x[i] = Math.max(0,Math.max(x[i-1],a[i-1]));
		}
		for (i = 0; i < n; ++i)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}