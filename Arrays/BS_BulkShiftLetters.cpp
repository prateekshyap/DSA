/*
https://binarysearch.com/problems/Bulk-Shift-Letters
Bulk Shift Letters

*/

/*
string solve(string s, vector<int>& shifts) {
    
    vector<long> sh(shifts.size());
    sh[shifts.size()-1] = shifts[shifts.size()-1];

    for(int i=shifts.size()-2; i>=0; i--)
        sh[i] = shifts[i]+sh[i+1];

    for(int i=0; i<s.size(); i++)
    {
        long ch = s[i]-'a';
        ch = (ch + sh[i])%26 + 'a';
        s[i] = (char)ch;
    }
    return s;
}
*/

string solve(string s, vector<int>& shifts)
{
    int shiftVal = 0;

    for(int j = s.size()-1; j>=0; j--)
    {
        shiftVal = (shiftVal+shifts[j])%26;
        s[j] = (s[j]-'a' + shiftVal)%26 + 'a';
    }
    return s;

}