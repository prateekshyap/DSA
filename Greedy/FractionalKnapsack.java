/*https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1*/

class ItemExtended extends Item implements Comparable<ItemExtended> {
    double profitPerWeight;
    ItemExtended(int x, int y, double z) {
        super(x,y);
        this.profitPerWeight = z;
    }
    
    public int getValue() { return super.value; }
    public int getWeight() { return super.weight; }
    
    @Override
    public String toString() { return ""; }
    
    @Override
    public int compareTo(ItemExtended i) {
        if (this.profitPerWeight < i.profitPerWeight) return 1;
        if (this.profitPerWeight > i.profitPerWeight) return -1;
        return 0;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        double profit = 0;

        //rebuild the item array along with the profit per weight
        ItemExtended[] items = new ItemExtended[arr.length];
        for (int i = 0; i < arr.length; ++i)
        {
            double profitPerWeight = (double)arr[i].value/(double)arr[i].weight;
            items[i] = new ItemExtended(arr[i].value,arr[i].weight,profitPerWeight);
        }

        //add everything to the minheap
        PriorityQueue<ItemExtended> pq = new PriorityQueue<ItemExtended>();
        for (int i = 0; i < items.length; ++i)
            pq.add(items[i]);

        //for each item in the minheap
        ItemExtended item = null;
        for (int i = 0; i < items.length; ++i)
        {
        	//till more items can be added
            if (W > 0) {
            	//remove the root
                item = pq.poll();

                //if it fits fully, add it
                if (item.getWeight() <= W)
                {
                    W -= item.getWeight();
                    profit += item.getValue();
                }

                //otehrwise add a part of it
                else
                {
                    profit += W*item.profitPerWeight;
                    W = 0;
                }
            }

            //otherwise break
            else break;
        }
        
        return profit;
    }
}