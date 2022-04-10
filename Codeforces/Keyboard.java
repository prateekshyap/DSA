/*https://codeforces.com/problemset/problem/474/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Keyboard
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char dir = reader.readLine().charAt(0);
		char[] msg = reader.readLine().trim().toCharArray();
		for (int i = 0; i < msg.length; ++i)
		{
			if (dir == 'L')
			{
				if (msg[i] == 'a')
					msg[i] = 's';
				else if (msg[i] == 'b')
					msg[i] = 'n';
				else if (msg[i] == 'c')
					msg[i] = 'v';
				else if (msg[i] == 'd')
					msg[i] = 'f';
				else if (msg[i] == 'e')
					msg[i] = 'r';
				else if (msg[i] == 'f')
					msg[i] = 'g';
				else if (msg[i] == 'g')
					msg[i] = 'h';
				else if (msg[i] == 'h')
					msg[i] = 'j';
				else if (msg[i] == 'i')
					msg[i] = 'o';
				else if (msg[i] == 'j')
					msg[i] = 'k';
				else if (msg[i] == 'k')
					msg[i] = 'l';
				else if (msg[i] == 'l')
					msg[i] = ';';
				else if (msg[i] == 'm')
					msg[i] = ',';
				else if (msg[i] == 'n')
					msg[i] = 'm';
				else if (msg[i] == 'o')
					msg[i] = 'p';
				else if (msg[i] == 'q')
					msg[i] = 'w';
				else if (msg[i] == 'r')
					msg[i] = 't';
				else if (msg[i] == 's')
					msg[i] = 'd';
				else if (msg[i] == 't')
					msg[i] = 'y';
				else if (msg[i] == 'u')
					msg[i] = 'i';
				else if (msg[i] == 'v')
					msg[i] = 'b';
				else if (msg[i] == 'w')
					msg[i] = 'e';
				else if (msg[i] == 'x')
					msg[i] = 'c';
				else if (msg[i] == 'y')
					msg[i] = 'u';
				else if (msg[i] == 'z')
					msg[i] = 'x';
				else if (msg[i] == ',')
					msg[i] = '.';
				else if (msg[i] == '.')
					msg[i] = '/';
				else if (msg[i] == 'o')
					msg[i] = 'p';
			}
			else if (dir == 'R')
			{
				if (msg[i] == ';')
					msg[i] = 'l';
				else if (msg[i] == 'b')
					msg[i] = 'v';
				else if (msg[i] == 'c')
					msg[i] = 'x';
				else if (msg[i] == 'd')
					msg[i] = 's';
				else if (msg[i] == 'e')
					msg[i] = 'w';
				else if (msg[i] == 'f')
					msg[i] = 'd';
				else if (msg[i] == 'g')
					msg[i] = 'f';
				else if (msg[i] == 'h')
					msg[i] = 'g';
				else if (msg[i] == 'i')
					msg[i] = 'u';
				else if (msg[i] == 'j')
					msg[i] = 'h';
				else if (msg[i] == 'k')
					msg[i] = 'j';
				else if (msg[i] == 'l')
					msg[i] = 'k';
				else if (msg[i] == 'm')
					msg[i] = 'n';
				else if (msg[i] == 'n')
					msg[i] = 'b';
				else if (msg[i] == 'o')
					msg[i] = 'i';
				else if (msg[i] == 'p')
					msg[i] = 'o';
				else if (msg[i] == 'r')
					msg[i] = 'e';
				else if (msg[i] == 's')
					msg[i] = 'a';
				else if (msg[i] == 't')
					msg[i] = 'r';
				else if (msg[i] == 'u')
					msg[i] = 'y';
				else if (msg[i] == 'v')
					msg[i] = 'c';
				else if (msg[i] == 'w')
					msg[i] = 'q';
				else if (msg[i] == 'x')
					msg[i] = 'z';
				else if (msg[i] == 'y')
					msg[i] = 't';
				else if (msg[i] == '/')
					msg[i] = '.';
				else if (msg[i] == ',')
					msg[i] = 'm';
				else if (msg[i] == '.')
					msg[i] = ',';
				else if (msg[i] == 'o')
					msg[i] = 'i';
			}
		}
		for (int i = 0; i < msg.length; ++i)
			System.out.print(msg[i]);
		System.out.println();
	}
}