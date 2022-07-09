/*https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1*/

class Pair implements Comparable<Pair>
{
    int i, j;
    Pair(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
    @Override
    public int compareTo(Pair p)
    {
        return 0;
    }
    
    @Override
    public String toString()
    {
        return "("+this.i+this.j+")";
    }
}
class Solution {
    static Integer[][] costs, parts;
    static String matrixChainOrder(int arr[], int N){
        // code here
        costs = new Integer[N-1][N-1];
        parts = new Integer[N-1][N-1];
        // for (int i = 0; i < N-1; ++i)
        //     Arrays.fill(parts[i],-1);
        costs[0][N-2] = solve(arr,0,N-2);
        int i, j;

        /*
        * recursive printing
        * function defined below
        */
        /*String order = printOrder(0,N-2);
        System.out.println(order);*/

        /*
        * Without recursion
        */
        StringBuffer order = new StringBuffer("");
        Pair[] stack = new Pair[2*N];
        StringBuffer[][] orders = new StringBuffer[N-1][N-1];
        int stackIndex = 0, top = -1;
        for (i = 0; i < N-1; ++i)
            orders[i][i] = new StringBuffer(Character.toString((char)(i+'A')));
        stack[++top] = new Pair(0,N-2);
        Pair p;
        while (stackIndex <= top)
        {
            p = stack[stackIndex++];
            if (p.j-p.i > 1)
            {
                stack[++top] = new Pair(p.i, parts[p.i][p.j]);
                stack[++top] = new Pair(parts[p.i][p.j]+1, p.j);
            }
        }
        
        while (top >= 0)
        {
            p = stack[top--];
            if (p.i == p.j) continue;
            StringBuffer temp = new StringBuffer("");
            temp.append("(");
            temp.append(orders[p.i][parts[p.i][p.j]]);
            temp.append(orders[parts[p.i][p.j]+1][p.j]);
            temp.append(")");
            orders[p.i][p.j] = temp;
        }
        
        // System.out.println(orders[0][N-2]);
        // return costs[0][N-2];
        return orders[0][N-2].toString();
    }
    
    static String printOrder(int i, int j)
    {
        StringBuffer buffer = new StringBuffer("");
        if (i == j)
        {
            buffer.append((char)(i+'A'));
            return buffer.toString();
        }
        
        buffer.append("(");
        buffer.append(printOrder(i,parts[i][j]));
        buffer.append(printOrder(parts[i][j]+1,j));
        buffer.append(")");
        return buffer.toString();
    }
    static int solve(int[] arr, int i, int j)
    {
        if (i == j) return 0;
        if (costs[i][j] != null) return costs[i][j];
        int result = Integer.MAX_VALUE, k, minK = -1, curr;
        for (k = i; k < j; ++k)
        {
            curr = solve(arr,i,k)+solve(arr,k+1,j)+(arr[i]*arr[k+1]*arr[j+1]);
            if (curr < result)
            {
                result = curr;
                minK = k;
            }
        }
        costs[i][j] = result;
        parts[i][j] = minK;
        return result;
    }
}