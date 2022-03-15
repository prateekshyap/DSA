
/*
https://practice.geeksforgeeks.org/problems/find-first-repeated-character4108/1/
Find first repeated character

*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
string firstRepChar(string s);
int main()
 {
    int t;
    cin>>t;
    while(t--)
    {
        string s;
        cin>>s;
        cout<<firstRepChar(s)<<endl;
    }
	return 0;
}// } Driver Code Ends


string firstRepChar(string str)
{
    //code here.
    unordered_set<char> s;
    
    for(char c: str)
    {
        //if element is alerady in set
        if(s.find(c) != s.end())
            return string(1,c);
        else
            s.insert(c);
            
    }
    
    return "-1";
}//end