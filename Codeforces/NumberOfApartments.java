/*https://codeforces.com/problemset/problem/1430/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NumberOfApartments
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int n, nCopy, div, three, five, seven;
		while (tests-- > 0)
		{
			three = five = seven = 0;
			n = Integer.parseInt(reader.readLine());
			div = 0;
	        if(n % 7 == 0){
	            seven += n/7;
	            n -= (seven * 7);
	        }
	        if(n % 5 == 0){
	            five += n/5;
	            n -= (five * 5);
	        }
	        if(n % 3 == 0){
	            three += n/3;
	            n -= (three * 3);
	        }
	        if( n % 7 == 5){
	            seven += (n / 7);
	            five++;
	            n -= (seven * 7) + 5;
	        }
	        if( n % 7 == 3){
	            seven += (n / 7);
	            three++;
	            n -= (seven * 7) + 3;
	        }
	        if( n % 5 == 2){
	            div = n/5;
	            if(div >= 2){
	                five += (n / 5);
	                five--;
	                seven++;
	                n -= (five * 5) + 7;
	            }

	        }
	        if( n % 5 == 3){
	            five += (n / 5);
	            three++;
	            n -= (five * 5) + 3;
	        }
	        if(n % 3 == 1){
	            div = n/3;
	            if(div >= 3){
	                three += (n / 3);
	                three -= 2;
	                seven++;
	                n -= (three * 3) + 7;
	            }
	        }
	        if(n % 3 == 2){
	            div = n/3;
	            if(div >= 2){
	                three += (n/3);
	                three--;
	                five++;
	                n-= (three * 3) + 5;
	            }
	        }

	        if(n == 0){
	            System.out.println(three+" "+five+" "+seven);
	        }
	        else{
	            System.out.println("-1");
	        }

			/*nCopy = n;
			if ((n-((n/5)*5))%2 == 0)
			{
				nCopy = n;
				five = nCopy/5;
				nCopy -= (nCopy/5)*5;
				seven = nCopy/2;
				five -= (nCopy/2);
				if (three < 0 || five < 0 || seven < 0)
				{
					if (n%3 == 0)
						System.out.println(n/3+" 0 0");
					else if (n%7 == 0)
						System.out.println("0 0 "+n/7);
					else
						System.out.println("-1");
				}
				else
					System.out.println(three+" "+five+" "+seven);
			}
			else
				System.out.println("-1");*/
		}
	}
}