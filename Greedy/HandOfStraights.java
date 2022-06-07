/*https://leetcode.com/problems/hand-of-straights/*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length%groupSize != 0) return false;
        Arrays.sort(hand); //sor the array
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
        int i;

        //add everything to hashmap
        for (i = 0; i < hand.length; ++i)
            map.put(hand[i], map.containsKey(hand[i]) ? (Integer)map.get(hand[i])+1 : 1);
        boolean result = true; //set result to true
        int count = 0; //set count to 0
        Iterator it = map.entrySet().iterator(); //start a new iterator over the map
        while (count < hand.length) //till count is incomplete
        {
            it = map.entrySet().iterator(); //restart the iterator
            if (it.hasNext()) //call hasNext
            {
                Map.Entry firstElem = (Map.Entry)it.next(); //get the first element
                if ((Integer)firstElem.getValue() > 0) //if the element still exists
                {
                    ++count; //increment count
                    map.put((Integer)firstElem.getKey(),(Integer)firstElem.getValue()-1); //reduce frequency
                    for (i = 1; i < groupSize; ++i) //for rest of the elements of the group
                    {
                        if (!map.containsKey((Integer)firstElem.getKey()+i) || ((Integer)map.get((Integer)firstElem.getKey()+i) == 0)) //if the next element does not exist
                        {
                            result = false; //mark result as false
                            break; //break from loop
                        }
                        else //if the element exist
                        {
                            ++count; //increment count
                            map.put((Integer)firstElem.getKey()+i,(Integer)map.get((Integer)firstElem.getKey()+i)-1); //reduce frequency
                        }
                    }
                }
                else //if the element does not exist
                    map.remove((Integer)firstElem.getKey()); //remove from map
            }
            if (!result) break; //if result has become false, break out of the loop
        }
        return result; //return result
    }
}