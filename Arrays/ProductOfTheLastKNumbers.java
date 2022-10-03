/*https://leetcode.com/problems/product-of-the-last-k-numbers/*/

class ProductOfNumbers {
    List<Integer> list;
    int lastProduct;

    public ProductOfNumbers() {
        list = new ArrayList<Integer>();
        lastProduct = 1;
    }
    
    public void add(int num) {
        if (num == 0)
        {
            lastProduct = 1;
            list.clear();
        }
        else
        {
            lastProduct *= num;
            list.add(lastProduct);
        }
    }
    
    public int getProduct(int k) {
        int index = list.size()-k;
        if (index == 0) return lastProduct;
        if (index > 0) return lastProduct/list.get(index-1);
        return 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */