/*https://leetcode.com/problems/split-array-into-fibonacci-sequence/*/

class Solution {
    List<Integer> list;
    public List<Integer> splitIntoFibonacci(String num) {
        list = new ArrayList<Integer>();
        solve(num,0,-1,-1,new ArrayList<Integer>());
        return list;
    }
    private boolean solve(String num, int index, int prev, int secondPrev, List<Integer> currList)
    {
        if (index == num.length())
        {
            if (currList.size() >= 3)
            {
                list = new ArrayList<Integer>(currList);
                return true;
            }
            else return false;
        }
        int curr = 0;
        for (int i = index; i < num.length(); ++i)
        {
            if (i == index+1 && num.charAt(index) == '0') break;
            if (prev == -1 || secondPrev == -1)
            {
                if (i >= index+10) break;
            }
            curr = curr*10+num.charAt(i)-'0';
            if (prev == -1 || secondPrev == -1 || (curr == prev+secondPrev && curr >= 0))
            {
                currList.add(curr);
                if (solve(num,i+1,curr,prev,currList)) return true;
                currList.remove(currList.size()-1);
            }
        }
        return false;
    }
}