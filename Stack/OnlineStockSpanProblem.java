/*https://leetcode.com/problems/online-stock-span/*/

class StockSpanner {
    int[] prices, spans;
    int capacity;
    int size;
    Stack<Integer> stack;

    public StockSpanner() {
        this.prices = new int[1];
        this.spans = new int[1];
        this.capacity = 1;
        this.size = -1;
        this.stack = new Stack<Integer>();
    }
    
    public int next(int price) {
    	/*amortized doubling of arrays when index exceeds capacity*/
        if (size+1 == capacity)
        {
        	//double prices size
            int[] temp = new int[capacity*2];
            for (int i = 0; i < prices.length; ++i)
                temp[i] = prices[i];
            prices = temp;

            //double spans size
            temp = new int[capacity*2];
            for (int i = 0; i < spans.length; ++i)
                temp[i] = spans[i];
            spans = temp;

            //update the new capacity
            capacity *= 2;
        }

        //add the new price to prices array
        prices[++size] = price;

        //set the default span size for current price
        spans[size] = 1;
        
        //add the values till the stack top price is less or equal to current price
        while (!stack.isEmpty() && prices[stack.peek()] <= prices[size])
            spans[size] += spans[stack.pop()];

        //push the current price and return
        stack.push(size);
        return spans[size];
    }
}