/*https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1*/
/*https://leetcode.com/problems/combination-sum/*/

class Solution
{
    //static int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541};
    static ArrayList<ArrayList<Integer>> result;
    static void countAndAdd(ArrayList<Integer> list, int target, int sum, int lastAdded, ArrayList<Integer> curr)
    {
        if (sum > target) return;
        if (sum == target)
        {
        	//copy the current elements to another list
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < curr.size(); ++i)
                temp.add((Integer)curr.get(i));

            //add it to result
            result.add(temp);
            return;
        }
        //start from the index which was added last, to avoid duplicate combinations
        for (int i = lastAdded; i < list.size(); ++i)
        {
        	//if the element can contribute in the sum
            if (target-list.get(i) >= 0)
            {
                curr.add((Integer)list.get(i)); //backtracking step - 1
                countAndAdd(list,target,sum+(Integer)list.get(i),i,curr); //backtracking step - 2
                curr.remove(curr.size()-1); //backtracking step - 3
            }
        }
    }
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        result = new ArrayList<ArrayList<Integer>>();

        //remove all duplicates and sort the given list
        Set<Integer> set = new HashSet<>(A);
        A.clear();
        A.addAll(set);
        Collections.sort(A);

        //recursion call
        countAndAdd(A,B,0,0,new ArrayList<Integer>());
        
        return result;
    }
}

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        generateCombinations(candidates,target,0,0,new ArrayList<Integer>());
        return result;
    }
    private void generateCombinations(int[] candidates, int target, int index, int sum, List<Integer> curr)
    {
        if (sum == target)
        {
            List<Integer> newCombination = new ArrayList<>(curr);
            result.add(newCombination);
            return;
        }
        for (int i = index; i < candidates.length; ++i)
        {
            if (sum+candidates[i] <= target)
            {
                curr.add(candidates[i]);
                generateCombinations(candidates,target,i,sum+candidates[i],curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}