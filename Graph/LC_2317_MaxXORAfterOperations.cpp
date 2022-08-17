/*
https://leetcode.com/problems/maximum-xor-after-operations/
2317. Maximum XOR After Operations

*/

class Solution {
public:
    /*
    int maximumXOR(vector<int>& nums) {
     
        string value(32,'0');
        for(int x: nums)
        {
            string binary = bitset<32>(x).to_string();
            for(int i=0; i<32; i++)
            {
                // cout<<binary[i];
                if(binary[i]=='1')
                    value[i] = '1';
                
            }
            // cout<<endl;
        }
        // cout<<endl;
        // for(char c: value)
        //     cout<<c;
        long long int val = stoi(value, nullptr, 2);
        return val;
    }
    */
    
    int maximumXOR(vector<int>& nums) {
        int ans =0 ;
        
        for(auto &x: nums)
            ans |= x;
        
        return ans;
    }
    
};