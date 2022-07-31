/*
https://leetcode.com/problems/count-and-say/
38. Count and Say

*/
class Solution {
public:
    string countAndSay_1(int n) {
        if(n==1)
            return "1";
        string say = countAndSay(n-1);
        // cout<<n<<" "<<say;
        string cnt;
        int len=1;
        for(int i=1; i<say.size(); i++)
        {
            if(say[i] == say[i-1])
                len++;
            else
            {
                cnt+= to_string(len) +say[i-1];
                len=1;
            }
        }
        cnt+= to_string(len) +say[say.size()-1];
        // cout<<" B "<<n<<" "<<cnt<<endl;
        return cnt;
    }
    
    string countAndSay(int n) {
        if(n==1)
            return "1";
        
        string cnt="1";
        for(int i=2; i<=n; i++) //row wise down
        {
            string say="";
            int j=0;
            while(j<cnt.size()) // col wise across, read the string to SAY
            {
                int len=0;
                char ch = cnt[j];
                while(j<cnt.size() && ch == cnt[j]) // same number
                {
                    j++; len++;
                }
                say += to_string(len) + ch;
            }
            cnt = say;
        }
        
        return cnt;
    }
};