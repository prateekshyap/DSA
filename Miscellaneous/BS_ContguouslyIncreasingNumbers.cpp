/*
https://binarysearch.com/problems/Contiguously-Increasing-Numbers
Contiguously Increasing Numbers

*/

vector<int> solve_1(int start, int end) {
    vector<int> ans;
    queue<int> q;
    int d, lastDig;

    for (int i = 1; i <= 9; i++) q.push(i);

    while (!q.empty()) {
        d = q.front();
        q.pop();
        if (d >= start and d <= end) ans.push_back(d);
        if (d < end) {
            lastDig = d % 10;
            if (lastDig != 9) {
                q.push(d * 10 + lastDig + 1);
            }
        }
    }
    return ans;
}

vector<int> solve_2(int start, int end) {
    vector<int> ans;
    queue<int> q;
    int sz, d;

    for (int i = 1; i <= 9; i++) q.push(i);

    while (!q.empty()) {
        sz = q.size();
        while (sz--) {
            d = q.front();
            q.pop();
            if (d >= start and d <= end) ans.push_back(d);
            if (d < end) {
                if (d % 10 != 9) {
                    q.push(d * 10 + d % 10 + 1);
                }
            }
        }
    }
    return ans;
}

vector<int> solve(int start, int end) {
    vector<int> ans;

    for (int d = 1; d <= 9; d++) {
        if (d >= start and d<=end)
            ans.push_back(d);
        int nd = d+1;
        int nnum = d*10 + nd;
        while(nd <=9)
        {
            if (nnum >= start and nnum<=end)
                ans.push_back(nnum);
            nnum = nnum*10 + ++nd;
        }
        
    }
    sort(ans.begin(), ans.end());
    return ans;
}