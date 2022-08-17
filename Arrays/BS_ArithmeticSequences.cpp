/*
https://binarysearch.com/problems/Arithmetic-Sequences
Arithmetic Sequences

*/

int solve_1(vector<int>& nums) {
    int n = nums.size();
    if(n<3)
        return 0;
    
    int ans=0;
    int l = 0;
    int h = 1;
    int d=0, len;

    while(h<n)
    {
        d = nums[h]-nums[h-1];
        while(h<n && d == nums[h]-nums[h-1])
            h++;
        --h;
        //cout<<l<<" "<<h<<endl;
        if(h-l+1 >=3)
        {
            len = h-l-1; //4-1(h-1) - 0(l)
            ans+= (len*(len+1))/2;
        }
        // h--;
        l = h;
        h++;
    }
    return ans;
}

int solve(vector<int>& nums) {
        int ans = 0, n = nums.size(), s = 0;

        for (int i = 2; i<n; i++)
        {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) s++;
            else s = 0;

            ans += s;
        }
        return ans;
}