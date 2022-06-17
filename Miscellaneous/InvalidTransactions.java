/*https://leetcode.com/problems/invalid-transactions/*/

class Transaction implements Comparable<Transaction>
{
    int time, amount, index;
    String city;
    Transaction(String t, String a, String c, int i)
    {
        time = Integer.parseInt(t);
        amount = Integer.parseInt(a);
        city = c;
        index = i;
    }
    
    @Override
    public int compareTo(Transaction t)
    {
        return this.time-t.time;
    }
}

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        HashMap<String,ArrayList<Transaction>> map = new HashMap<String,ArrayList<Transaction>>();
        int i, n = transactions.length;
        String[] transaction;
        String t;
        boolean[] hash = new boolean[n];
        List<String> list = new ArrayList<String>();
        for (i = 0; i < n; ++i)
        {
            t = transactions[i];
            transaction = t.split("[,]");
            if (Integer.parseInt(transaction[2]) > 1000) hash[i] = true;
            if (map.containsKey(transaction[0]))
                for (Transaction curr : map.get(transaction[0]))
                    if (Math.abs(Integer.parseInt(transaction[1])-curr.time) <= 60 && !transaction[3].equals(curr.city))
                        hash[i] = hash[curr.index] = true;
            if (!map.containsKey(transaction[0]))
                map.put(transaction[0],new ArrayList<Transaction>());
            map.get(transaction[0]).add(new Transaction(transaction[1],transaction[2],transaction[3],i));
        }
        for (i = 0; i < n; ++i) if (hash[i]) list.add(transactions[i]);
        return list;
    }
}