/*https://leetcode.com/problems/reveal-cards-in-increasing-order/*/

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck.length <= 2) return deck;
        Arrays.sort(deck);
        int N = deck.length;
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        resultList.add(deck[N-2]);
        resultList.add(deck[N-1]);
        // System.out.println(resultList);
        for (int i = N-3; i >= 0; --i)
        {
            int move = resultList.get(resultList.size()-1);
            resultList.remove(resultList.size()-1);
            resultList.add(0,move);
            resultList.add(0,deck[i]);
            // System.out.println(resultList);
        }
        int[] resultArr = convert(resultList);
        return resultArr;
    }
    private int[] convert(ArrayList<Integer> list)
    {
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i)
            arr[i] = (Integer)list.get(i);
        return arr;
    }
}

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck.length <= 2) return deck;
        Arrays.sort(deck);
        int N = deck.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.addLast(deck[N-2]);
        deque.addLast(deck[N-1]);
        for (int i = N-3; i >= 0; --i)
        {
            int move = deque.pollLast();
            deque.addFirst(move);
            deque.addFirst(deck[i]);
        }
        int[] resultArr = convert(deque);
        return resultArr;
    }
    private int[] convert(Deque<Integer> list)
    {
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i)
            arr[i] = (Integer)list.pollFirst();
        return arr;
    }
}

