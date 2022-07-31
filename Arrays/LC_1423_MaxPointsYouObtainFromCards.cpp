/*
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
1423. Maximum Points You Can Obtain from Cards

*/

class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int n = cardPoints.size();
        int sum = accumulate(cardPoints.begin(), cardPoints.begin()+k, 0);
        if(n==k)
            return sum;
        
        int maxPoints=sum; //all leftside k points or all rightside k points
        int i=k-1;
        int j=n-1;
        
        while(i>=0)
        {
            sum = sum - cardPoints[i] + cardPoints[j];
            maxPoints = max(maxPoints, sum);
            i--;
            j--;
        }
        
        return maxPoints;
    }
    
    /*
    int maxScore(vector<int>& cardPoints, int k) {
        int n= cardPoints.size();
        if(n==k)
            return accumulate(cardPoints.begin(), cardPoints.end(), 0);
        
        vector<int> ls(n,0), rs(n,0);
        partial_sum(cardPoints.begin(), cardPoints.end(), ls.begin());
        partial_sum(cardPoints.rbegin(), cardPoints.rend(), rs.rbegin());
        // cout<<endl;
        // for(int x: ls)
        //     cout<<x<<" ";
        // cout<<endl;
        // for(int x: rs)
        //     cout<<x<<" ";
        
        int i=k-2;
        int j=n-1;
        int maxPoints= max(ls[k-1], rs[n-k]); //all leftside k points or all rightside k points
        
        while(i>=0)
        {
            maxPoints = max(maxPoints, ls[i]+rs[j]);
            i--;
            j--;
        }
        
        return maxPoints;
    }
    */
};