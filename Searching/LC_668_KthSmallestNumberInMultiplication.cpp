/*
https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/submissions/
*/
class Solution {
public:
    
    /*
    struct DataM{
        int row, col;
        int prod;
        
        DataM(int r, int c)
        {
            row = r;
            col = c;
            prod = r*c;
        }
    };
    
//     struct comparator{
        
//         bool operator()(const DataM &a, const DataM &b)
//         {
//             return a.prod > b.prod;
//         }
//     };
    
    //TLE
    int findKthNumber_(int m, int n, int k) {
        int ans=-1;
        
        auto comp_lambda = [&](const DataM &a, const DataM &b)
        {
            return a.prod > b.prod;
        };
        
        priority_queue<DataM, vector<DataM>, decltype(comp_lambda)> pq(comp_lambda);
        // priority_queue<DataM, vector<DataM>, comparator> pq;
        
        
        for(int i=1; i<=m; i++)
        {
           pq.push(DataM(i,1));
           // cout<<pq.top().row<<","<<pq.top().col<<") ";
        }
        
        while(k-- > 0)
        {
            DataM c = pq.top(); pq.pop();
            if(c.col<n )
                pq.push(DataM(c.row, c.col+1));
            ans = c.prod;
        }
        
        return ans;
    }
    
    */
    
    int findKthNumber(int m, int n, int k) {
        // int ans=INT_MAX;
        
        int low=1;
        int high = m*n;
        int mid=0, count;
        
        while(low<=high)
        {
            mid = low+(high-low)/2;
            count=0;
            for(int r=1; r<=m; r++)
            {
                count+= min(n, mid/r);
                // int c=n;
                // while(c>=1 && r*c>mid)c--;
                // count+= c;
            }
            
            if(count<k)
                low = mid+1;
            else
                high = mid-1;
                
        }
        
        return low;
    }
};