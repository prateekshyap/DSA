/*https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1*/

class Hanoi {
    int count;
    Hanoi () {
        count = 0;
    }
    public long toh(int N, int from, int to, int aux) {
        // Your code here
        if (N == 1)
        {
            System.out.println("move disk 1 from rod "+from+" to rod "+to);
            return ++count;
        }
        toh(N-1,from,aux,to);
        System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
        ++count;
        toh(N-1,aux,to,from);
        return count;
    }
}