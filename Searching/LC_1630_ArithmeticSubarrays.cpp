/*
https://leetcode.com/problems/arithmetic-subarrays/
1630. Arithmetic Subarrays

*/


class Solution {
public:
    vector<bool> checkArithmeticSubarrays__(vector<int>& nums, vector<int>& l, vector<int>& r) {
        int n = nums.size();
        int m = l.size();
        
        vector<bool> ans(m, true);
            
        for(int q=0; q<m; q++)
        {
            // if(r[q]-l[q]+1 <=2) continue; // if subarray size is <=2, it is arithmetic sequence
            vector<int> t(nums.begin()+l[q], nums.begin()+r[q]+1);
            sort(t.begin(), t.end());
            
            int d = t[1]-t[0];
            for(int i=2; i<t.size(); i++)
            {
                if(d != t[i]-t[i-1])
                {
                    ans[q] = false;
                    break;
                }
            }
        }
            
        return ans;
    }
/*
    Time: O(m * n * log n), where m is the number of queries. 148 ms runtime in OJ.
Memory: O(n) to make a copy of an array.
Approach 2: Count Patterns
This is a bit more complicated, but helps avoid sorting the array. For each subarray, we determine the min and max elements. This will allow us to determine the pattern: pat = (max - min) / (len - 1). Then, for the arithmetic sequence, (nums[j] - min_e) / pat will be the position of that number in the sequence. So, we can go through our subarray again, and check that all positions are filled. We can use a boolean array to do so; if we try to fill a position that has been already filled, we can terminate - the subarray does not form the sequence.

*/
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        int n = nums.size();
        int m = l.size();
        
        vector<bool> ans(m, true);
            
        for(int q=0; q<m; q++)
        {
            auto [t_min, t_max] = minmax_element(nums.begin()+l[q], nums.begin()+r[q]+1);
            int len = r[q]-l[q]+1;
            
            if(*t_max == *t_min)
                continue; //ans[q] = true;
            
            if((*t_max-*t_min)%(len-1))
            {
                 ans[q] = false;
                 continue;
            }   
            
            int d = (*t_max-*t_min)/(len-1), temp; 
            
            vector<bool> vis(len, false);
            
            for(int i=l[q]; i<=r[q]; i++)
            {
                 temp = nums[i]-*t_min; //sub min ele from every element
                
                if(temp%d ) // if temp is not divisible by diff means arithmetic sequence absent
                { 
                    ans[q] = false; break;
                }
                temp/=d;
                if( temp>= len|| vis[temp] ) 
                    { 
                    ans[q] = false; break;
                }
                 vis[temp] = true;
            }
        }
            
        return ans;
    }
};