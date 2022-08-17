/*
823. Binary Trees With Factors

https://leetcode.com/problems/binary-trees-with-factors/
*/

class Solution {
public:
    const int mod = 1e9+7;
    int numFactoredBinaryTrees_1(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        
        int sum=0;
        unordered_map<int,long long> hash;
        // for(int x: arr)
        //     hash[x]=1;
        
        for(int i=0; i<n; i++)
        {
             hash[arr[i]]=1;
            // for(int j=i-1; j>=0; j--)
            for(int j=0; j<i; j++)
            {   
                int child1 = arr[j];
                if(arr[i]%child1==0)
                {
                    int child2 = arr[i]/child1;
                    if(hash.count(child2))
                        hash[arr[i]] += hash[child1]*hash[child2];
                    hash[arr[i]] %= mod;
                }
            }
            sum += hash[arr[i]];
            sum %= mod;
        }
        
        // for(int i=0; i<n; i++)
        //     sum = (sum + hash[arr[i]])%mod;
        return sum;
    }//end
    
    int numFactoredBinaryTrees_2(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        
        int sum=0;
        unordered_map<int,long long> hash;
        // for(int x: arr)
        //     hash[x]=1;
        
        for(int i=0; i<n; i++)
        {
            long ways =1;
            int l = 0;
            int r = i-1;
            while(l<=r)
            {   
                long child1 = arr[l];
                long child2 = arr[r];
                long prod = child1*child2;
                if(prod < arr[i])
                    l++;
                else if(prod > arr[i])
                    r--;
                else
                {
                    if(l == r)
                        ways += (hash[child1] * hash[child2])%mod;
                    else
                        ways += (2*hash[child1] * hash[child2])%mod; 
                    ways %=mod;
                    l++;
                    r--;
                } 
            }
            hash[arr[i]] = ways;
            sum += ways;
            sum %= mod;
        } 
        return sum;
    }//end
    
    int numFactoredBinaryTrees(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        
        int sum=0;
        unordered_map<int,long long> hash; 
        
        for(int i=0; i<n; i++)
        {
             long ways =1;
            for(int j=0; arr[j]<=sqrt(arr[i]); j++)
            {   
                int child1 = arr[j]; 
                int child2 = arr[i]/child1;
                if(arr[i]%child1==0 and hash.count(child2))
                { 
                   if(child1 != child2) 
                        ways += (2*hash[child1] * hash[child2])%mod;
                    else
                        ways += (hash[child1] * hash[child2])%mod; 
                    ways %= mod;
                }
            }
            hash[arr[i]] = ways;
            sum += ways;
            sum %= mod;
        }
        
        // for(int i=0; i<n; i++)
        //     sum = (sum + hash[arr[i]])%mod;
        return sum;
    }//end
    
};