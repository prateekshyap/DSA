/*
https://binarysearch.com/problems/N-Lexicographic-Integers
https://leetcode.com/problems/lexicographical-numbers/
386. Lexicographical Numbers

*/

class Solution {
public:
    vector<int> ans;
    void find(int x, int N)
    {
        if(x > N)
            return;

        ans.push_back(x);

        for(int i=0; i<=9; i++)
            find(x*10 + i, N);
    }
    vector<int> lexicalOrder(int n) {
        
        for(int i=1; i<=min(9,n); i++)
            find(i, n);

        return ans;
    }
};

// vector<int> solve(int n) {
    
//     vector<string> s;

//     for(int i=1; i<=n; i++)
//         s.push_back(to_string(i));
    
//     sort(s.begin(), s.end());

//     vector<int> ans;
//     for(int i=0; i<n; i++)
//         ans.push_back(stoi(s[i]));

//     return ans;
// }//end

void find(int x, int N, vector<int>& ans)
{
    if(x > N)
        return;
    
    ans.push_back(x);

    for(int i=0; i<=9; i++)
        find(x*10 + i, N, ans);
}

vector<int> solve(int n) {
    
    vector<int> ans;

    for(int i=1; i<=9; i++)
        find(i, n, ans);
    
    return ans;
}//end