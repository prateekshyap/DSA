/*
https://binarysearch.com/problems/N-Lexicographic-Integers
N Lexicographic Integers

*/
vector<int> solve(int n) {
    
    vector<string> s;

    for(int i=1; i<=n; i++)
        s.push_back(to_string(i));
    
    sort(s.begin(), s.end());

    vector<int> ans;
    for(auto x: s)
        ans.push_back(stoi(x));

    return ans;
}//end