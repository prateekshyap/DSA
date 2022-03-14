/*https://leetcode.com/problems/subsets/*/
/*https://practice.geeksforgeeks.org/problems/subsets-1613027340/1*/

/*Prateekshya*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        recur(nums,0, new ArrayList<Integer>());
        return result;
    }
    public void recur(int[] nums, int index, ArrayList<Integer> currList)
    {
        if (index == nums.length) //if all elements are checked
        {
        	//create a list with the currently chosen elements
            List<Integer> newList = new ArrayList<Integer>();
            for (Integer element : currList)
                newList.add(element);

            //add it to the result and return
            result.add(newList);
            return;
        }

        /*exclude the current element and recur for the next*/
        recur(nums,index+1,currList);

        /*include the current element and recur for the next*/
        currList.add(nums[index]);
		recur(nums,index+1,currList);
        currList.remove(currList.size()-1);
    }
}

class Solution
{
    static ArrayList<ArrayList<Integer>> result;
    static int n;
    
    public static void recur(ArrayList<Integer> currList, int val, ArrayList<Integer> A)
    {
        if (val == n)
        {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for (Integer element : currList)
                newList.add(element);
            result.add(newList);
            return;
        }
        
        recur(currList, val+1, A);
        currList.add(A.get(val));
        recur(currList, val+1, A);
        currList.remove(currList.size()-1);
    }
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //code here
        result = new ArrayList<ArrayList<Integer>>();
        n = A.size();
        recur(new ArrayList<Integer>(), 0, A);
        Collections.sort(result, new Comparator<ArrayList<Integer>>()
        {
            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2)
            {
                int i = 0, j = 0;
                if (list1.size() == 0) return -1;
                if (list2.size() == 0) return 1;
                while ((Integer)list1.get(i) == (Integer)list2.get(j))
                {
                    ++i; ++j;
                    if (i >= list1.size()) return -1;
                    if (j >= list2.size()) return 1;
                }
                return (Integer)list1.get(i)-(Integer)list2.get(j);
            }
        });
        return result;
    }
}