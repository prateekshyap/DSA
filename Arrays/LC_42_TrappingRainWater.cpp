/*
https://leetcode.com/problems/trapping-rain-water/
42. Trapping Rain Water
*/
class Solution {
public:
    int trap1(vector<int>& height) {
        
        int n = height.size();
        int lftMaxHt[n];
        int rgtMaxHt[n];
        
        int max=0;
        int trapCount=0;
        
        for(int i=0; i<n; i++)
        {
            if(max < height[i])
            {
                lftMaxHt[i] = height[i] ;
                max = lftMaxHt[i] ;
            }
            lftMaxHt[i] = max;
            // cout<<lftMaxHt[i]<<" ";
        }
        // cout<<endl;
        
        max=0;
        for(int i=n-1; i>=0; i--)
        {
            if(max < height[i])
            {
                rgtMaxHt[i] = height[i] ;
                max = rgtMaxHt[i] ;
            }
            rgtMaxHt[i] = max;
        }
        
        // for(int i=0; i<n; i++)
        // {
        //     cout<<rgtMaxHt[i]<<" ";
        // }
        //  cout<<endl;
        
        for(int i=0; i<n; i++)
        {
            trapCount += min(lftMaxHt[i], rgtMaxHt[i]) - height[i];
        }
        
        return trapCount;
    }// end
    
     int trap2(vector<int>& height) {
        
        int n = height.size();
        int trapCount=0;
         
        if(n<=2) return trapCount;
        
        vector<int> leftMax(n);
        vector<int> rightMax(n);
         
         leftMax[0] = height[0];
         rightMax[n-1] = height[n-1];
         
         for(int i=1; i<n ; i++)
         {
             leftMax[i] = max(leftMax[i-1], height[i]);
             rightMax[n-1-i] = max(rightMax[n-i], height[n-1-i]);
         }
         
         for(int i=0; i<n; i++)
        {
            trapCount += min(leftMax[i], rightMax[i]) - height[i];
        }
         return trapCount;
    }// end
    
    int trap(vector<int>& height) {
        
        int n = height.size();
        int ans=0;
         
        if(n<=2) return ans;
        
        int l=0, r=n-1;
        int mleft = height[l];
        int mright = height[r];
        
        while(l<r)
        {
            if(mleft < mright)
            {
                l++;
                mleft = max(mleft, height[l]);
                ans+=mleft-height[l];
            }
            else
            {
                r--;
                mright = max(mright, height[r]);
                ans+=mright-height[r];
            }
        }
        
         return ans;
    }// end
};