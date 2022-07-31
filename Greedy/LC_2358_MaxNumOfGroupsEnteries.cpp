/*
https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/submissions/
2358. Maximum Number of Groups Entering a Competition
*/
class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        int n = grades.size();
        if(n==1 || n==2) return 1;
        
        /*
        int groups=1;
        sort(grades.begin(), grades.end());
        long int  i=1;
        for(; i<=n; i++)
        {
            long int sum = (i*(i+1))/2;
            if(sum == n)
                return i;
            else if(sum < n)
                groups = i;
        }
        return groups;
        */
        // x^2 + x - 2*n=0;
        // return ((-1 + sqrt(1+8*n))/2);
        
        // (x+0.5)^2 = 2*x + 0.25
        // return sqrt(2*n + 0.25) - 0.5;
        
        int l = 1, h = 446;
        while(l<h)
        {
            
            int m = ceil((l+h)/2.0);
            // cout<<m<<" "<<l<<" "<<h<<endl;
            if(m*(m+1)/2 <= n)
                l=m;
            else
                h=m-1;
        }
        return l;
		
        // int ans = 0; 
        // for (int i = 0, di = 1; i < grades.size(); i+= di) {
        //     ++ans; 
        //     ++di; 
        // }
        // return ans; 
    }
};