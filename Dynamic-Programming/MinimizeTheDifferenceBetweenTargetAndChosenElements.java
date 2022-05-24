/*https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/*/

class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        if(mat.length == 0){
            return target;
        }
        
        HashSet<Integer> currentSet = new HashSet<>();
        HashSet<Integer> tempSet;
        
        for(int i = 0; i < mat[0].length; i++){
            currentSet.add(mat[0][i]);
        }
        
        int currentMaxForTarget;
        for(int r = 1; r < mat.length; r++){
            tempSet =  new HashSet<>();
            currentMaxForTarget = Integer.MAX_VALUE;
            for(int c = 0; c < mat[0].length; c++){
                for(int a : currentSet){
                    int t = mat[r][c] + a;
                    if(currentMaxForTarget >= target && t >= target && t < currentMaxForTarget){
                        currentMaxForTarget = t;
                    }
					//If t is bigger than currentMaxForTarget which is bigger than target, do not add it to set.
                    if(t <= currentMaxForTarget){
                        tempSet.add(t);
                    }
                    
                }
            }
            
            currentSet = tempSet;
        }
        
		//find minimum difference
        int min = Integer.MAX_VALUE;    
        for(int i : currentSet){
            min = Math.min(min, Math.abs(target - i));
        }
        
        return min;
        /*if (mat.length == 1)
        {
            int min = Integer.MAX_VALUE;
            for (int elem : mat[0])
                if (Math.abs(target-elem) < min)
                    min = Math.abs(target-elem);
            return min;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i, j, m = mat.length, n = mat[0].length;
        for (j = 0; j < n; ++j)
            set.add(target-mat[0][j]);
        int currMaxTarget, t;
        for (i = 1; i < m-1; ++i)
        {
            list = new ArrayList<Integer>(set);
            set = new HashSet<Integer>();
            currMaxTarget = Integer.MAX_VALUE;
            for (Integer elem : list)
            {
                for (j = 0; j < n; ++j)
                {
                    t = elem-mat[i][j];
                    if (currMaxTarget >= target && t >= target && t < currMaxTarget) currMaxTarget = t;
					//If t is bigger than currentMaxForTarget which is bigger than target, do not add it to set.
                    if(t <= currMaxTarget){
                        set.add(elem-mat[i][j]);
                    }
                }
            }
        }
        list = new ArrayList<Integer>(set);
        set = new HashSet<Integer>();
        for (j = 0; j < n; ++j)
            set.add(mat[m-1][j]);
        //System.out.println(list);
        //System.out.println(set);
        for (Integer elem : list) if (set.contains(elem)) return 0;
        int min = Integer.MAX_VALUE;
        for (Integer elem : list)
            for (Integer elem2 : set)
                if (Math.abs(elem-elem2) < min)
                    min = Math.abs(elem-elem2);
        return min;*/
    }
}

//efficient solution
class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int n = mat[0].length, m = mat.length;
        boolean[][] seen = new boolean[m][m * 70 + 1];
        dfs(0, mat, 0, seen); // DFS to mark all possible sums
        for (int i = 0; true; i++){ // BFS to find the answer.
            for (int j = 0, sign = 1; j < 2; j++, sign *= -1){
                int k = target - i * sign;
                if (k >= 0 && k <= m * 70 && seen[m - 1][k])
                    return i;
            }
        }
    }

    private void dfs(int i, int[][] mat, int sum, boolean[][] seen){
        if (i == mat.length)
            return;

        for (int j = 0; j < mat[i].length; j++){
            if (!seen[i][sum + mat[i][j]]){
                seen[i][sum + mat[i][j]] = true;
                dfs(i + 1, mat, sum + mat[i][j], seen);
            }
        }
    }
}