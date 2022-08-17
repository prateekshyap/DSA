/*
https://binarysearch.com/problems/XOR-Range-Queries
XOR Range Queries
*/

vector<int> solve(vector<int>& nums, vector<vector<int>>& queries) {
    if(nums.size()==0 ) return {};
    vector<int> ans(queries.size());
    vector<int> prefix(nums.size(), 0);

    prefix[0] = nums[0];
    for(int i=1; i<nums.size(); i++)
        prefix[i] = prefix[i-1]^nums[i];
    
    for(auto q=0; q<queries.size(); q++){
        int l = queries[q][0];
        int r = queries[q][1];
        if(l==0)
            ans[q]=prefix[r];
        else
            ans[q]=(prefix[r] ^ prefix[l-1]);

        // ans[q]=(prefix[r] ^ (l?prefix[l-1]:0));
    }
    return ans;
}//end

// vector<int> solve(vector<int>& nums, vector<vector<int>>& queries) {
//     int n = nums.size();
//     vector<int> ans(queries.size(),0);

//     for(int i=1; i<n; i++)
//         nums[i]=nums[i-1]^nums[i];

//     for(int i=0; i<queries.size(); i++){
//         int a = queries[i][0];
//         int b = queries[i][1];

//         if(a==0) ans[i] = nums[b];
//         else{
//             ans[i] = nums[b]^nums[a-1];
//         }
//     }
//     return ans;
// }