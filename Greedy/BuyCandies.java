/*https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1*/

class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        ArrayList<Integer> result = new ArrayList<Integer>();

        //find out the number of candies you'll have to buy
        int buy = (int)Math.ceil((double)N/(double)(K+1));

        //sort the candies
        Arrays.sort(candies);

        //find out the minimum sum and maximum sum and return
        int minSum = 0, maxSum = 0;
        for (int i = 0; i < buy; ++i)
            minSum += candies[i];
        for (int i = N-1; i >= N-buy; --i)
            maxSum += candies[i];

        result.add(minSum);
        result.add(maxSum);

        return result;
    }
}