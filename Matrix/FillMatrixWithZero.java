/*https://leetcode.com/problems/set-matrix-zeroes/*/

class Solution
{
    public void setZeroes(int[][] matrix)
    {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> columns = new HashSet<Integer>();
        
        //add the rows and columns to the sets
        for (int i = 0; i < matrix.length; ++i)
        {
            for (int j = 0; j < matrix[0].length; ++j)
            {
                if (matrix[i][j] == 0)
                {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        
        //if any of them is full
        if (rows.size() == matrix.length || columns.size() == matrix[0].length)
        {
        	//store 0 everywhere in the matrix and return
            for (int i = 0; i < matrix.length; ++i)
                for (int j = 0; j < matrix[0].length; ++j)
                    matrix[i][j] = 0;
            return;
        }
        
        //store 0 in the rows
        for (Integer row : rows)
            for (int i = 0; i < matrix[0].length; ++i)
                matrix[row][i] = 0;
        
        //store 0 in the columns
        for (Integer column : columns)
            for (int i = 0; i < matrix.length; ++i)
                matrix[i][column] = 0;
    }
}

//space efficient solution , courtesy : leetcode
class Solution {
  public void setZeroes(int[][] matrix) {
    Boolean isCol = false;
    int R = matrix.length;
    int C = matrix[0].length;

    for (int i = 0; i < R; i++) {

      // Since first cell for both first row and first column is the same i.e. matrix[0][0]
      // We can use an additional variable for either the first row/column.
      // For this solution we are using an additional variable for the first column
      // and using matrix[0][0] for the first row.
      if (matrix[i][0] == 0) {
        isCol = true;
      }

      for (int j = 1; j < C; j++) {
        // If an element is zero, we set the first element of the corresponding row and column to 0
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    // Iterate over the array once again and using the first row and first column, update the elements.
    for (int i = 1; i < R; i++) {
      for (int j = 1; j < C; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // See if the first row needs to be set to zero as well
    if (matrix[0][0] == 0) {
      for (int j = 0; j < C; j++) {
        matrix[0][j] = 0;
      }
    }

    // See if the first column needs to be set to zero as well
    if (isCol) {
      for (int i = 0; i < R; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}