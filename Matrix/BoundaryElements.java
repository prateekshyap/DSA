/*https://practice.geeksforgeeks.org/problems/boundary-elements-of-matrix1102/1*/

class Solution
{
    public int[] BoundaryElements(int[][] matrix)
    {
        // code here
        int[] result;
        if (matrix.length == 1 && matrix[0].length == 1)
        {
            result = new int[1];
            result[0] = matrix[0][0];
            return result;
        }
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (int i = 0; i < matrix[0].length; ++i)
            resultList.add(matrix[0][i]);
        for (int i = 1; i < matrix.length-1; ++i)
        {
            resultList.add(matrix[i][0]);
            resultList.add(matrix[i][matrix[0].length-1]);
        }
        for (int i = 0; i < matrix[0].length; ++i)
            resultList.add(matrix[matrix.length-1][i]);
        result = new int[resultList.size()];
        for (int i = 0; i < result.length; ++i)
            result[i] = (Integer)resultList.get(i);
        return result;
    }
}