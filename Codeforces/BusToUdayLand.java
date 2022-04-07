/*https://codeforces.com/problemset/problem/711/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BusToUdayLand
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int rows = Integer.parseInt(reader.readLine());
		int j = 0;
		char[][] seats = new char[rows][5];
		for (int i = 0; i < rows; ++i)
			seats[i] = reader.readLine().toCharArray();
		int i1 = -1, i2 = -1, j1 = -1, j2 = -1;
		for (int i = 0; i < rows; ++i)
		{
			if (seats[i][0] == 'O' && seats[i][1] == 'O')
			{
				i1 = i; j1 = 0;
				i2 = i; j2 = 1;
				break;
			}
			else if (seats[i][3] == 'O' && seats[i][4] == 'O')
			{
				i1 = i; j1 = 3;
				i2 = i; j2 = 4;
				break;
			}
		}
		if (i1 != -1)
		{
			System.out.println("YES");
			for (int i = 0; i < rows; ++i)
			{
				for (j = 0; j < 5; ++j)
				{
					if (i == i1 && j == j1)
						System.out.print('+');
					else if (i == i2 && j == j2)
						System.out.print('+');
					else
						System.out.print(seats[i][j]);
				}
				System.out.println();
			}
		}
		else System.out.println("NO");
	}
}