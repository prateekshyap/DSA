/*https://leetcode.com/problems/shortest-impossible-sequence-of-rolls/*/

class Pair implements Comparable<Pair>
{
    int a, b;
    Pair(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public int compareTo(Pair p)
    {
        return 0;
    }
    
    @Override
    public String toString()
    {
        return "("+this.a+","+this.b+")";
    }
}

class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Map<Integer,TreeSet<Integer>> map = new HashMap<Integer,TreeSet<Integer>>();
        int n = rolls.length, i;

        //store all the list of indices for all rolls
        for (i = 0; i < n; ++i)
        {
            if (!map.containsKey(rolls[i]))
                map.put(rolls[i],new TreeSet<Integer>());
            map.get(rolls[i]).add(i);
        }
        int len = 0, curr, prev, currIn, prevIn;

        //for length 1
        if (!map.containsKey(1)) return 1;
        prevIn = map.get(1).first();
        prev = 1;
        for (i = 2; i <= k; ++i) //get the farthest first roll
        {
            if (!map.containsKey(i)) return 1;
            if (map.get(i).first() > prevIn)
            {
                prevIn = map.get(i).first();
                prev = i;
            }
        }
        len = 2;
        for (int loop = 1; loop <= n; ++loop) //for next iterations
        {
            currIn = -1;
            curr = -1;
            for (i = 1; i <= k; ++i) //for all rolls find the farthest first roll
            {
                Integer nextIn = map.get(i).higher(prevIn);
                if (nextIn == null) return len; //if couldn't find, return the result
                if (nextIn > currIn)
                {
                    currIn = nextIn;
                    curr = i;
                }
            }
            prevIn = currIn;
            prev = curr;
            ++len; //increment length
        }
        
        return len+1; //program won't come here
    }
}

//optimized solution
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int n = rolls.length;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) //for each roll given
        {
            set.add(rolls[i]); //add to set
            if (set.size() == k) //when set size is complete
            {
                set.clear(); //remove everything
                res++; //increment length by 1
            }
        }
        return res+1; //return the next length
    }
}