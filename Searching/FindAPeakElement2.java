/*https://leetcode.com/problems/find-a-peak-element-ii/*/

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length;
        
        while (low <= high)
        {
            int mid = (low+high)/2;
            int maxVal = Integer.MIN_VALUE;
            int row = 0, col = 0;
            
            for (int j = mid-1; j <= mid+1; ++j)
            {
                if (j < 0 || j >= mat[0].length) continue;
                
                for (int i = 0; i < mat.length; ++i)
                {
                    if (maxVal < mat[i][j])
                    {
                        maxVal = mat[i][j];
                        row = i;
                        col = j;
                    }
                }
            }
            
            if (col == mid) return new int[]{row,col};
            else if (col == mid-1) high = mid-1;
            else low = mid+1;
        }
        
        return new int[]{};
    }
}

class Solution {
    
    public int getPeakIndex(int[] col)
    {
        int maxIndex = -1, maxElement = Integer.MIN_VALUE;
        
        for (int i =0; i < col.length; i++)
        {
            if (maxElement < col[i])
            {
                maxIndex = i;
                maxElement = col[i];
            }
        }
        
        return maxIndex;
    }
    
    public int[] findPeakGrid(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int low = 0, high = r-1;
        
        if (low == high)
            return new int[]{low, getPeakIndex(mat[0])};
        
        while (low <= high)
        {
            int mid = (low+high)/2;
            
            int peakIndex = getPeakIndex(mat[mid]);
            
            if (mid < r-1 && mat[mid][peakIndex] < mat[mid+1][peakIndex])
                low = mid +1;
            else if (mid > 0 && mat[mid][peakIndex] < mat[mid-1][peakIndex])
                high = mid -1;
            else
                return new int[]{mid, peakIndex};
        }
        
        return new int[]{-1,-1};
    }
}