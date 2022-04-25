/*https://practice.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1*/

class Solution {
    
    static ArrayList<ArrayList<Integer>> list;
    static Set<ArrayList<Integer>> hashSet;
    public static void recurPerm(int[] nums, int l, int r) {
        //base case
        if (l == r)
        {
        	//add the permutation to the list
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; ++i)
                newList.add(nums[i]);
            hashSet.add(newList);
        }
        else
        {
        	//for every integer in the range
            for (int i = l; i <= r; ++i)
            {
                nums = swap(nums,l,i); //backtracking step-1 - swap
                recurPerm(nums,l+1,r); //backtracking step-2 - recur
                nums = swap(nums,l,i); //backtracking step-3 - backtrack
            }
        }
    }
    public static int[] swap(int[] nums, int l, int i) {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
        return nums;
    }
    
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = (Integer)arr.get(i);
            
        list = new ArrayList<ArrayList<Integer>>();
        hashSet = new HashSet<ArrayList<Integer>>();
        
        //recursion call
        recurPerm(nums,0,nums.length-1);
        
        //add from set to list
        for (ArrayList<Integer> l : hashSet)
            list.add(l);
            
        Collections.sort(list,new Comparator<ArrayList<Integer>>()
        {
            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2)
            {
                int i = 0;
                while ((Integer)list1.get(i) == (Integer)list2.get(i)) //run till equality
                    ++i;
                if (i == list1.size()) return 0; //if all elements scanned, return 0
                if ((Integer)list1.get(i) < (Integer)list2.get(i)) return -1; //if the next element is smaller, return 1st list
                return 1; //otherwise return 2nd list
            }
        });
        
        return list;
    }
};