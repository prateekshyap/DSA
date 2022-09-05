/*https://leetcode.com/problems/queens-that-can-attack-the-king/*/

class Solution {
    int B = 8;
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        HashSet<Integer>[] rows = new HashSet[B], cols = new HashSet[B];
        for (int i = 0; i < B; ++i)
        {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
        }
        for (int[] queen : queens)
        {
            rows[queen[0]].add(queen[1]);
            cols[queen[1]].add(queen[0]);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        //same row as the king
        for (Integer col : rows[king[0]])
        {
            if (col < max && col > king[1])
                max = col;
            if (col > min && col < king[1])
                min = col;
        }
        if (max != Integer.MAX_VALUE) result.add(Arrays.asList(king[0],max));
        if (min != Integer.MIN_VALUE) result.add(Arrays.asList(king[0],min));
        
        // System.out.println(result);
        
        min = Integer.MIN_VALUE; max = Integer.MAX_VALUE;
        //same column as the king
        for (Integer row : cols[king[1]])
        {
            if (row < max && row > king[0])
                max = row;
            if (row > min && row < king[0])
                min = row;
        }
        if (max != Integer.MAX_VALUE) result.add(Arrays.asList(max,king[1]));
        if (min != Integer.MIN_VALUE) result.add(Arrays.asList(min,king[1]));
        
        // System.out.println(result);
        
        //principal diagonal
        int minIndex = -1, maxIndex = -1;
        min = Integer.MIN_VALUE; max = Integer.MAX_VALUE;
        for (int i = 0; i < king[0]; ++i)
        {
            int temp = king[1]-king[0]+i;
            if (rows[i].contains(temp))
            {
                if (temp > min)
                {
                    min = temp;
                    minIndex = i;
                }
            }
        }
        for (int i = king[0]+1; i < B; ++i)
        {
            int temp = king[1]-king[0]+i;
            if (rows[i].contains(temp))
            {
                if (temp < max)
                {
                    max = temp;
                    maxIndex = i;
                }
            }
        }
        if (max != Integer.MAX_VALUE) result.add(Arrays.asList(maxIndex,max));
        if (min != Integer.MIN_VALUE) result.add(Arrays.asList(minIndex,min));
        
        // System.out.println(result);
        
        //other diagonal
        minIndex = -1; maxIndex = -1;
        min = Integer.MIN_VALUE; max = Integer.MAX_VALUE;
        for (int i = 0; i < king[0]; ++i)
        {
            int temp = king[1]+king[0]-i;
            if (rows[i].contains(temp))
            {
                if (temp < max)
                {
                    max = temp;
                    maxIndex = i;
                }
            }
        }
        for (int i = king[0]+1; i < B; ++i)
        {
            int temp = king[1]+king[0]-i;
            if (rows[i].contains(temp))
            {
                if (temp > min)
                {
                    min = temp;
                    minIndex = i;
                }
            }
        }
        if (max != Integer.MAX_VALUE) result.add(Arrays.asList(maxIndex,max));
        if (min != Integer.MIN_VALUE) result.add(Arrays.asList(minIndex,min));
        
        // System.out.println(result);
        
        return result;
    }
}


class Solution {
    int B = 8;
    private static final int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // create 8-directions.
        // keep a visited boolean array with queens.
        // keep a resultList with queens that can attack the quin.
        List<List<Integer>> queensInAttackPosition = new ArrayList<>();
        boolean[][] visitedQueens = new boolean[8][8];
        
        for (int[] queen : queens) {
            visitedQueens[queen[0]][queen[1]] = true;
        }
        
        // start at kings position.
        // for every possible direction (8).
        for (int[] dir : DIRECTIONS) {
            // go in the same direction until find a queen or hit out of bound.
            int row = king[0] + dir[0];
            int col = king[1] + dir[1];
            
            while (!isOutOfBound(row, col)) {
                // if a queen found in this direction added and stop searching.
                if (visitedQueens[row][col]) {
                    queensInAttackPosition.add(Arrays.asList(row, col));
                    break;
                }
                
                // continue down in the same direction.
                row = row + dir[0];
                col = col + dir[1];
            }
        }
        
        // return the list with the queens.
        return queensInAttackPosition;
    }
    
    // provides whether is this cell is out of bound.
    private boolean isOutOfBound(int row, int col) {
        return row < 0 || row >= B || col < 0 || col >= B;
    }
}


// king can be attacked at most -> 8 sides.
//      4 - directional.
//      4 - diagonal.