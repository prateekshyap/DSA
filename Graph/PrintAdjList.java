/*https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1*/

class Solution {
    // Function to return the adjacency list for each vertex.
    public ArrayList<ArrayList<Integer>> printGraph(
        int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> newList = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        for (ArrayList<Integer> adjRow : adj)
        {
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            newRow.add(i++);
            for (Integer elem : adjRow)
                newRow.add(elem);
            newList.add(newRow);
        }
        return newList;
    }
}