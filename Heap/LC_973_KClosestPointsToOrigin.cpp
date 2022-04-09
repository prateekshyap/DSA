/*
https://leetcode.com/problems/k-closest-points-to-origin/
973. K Closest Points to Origin

*/
class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        auto euclidean = [&](auto &p)
        {
            return p[0]*p[0] + p[1]*p[1];
        };
        
        /*
// Using Sort function, lambda function
        sort(begin(points), end(points), [&](auto& a, auto& b)
             {
                 return euclidean(a) < euclidean(b);
             });
        points.resize(k); // resize number of rows.
        
        // for(auto x: points)
        //     cout<<x[0]<<" "<<x[1]<<" ";
        
        return points;
        */
        /*
//Using Max Heap
        vector<vector<int>> ans(k);
        priority_queue<pair<int,int>> pq;
        
        for(int i=0; i<size(points); i++)
        {
            pq.emplace(euclidean(points[i]), i);
            if(pq.size()>k)pq.pop();
        }
        
        for(int i=0; i<k; i++)
        {
            ans[i] = points[pq.top().second];
            pq.pop();
        }
        
        return ans;
        */
        /*
// Using Randomized select parition
        int l=0;
        int r=points.size()-1;
        while(l<r)
        {
            int pos = partition(points, l, r);
            if(pos == k) break;
            if(pos < k) l = pos+1;
            else r = pos-1;
        }
        points.resize(k);
        return points;
        */
        /*
// Using nth element
        nth_element(points.begin(), points.begin()+k, points.end(), [&](auto& a, auto& b){
            return euclidean(a) < euclidean(b);
        });
            points.resize(k);
        return points;
        */
    }// end
    
    int partition(vector<vector<int>>&P , int low, int high)
    {
        auto euclidean = [&](auto& p) {return p[0]*p[0]+p[1]*p[1];};
        srand(time(0));
        swap(P[low], P[low + rand()%(high-low+1)]);
        int j = low;
        int X = euclidean(P[low]);
        for(int i=low+1; i<=high; i++)
        {
            if(euclidean(P[i]) < X)
            {
                swap(P[i], P[++j]);
            }
            
        }
        swap(P[j], P[low]);
        return j;
    }
};