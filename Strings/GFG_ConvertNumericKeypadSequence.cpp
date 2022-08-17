/*
https://practice.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1#
Convert a sentence into its equivalent mobile numeric keypad sequence 
*/

// { Driver Code Starts
// C++ implementation to convert a
// sentence into its equivalent
// mobile numeric keypad sequence
#include <bits/stdc++.h>
using namespace std;
string printSequence(string input);
// Driver function
int main()
{
	int t;
	cin>>t;
	cin.ignore();
	while(t--)
    {
        string s;
        getline(cin,s);
        cout<<printSequence(s)<<endl;
    }
	return 0;
}
// } Driver Code Ends

/*
string printSequence(string S)
{
    array<string,26> codes={
        "2",
        "22",
        "222",
        "3",
        "33",
        "333",
        "4",
        "44",
        "444",
        "5",
        "55",
        "555",
        "6",
        "66",
        "666",
        "7",
        "77",
        "777",
        "7777",
        "8",
        "88",
        "888",
        "9",
        "99",
        "999",
        "9999"
    };
    
    string ans;
    for(char ch: S)
    {
        if(ch!=' ')
            ans += codes[ch-'A'];
        else ans+="0";
    }
    return ans;
}
*/

string printSequence(string S)
{
    unordered_map<char, string> codes;
    codes[' ']="0";
    
    char ch='A';
    for(int i=2; i<=9; i++)
    {
        string s = to_string(i);
        int k = 3;   
        while(k--)
        {
            codes[ch++] = s;
            s += to_string(i);
        }
        if(ch=='S') codes[ch++] = "7777";
        if(ch=='Z') codes[ch] = "9999";
    }
    
    string ans;
    for(char ch: S)
    {
        if(ch!=' ')
            ans += codes[ch];
        else ans+="0";
    }
    return ans;
}