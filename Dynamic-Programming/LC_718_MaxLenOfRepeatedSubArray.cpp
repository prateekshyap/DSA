/*
718. Maximum Length of Repeated Subarray

https://leetcode.com/problems/maximum-length-of-repeated-subarray/
*/

class Solution {
public:
    int n1,n2;
    typedef unsigned long long  ll;
    
    const int MOD = 1e9+7;
    const int BASE = 107; 
    vector<ll> powers, hash1, hash2;
    
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        n1 = nums1.size(); n2 = nums2.size();
        //return solveByLCS(nums1, nums2); //LC substring
        //return solveByString(nums1, nums2);
        //return solveByHash1(nums1, nums2); 
         return solveByHash2(nums1, nums2);
       
    }//end
    
    int solveByHash2(vector<int>& nums1, vector<int>& nums2)
    {
        int l=0, r=min(n1, n2);
        powers = {1};
        for(int i=0; i<max(n1, n2); i++)
            powers.push_back(powers.back() * BASE%MOD); // computes power of base.
        // hash1.assign(n1+1, 0);
        // for(int i=0; i<n1; i++)
        //     hash1[i+1] = hash1[i]*BASE + nums1[i];
        // hash2.assign(n2+1, 0);
        // for(int i=0; i<n2; i++)
        //     hash2[i+1] = hash2[i]*BASE + nums2[i];
        // for(int i=0; i<powers.size(); i++)  cout<<powers[i]<<" "; cout<<endl;
        while(l<=r)
        {
            int mid = (l+r)/2;
            // cout<<"->"<<l<<"L "<<r<<"R "<<mid<<"M "<<endl;
            if(checkByHash1(nums1, nums2, mid))
                l = mid+1; // try to expand size
            else
                r = mid-1; // try to shrink size
        }
        return l-1;
    }
    
    ll getHash(int left, int right, const vector<ll>& hash)
    {
        return hash[right+1] - hash[left]*powers[right-left+1];
    }
    
    bool checkByHash2(vector<int>& nums1, vector<int>& nums2, int& len)
    {
       unordered_map<ll, vector<int>> seen;
        for(int i=0; i<=n1-len; i++)
        {
            ll h = getHash(i, i+len-1, hash1);
           seen[h].push_back(i);
        }
        
        for(int i=0; i<=n2-len; i++)
        {
            ll h = getHash(i, i+len-1, hash2);
           if (!seen.count(h)) continue;
            for (int j : seen[h]) // Double check - This rarely happens when collision occurs -> No change in time complexity
                if (equal(nums1.begin()+j, nums1.begin()+j+len, nums2.begin()+i, nums2.begin()+i+len))
                    return true;
        }
        return false;
    }
    
    bool checkByHash1(vector<int>& nums1, vector<int>& nums2, int& len)
    {
        unordered_set<ll> firstHash = roolingHash(nums1, len);
        unordered_set<ll> secHash = roolingHash(nums2, len);
        // for(auto s: firstHash) cout<<s<<" "; cout<<endl;
        // for(auto s: secHash) cout<<s<<" "; cout<<endl;
        for(const ll& curHash: secHash)
        {
            if(firstHash.count(curHash)) return true;
        }
        return false;
    }
    
    unordered_set<ll> roolingHash(vector<int>& nums, int& len)
    {
        int n = nums.size();
        ll hash=0;
        unordered_set<ll> ans;
        
        for(int i=0; i<len; i++)
            hash = (hash + (nums[i]*powers[len-i])%MOD)%MOD;
        ans.insert(hash);
        
        for(int i=len; i<n; i++)
        {
            hash = (hash + MOD - (nums[i-len]*powers[len])%MOD) %MOD; //remove prev char
            hash = (hash * BASE)%MOD; // shift one base left
            hash = (hash + (nums[i]*BASE)%MOD)%MOD; // add cur char;
            ans.insert(hash);
        }
        
        return ans;
    }
    
    
    /*
    int solveByHash1(vector<int>& nums1, vector<int>& nums2)
    {
        int l=0, mid;
        int r = min(n1, n2);
        
        while(l+1<r)
        {
            mid = l + (r-l)/2;
            if(isGood(nums1, nums2, mid))
            {
                l = mid;
            }
            else r = mid;
        }
        if(isGood(nums1, nums2, r)) return r;
        if(isGood(nums1, nums2, l)) return l;
        return 0;
    }
    bool isGood(vector<int>& nums1, vector<int>& nums2, int len) { 
        // if(n1<len || n2<len) return false;
        auto a = findHash(nums1, len);
        auto b = findHash(nums2, len);
        for(auto &c : a)
        {
            if(b.count(c.first)) return true;
        }
        return false;
    } 
    ll base = 683303;
    ll mod = 1e9+1;
    
    unordered_map<ll, ll> findHash(vector<int> nums, int len)
    {
        ll p = 1;
        ll hash = 0;
        for(int i=len-1; i>=0; i--){
            hash += ((p%mod)*(nums[i]%mod))%mod;
            hash %=mod;
            if(i!=0)
                p = ((p%mod)*(base%mod))%mod;
        }
        unordered_map<ll,ll> mp;
        mp[hash]++;
        int l=0, r=len, n = nums.size();
        while(r<n){
            hash = (hash+mod - ((p%mod)*(nums[l]%mod))%mod)%mod;
            hash = ((hash%mod) * (base%mod))%mod;
            hash += nums[r];
            hash %= mod;
            l++; r++;
            mp[hash]++;
        }
        return mp;
    }
    */
    /*
    string stringify(vector<int> &nums)
    {
        string out;
        for(int &x: nums) out+=x+'0';
        return out;
    }
    
    int solveByString(vector<int>& nums1, vector<int>& nums2) {
        n1 = nums1.size(); n2 = nums2.size();
        string strA = stringify(nums1), strB = stringify(nums2);
        int l=0, r=min(n1, n2)+1;
        while(l<r)
        {
            int mid = (l+r)/2;
            // cout<<"->"<<l<<"L "<<r<<"R "<<mid<<"M "<<endl;
            if(checkBySet(strA, strB, mid))
                l = mid+1;
            else
                r = mid;
        }
        return r-1;
    }//end
    
    bool checkBySet(string& a, string &b, int len)
    {
        unordered_set<string> st; 
        for(int i=0; i<=n1-len; i++)
            st.insert(a.substr(i, len));
        // for(string s: st) cout<<s<<" "; cout<<endl;
        for(int i=0; i<=n2-len; i++){
            if(st.count(b.substr(i, len))) return true;
        } 
        return false;
    }
    */
    /*
    int solveByLCS(vector<int>& nums1, vector<int>& nums2) {
        n1 = nums1.size(); n2 = nums2.size(); 
        vector<vector<int>> dp(n1+1, vector<int>(n2+1, 0));
        int ans=0; 
        for(int i = 1; i<=n1; i++)
        {
           for(int j = 1; j<=n2; j++)
            {
                if(nums1[i-1] == nums2[j-1])
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = max(ans, dp[i][j]); 
                }
            } 
        } 
        return ans;
    }//end
    */
};