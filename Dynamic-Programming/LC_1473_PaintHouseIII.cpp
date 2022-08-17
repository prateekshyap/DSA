/*
https://leetcode.com/problems/paint-house-iii/
1473. Paint House III

*/

class Solution {
public:
    
    vector<int> housesMat;
    vector<vector<int>> costMat;
    int numHouses;
    int numColors;
    int target;
    
    vector<vector<vector<int>>> memo;
    
    
    int minCost(vector<int>& houses, vector<vector<int>>& cost, int m, int n, int target) {
        this->housesMat = move(houses);
        this->costMat = move(cost);
        numHouses = m;
        numColors = n;
        this->target = target;
        
        memo.resize(numHouses+1, vector<vector<int>>(numColors+1, vector<int>(target+1, -1)));
        
        memo[0][0][0] = solve(0, 0, 0);
        return memo[0][0][0] == 1e7 ? -1 : memo[0][0][0];
    }
    
    // id of cur house, color of the prev house, neighbourhood count
    int solve(int idx, int prevcolor, int nghcnt)
    {
        if(nghcnt > target) 
            return 1e7;
        
        if(idx == numHouses) // all houses covered
        {
             if(nghcnt == target)   // target reached and houses covered
                return memo[idx][prevcolor][nghcnt]=0;
             else
                return 1e7; // target not reached
        }
            
        
        if(memo[idx][prevcolor][nghcnt] != -1)
            return memo[idx][prevcolor][nghcnt];
        
        int cst = 1e7;
        int curColor = housesMat[idx];
        
        if(curColor != 0) // house is already painted
        {
            if(prevcolor == curColor)
                cst = solve(idx+1, curColor, nghcnt);
            else
                cst = solve(idx+1, curColor, nghcnt+1);
        }
        else // house is not painted
        {
            for(int col=1; col<= numColors; col++)
            {
                if(prevcolor == col)
                    cst = min(cst, solve(idx+1, col, nghcnt) + costMat[idx][col-1]);
                else
                    cst = min(cst, solve(idx+1, col, nghcnt+1) + costMat[idx][col-1]);
            }
            
        }
        
        return memo[idx][prevcolor][nghcnt]=cst;
    }
    
    /*
    int minCost(vector<int>& houses, vector<vector<int>>& cost, int m, int n, int target) {
        this->housesMat = move(houses);
        this->costMat = move(cost);
        numHouses = m;
        numColors = n;
        this->target = target;
        
        memo.resize(numHouses+1, vector<vector<int>>(numColors+1, vector<int>(target+1, -1)));
        
        memo[0][0][0] = solve(0, 0, 0);
        return memo[0][0][0] == 1e7 ? -1 : memo[0][0][0];
    }
    
    int solve(int idx, int prevcolor, int nghcnt)
    {
        if(nghcnt > target || idx > numHouses) 
            return 1e7;
        if(nghcnt == target and idx == numHouses)   // target reached and houses covered
            return memo[idx][prevcolor][nghcnt]=0;
        if(idx == numHouses)                        // target not reached  but houses covered
            return memo[idx][prevcolor][nghcnt]=1e7;
        
        if(memo[idx][prevcolor][nghcnt] != -1)
            return memo[idx][prevcolor][nghcnt];
        
        int cst = 1e7;
        int curColor = housesMat[idx];
        if(curColor != 0) // house is already painted
        {
            if(prevcolor!=0 and prevcolor == curColor)
                cst = min(cst, solve(idx+1, curColor, nghcnt));
            else
                cst = min(cst, solve(idx+1, curColor, nghcnt+1));
        }
        else
        {
            for(int col=1; col<= numColors; col++)
            {
                if(prevcolor!=0 and prevcolor == col)
                    cst = min(cst, solve(idx+1, col, nghcnt) + costMat[idx][col-1]);
                else
                    cst = min(cst, solve(idx+1, col, nghcnt+1) + costMat[idx][col-1]);
            }
            
        }
        return memo[idx][prevcolor][nghcnt]=cst;
    }
    */
};