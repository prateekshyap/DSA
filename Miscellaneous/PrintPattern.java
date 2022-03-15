/*https://practice.geeksforgeeks.org/problems/print-pattern3549/1*/

class Solution
{
    static List<Integer> list;
    static List<Integer> pattern(int N){
        // code here
        list = new ArrayList<Integer>();
        list.add(N); //add the first number
        recur(N,N,1); //call recurrence
        return list;
    }
    static void recur(int n, int N, int dir)
    {
        int lastAdded = (Integer)list.get(list.size()-1); //get the last added number
        if (dir == 0) lastAdded += 5; //if direction is 0, add 5
        else lastAdded -= 5; //otherwise subtract 5
        list.add(lastAdded); //add the number
        if (lastAdded <= 0) dir = 0; //change direction if the number gets less than or equal to 0
        if (lastAdded == N) return; //if last added number is N then return
        recur(lastAdded, N, dir); //call recursion
    }
}