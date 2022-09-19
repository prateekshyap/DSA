/*https://leetcode.com/problems/check-array-formation-through-concatenation/*/

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,int[]> pieceMap = new HashMap<Integer,int[]>();
        for (int[] piece : pieces)
            pieceMap.put(piece[0],new int[]{piece[piece.length-1],piece.length});
        int[] arrMap = new int[101];
        for (int i = 0; i < arr.length; ++i)
            arrMap[arr[i]] = i;
        int index = 0;
        while (index < arr.length)
        {
            if (!pieceMap.containsKey(arr[index])) return false;
            int[] end = pieceMap.get(arr[index]);
            int endIndex = arrMap[end[0]];
            if (endIndex-index+1 != end[1]) return false;
            index = endIndex+1;
        }
        return true;
    }
}

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[][] pieceMap = new int[101][2];
        for (int i = 0; i <= 100; ++i)
            pieceMap[i][0] = pieceMap[i][1] = -1;
        for (int[] piece : pieces)
        {
            pieceMap[piece[0]][0] = piece[piece.length-1];
            pieceMap[piece[0]][1] = piece.length;
        }
        int[] arrMap = new int[101];
        for (int i = 0; i < arr.length; ++i)
            arrMap[arr[i]] = i;
        int index = 0;
        while (index < arr.length)
        {
            if (pieceMap[arr[index]][0] == -1) return false;
            int[] end = new int[]{pieceMap[arr[index]][0],pieceMap[arr[index]][1]};
            int endIndex = arrMap[end[0]];
            if (endIndex-index+1 != end[1]) return false;
            index = endIndex+1;
        }
        return true;
    }
}