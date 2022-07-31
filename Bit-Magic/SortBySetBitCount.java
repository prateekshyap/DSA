/*https://practice.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1#*/

class Compute  
{ 
    static int countBits(int n)
    {
        int count = 0;
        while (n > 0)
        {
            count += n&1;
            n >>= 1;
        }
        return count;
    }
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        /*Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1)
            {
                // TODO Auto-generated method stub
                int c1 = Integer.bitCount(arg0);
                int c2 = Integer.bitCount(arg1);
                if (c1 < c2)
                    return 1;
                else if (c1 > c2)
                    return -1;
                else return 0;
            }
        });*/
        int i;
        int[][] combined = new int[n][2];
        for (i = 0; i < n; ++i)
        {
            combined[i][0] = arr[i];
            combined[i][1] = countBits(arr[i]);
        }
        //for (i = 0; i < n; ++i) System.out.println(combined[i][0]+" "+combined[i][1]);
        Arrays.sort(combined,new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b)
            {
                return b[1]-a[1];
            }
        });
        for (i = 0; i < n; ++i) arr[i] = combined[i][0];
    } 
}