/*https://leetcode.com/problems/design-a-number-container-system/*/

class NumberContainers {
    Map<Integer,TreeSet<Integer>> container;
    Map<Integer,Integer> band;
    public NumberContainers() {
        container = new HashMap<Integer,TreeSet<Integer>>();
        band = new HashMap<Integer,Integer>();
    }
    
    public void change(int index, int number) {
        if (!container.containsKey(number))
            container.put(number,new TreeSet<Integer>());
        container.get(number).add(index);
        if (!band.containsKey(index)) band.put(index,number);
        else if (band.get(index) != number)
        {
            container.get((Integer)band.get(index)).remove(index);
            band.put(index,number);
        }
    }
    
    public int find(int number) {
        return container.containsKey(number) && container.get(number).size() != 0 ? container.get(number).first() : -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */