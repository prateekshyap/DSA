/*https://leetcode.com/problems/minimum-money-required-before-transactions/*/


/**
 * Intuition goes as follows-
 * Worst case will be when we lost all our money first i.e. the transactions where cost is greater than the cashback
 * The amount of money that we lost, should be with us from the beginning otherwise we won't be able to perform those transactions
 * So
 * 		money = sum(cost[i]-cashback[i])
 * Now, the point is, we will be still left with the cashback amount after all such transactions are performed.
 * Giving the cost and getting the cashback are individual operations.
 * At any point the money can not go beyond 0
 * That means for the last transaction, when we spent the cost, our money should be 0.
 * And then we got the cashback amount.
 * Which means, initially we had the cashback amount with us.
 * So
 * 		money = sum(cost[i]-cashback[i])+max(cashback[i])
 * Now, for the rest of the transactions, the highest cost should be with us from the beginning.
 * But if the cashback that we got is more than this highest cost then we need not worry.
 * So
 * 		money = sum(cost[i]-cashback[i])+max(max(cashback[i]),max(cost[j]))
 * Here i denotes all transactions where cost[i] > cashback[i]
 * and j denotes all other transactions
*/

class Solution {
    public long minimumMoney(int[][] txs) {
        long netLosingCost = 0;
        int maxCashBack = 0;
        int maxCost = 0;
        for (int[] t : txs) {
            if (t[0] > t[1]) { // losing transactions
                netLosingCost += t[0] - t[1];
                maxCashBack = Math.max(maxCashBack, t[1]);
            } else { // earning transactions
                maxCost = Math.max(maxCost, t[0]);
            }
        }
        return netLosingCost + Math.max(maxCashBack, maxCost);
    }
}