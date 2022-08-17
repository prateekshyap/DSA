/*
https://binarysearch.com/problems/Compressed-Vector-Product
Compressed Vector Product

*/

int solve(vector<int>& a, vector<int>& b) {
    
    int i = 0, j = 0;
    int ans =0 ;

    while(i<a.size())
    {
        if(a[i] == b[j])
        {
            ans += a[i]*a[i+1]*b[j+1];
            i = i+2;
            j = j+2;
        }
        else if(a[i] > b[j])
        {
            ans += b[j]*a[i+1]*b[j+1];
            a[i] -= b[j];
            j = j+2;
        }
        else if(a[i] < b[j])
        {
            ans += a[i]*a[i+1]*b[j+1];
            b[j] -= a[i];
            i = i+2;
        }
    }
    return ans;
}