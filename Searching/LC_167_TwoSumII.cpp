/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
167. Two Sum II - Input Array Is Sorted
*/

class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int n = numbers.size();
        int l=0;
        int r=n-1;
        while(l<r){
            
            if(numbers[l]+numbers[r] == target)
                return {l+1,r+1};
            else if(numbers[l]+numbers[r]<target)
                l++;
            else
                r--;
        }
        
//         unordered_map<int,int> um;
//         vector<int> result;
        
//         for(int i=0; i<n; i++){
//             int rem_sum = target - numbers[i];
//             if(um.find(rem_sum) != um.end())
//             {    
//                 result.push_back(i+1);
//                 result.push_back(um[rem_sum]+1);
//                 sort(result.begin(), result.end());
//                 return result;
//             }
//             um.insert({numbers[i],i});
                
//         }
    
        
        return {-1};
    }
};