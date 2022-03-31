/*
 * https://codeforces.com/problemset/problem/1370/A
 * A. Maximum GCD
*/

#include<iostream>
#include <algorithm>

using namespace std;

int gcd(int a, int b)
{	
	if(a==0) return b; 
	if(b==0) return a;

	return gcd(b, a%b);
}

int main()
{
	int t=0; // number of test cases
    int n=0; //single integer 
	int m=0;

	// cout<<"Enter t: ";
	cin>>t;
	// cout<<"\nt: "<<t;

	while(t--)
	{
		// cout<<"\nEnter n: ";
		cin>>n;
		// cout<<"\nn: "<<n;

		if(n==1) return 1;

		if(n%2) // odd number
		{
          n=n-1;
          
		}
		m = gcd(n,n/2);
		// cout<<"\nMax gcd: "<<m;
		cout<<m<<"\n";

	}

	cin.get();
	cin.get();
	return 0;
}