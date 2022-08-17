/*
https://binarysearch.com/problems/Longest-1s-After-One-Flip
Longest 1s After One Flip

*/

int solve(string s) {
    int n = s.length();

    int i=0;
    int j=0;
    int ans=0;
    int cntz=0;

    while(j<s.size())
    {
        if(s[j] == '0')
            cntz++;
        
        while(i<j and cntz>=2)
        {
            if(s[i] == '0') cntz--;
            i++;
        }

        ans = max(ans, j-i+1);

        j++;
          
    }

    return ans;
}

int solve_1(string s) {
    int ans = 0;
    int ones = 0;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '1') {
            ans = max(ans, ++ones);
        } else {
            int curr = ones + 1;
            for (int j = i + 1; j < s.size(); j++) {
                if (s[j] == '1') {
                    curr++;
                } else {
                    break;
                }
            }
            ans = max(ans, curr);
            ones = 0;
        }
    }
    return ans;
}

int solve_2(string a) {
    int n = a.size();
    a = "0" + a + "0";

    vector<int> l(n + 2, 0), r(n + 2, 0);
    for (int i = 1; i <= n; i++)
        if (a[i] == '1')
            l[i] = l[i - 1] + 1;
        else
            l[i] = 0;
    for (int i = n; i >= 1; i--)
        if (a[i] == '1')
            r[i] = r[i + 1] + 1;
        else
            r[i] = 0;

    int ans = l[n];
    for (int i = 1; i <= n; i++) ans = max(ans, l[i - 1] + r[i + 1] + 1);
    return ans;
}