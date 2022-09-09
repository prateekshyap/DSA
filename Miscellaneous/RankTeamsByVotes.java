/*https://leetcode.com/problems/rank-teams-by-votes/*/

class Solution {
    public String rankTeams(String[] votes) {
        if (votes.length == 1) return votes[0];
        int team = 0, teamsCount = 0;
        HashMap<Character,Integer> charToInt = new HashMap<Character,Integer>();
        HashMap<Integer,Character> intToChar = new HashMap<Integer,Character>();
        for (char ch : votes[0].toCharArray())
        {
            charToInt.put(ch,team);
            intToChar.put(team,ch);
            ++team;
        }
        teamsCount = team;
        int[][] ranks = new int[teamsCount][teamsCount+1];
        for (char ch : votes[0].toCharArray())
            ranks[charToInt.get(ch)][teamsCount] = charToInt.get(ch);
        for (String vote : votes)
            for (int pos = 0; pos < teamsCount; ++pos)
                ++ranks[charToInt.get(vote.charAt(pos))][pos];
        
        Arrays.sort(ranks,new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                return compareLists(a,b,0);
            }
            private int compareLists(int[] a, int[] b, int index)
            {
                if (index >= a.length-1 && index >= b.length-1)
                {
                    char ch1 = intToChar.get(a[a.length-1]);
                    char ch2 = intToChar.get(b[b.length-1]);
                    if (ch1 < ch2) return 1;
                    else return -1;
                }
                if (a[index] < b[index]) return -1;
                else if (a[index] > b[index]) return 1;
                else return compareLists(a,b,index+1);
            }
        });
        
        
        // for (int r = 0; r < teamsCount; ++r)
        // {
        //     for (int c = 0; c <= teamsCount; ++c)
        //     {
        //         System.out.print(ranks[r][c]+" ");
        //     }
        //     System.out.println();
        // }
        
        StringBuilder result = new StringBuilder("");
        for (int r = teamsCount-1; r >= 0; --r)
            result.append(intToChar.get(ranks[r][teamsCount]));
        return result.toString();
    }
}