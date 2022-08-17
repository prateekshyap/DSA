/*
https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1
https://leetcode.com/problems/restore-ip-addresses/
*/

class Solution {
public:
    string s;
    vector<string> ans;
    vector<string> restoreIpAddresses(string s) {
        int n = s.length();
        if(n>12 or n<4) return ans;
        this->s = s;
        // 7 to 15
        // solve2(0, s, "");
        solve(0, 0, "");
        return ans;
    }//end
    
    void solve(int start, int dots, string out)
    {
        int n = s.size();
        // completed the string and also the dots
        if(start == n and dots ==4)
        {
            out.pop_back(); // remove the extra dots
            ans.push_back(out);
            return;
        }
        //either missed
        if(start == n || dots == 4) return;
        
        int len = min(n, start+3);
        for(int i=start; i<len; i++)
        {
            if(isSafe(start, i, dots))
            {
                solve(i+1, dots+1, out + s.substr(start, i-start+1)+".");
            }
        }
        
    }
    
    bool isSafe(int start, int end, int dots)
    {
        int ns = s.size();
        if(start<ns and end<ns and dots<4){
            string temp = s.substr(start, end-start+1);
            int nt = temp.size();
            if(nt < 4)
            {
                if(nt == 1) return true;
                if(nt == 2 and temp[0] != '0')
                    return true;
                if(nt == 3 and temp[0] != '0' and stoi(temp)<256)
                    return true; 
            }
            // if(temp.size()<4 and stoi(temp)<256)
            //     return true;
        }
        return false;
    }
    
    void solve2(int dot, string s, string out)
    {
        int ns = s.size();
        if(dot == 3)
        {
            if(ns>0 and ns<4) // last part check
            {
                if(ns==1 || s[0] != '0' and stoi(s)<256){
                    out+=s;
                    ans.push_back(out);
                }
            }
            return;
        }
        
        if(ns>=1)
            solve2(dot+1, s.substr(1), out+s.substr(0,1)+".");
        if(ns>=2 and s[0] != '0')
            solve2(dot+1, s.substr(2), out+s.substr(0,2) + ".");
        if(ns>=3 and s[0] != '0' and stoi(s.substr(0,3))<256)
            solve2(dot+1, s.substr(3), out+s.substr(0,3) + ".");
    }
};

// "25525511135"
// "0000"
// "1"
// "19216811"
// "1921681312"
// "0011255245"
// "012201"
// "1921681222340"
// "1921681222341"
// "1921681222342"
// "192168122234"
// "1010"
// "12301"
// "12345678910"
// "908754823"
// "4259860802"
// "42376327960"
// "378587959312"
// "192168177256"
// "256127127127"
// "12467890890"
// "192168127111"