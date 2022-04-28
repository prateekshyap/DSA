/*https://www.hackerrank.com/challenges/crush/*/

class Result {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here
		int i;
		long max;
		long[] arr = new long[n+1];
		for (List<Integer> query : queries)
		{
			arr[(Integer)query.get(0)-1] += (Integer)query.get(2);
			arr[(Integer)query.get(1)] += (-1)*(Integer)query.get(2);
		}
		max = arr[0];
		for (i = 0; i < n-1; ++i)
		{
			arr[i+1] += arr[i];
			if (max < arr[i+1]) max = arr[i+1];
		}
		return max;
    }

}