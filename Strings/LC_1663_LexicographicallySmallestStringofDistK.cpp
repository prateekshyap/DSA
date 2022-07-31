/*
https://binarysearch.com/problems/Lexicographically-Smallest-String-of-Distance-K
Lexicographically Smallest String of Distance K

https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
1663. Smallest String With A Given Numeric Value

*/

class Solution {
public:
    string getSmallestString_1(int n, int k) {
        string ans(n, 'a');
        int val_sum = n; // all a's
        int val_rem = 1;
        int j = n-1;
        
        while(val_rem)
        {
            val_rem = k - val_sum;
            if(val_rem >= 25)
            {
                ans[j] = 'z';
                val_sum += 25;
                if(val_sum==k)break;
            }
            else
            {
                ans[j] = 'a' + val_rem;
                break;
            }
            j--;
        }
        
        return ans;
    }
    
    string getSmallestString(int n, int k) {
        int z_cnt = floor((k-n)/25); // count of z's
        bool middle = (k-n)%25 == 0; //all z or not, bec we are substracting -1 below
        int a_cnt = (n-z_cnt) - 1 + int(middle);
        
        string as(a_cnt, 'a');
        string zs(z_cnt, 'z');
        
        if((k-n)%25 > 0)
            as.push_back((k-n)%25 + 'a');
        
        return as+zs;
        
    }
    
    string getSmallestString_2(int n, int k) 
    {
        int left = 0;
        int right = 0;
        
        while(k - n >= 26)
        {
            k -= 26;
            n--;
            right++;
        }
        
        while(n > 1)
        {
            n--;
            k -= 1;
            left++;
        }
        
        string leftSide(left, 'a');
        string rightSide(right, 'z');
                
        return leftSide + (char)(k + 96) + rightSide;
    }
};

// Binary Search ----------------------------------------------------------------
string solve_1(int n, int k) {
    string ans;

    int cntz = n/26;
    int new_dist = n-cntz*26;
    while(new_dist < k-cntz)
    {
        cntz--;
        new_dist=n-cntz*26;
    }

    int kc = k;
    while(kc>cntz+1)
    {
        ans+='a';
        kc--;
    }
    if(new_dist)
        ans+= (char)((new_dist-ans.size())+96);

    while(cntz--)
        ans+='z';

    return ans;
}

string solve(int n, int k) {
    string ans(k,'a');
    int val_k = k;
    int val_n = 0;
    int j=k-1;

    while(true)
    {
        val_n = n - val_k;
        if(val_n >= 25) //'a' is already there so for z = 26-1 = 25
        {
            ans[j--] = 'z';
            val_k += 25;
        }
        else
        {
            ans[j--] = 'a'+val_n;
            break;
        }
    }

    return ans;
}
