/*https://leetcode.com/problems/minimum-number-of-frogs-croaking/*/

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        HashMap<String,Integer> croakProgressTracker = new HashMap<String,Integer>();
        HashMap<Character,Integer> indices = new HashMap<Character,Integer>();
        String[] incompleteCroaks = new String[]{"","c","cr","cro","croa","croak"};
        // int result = n/5;
        indices.put('c',0);
        indices.put('r',1);
        indices.put('o',2);
        indices.put('a',3);
        indices.put('k',4);
        int n = croakOfFrogs.length();
        if (n%5 != 0) return -1;
        croakProgressTracker.put("",n/5);
        croakProgressTracker.put("c",0);
        croakProgressTracker.put("cr",0);
        croakProgressTracker.put("cro",0);
        croakProgressTracker.put("croa",0);
        croakProgressTracker.put("croak",0);
        int index;
        for (char ch : croakOfFrogs.toCharArray())
        {
            index = (Integer)indices.get(ch);
            if (index == 0) croakProgressTracker.put("croak",croakProgressTracker.get("croak") > 0 ? (Integer)croakProgressTracker.get("croak")-1 : 0);
            if (croakProgressTracker.get(incompleteCroaks[index]) == 0) return -1;
            croakProgressTracker.put(incompleteCroaks[index],croakProgressTracker.get(incompleteCroaks[index])-1);
            croakProgressTracker.put(incompleteCroaks[index+1],croakProgressTracker.get(incompleteCroaks[index+1])+1);
        }
        return croakProgressTracker.get("croak");
    }
}

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] croakProgressTracker = new int[6];
        int[] indices = new int[26];
        String[] incompleteCroaks = new String[]{"","c","cr","cro","croa","croak"};
        Arrays.fill(indices,-1);
        indices['c'-'a'] = 0;
        indices['r'-'a'] = 1;
        indices['o'-'a'] = 2;
        indices['a'-'a'] = 3;
        indices['k'-'a'] = 4;
        
        int n = croakOfFrogs.length();
        if (n%5 != 0) return -1;
        croakProgressTracker[0] = n/5;
        int index;
        for (char ch : croakOfFrogs.toCharArray())
        {
            index = indices[ch-'a'];
            if (index == 0) croakProgressTracker[5] = croakProgressTracker[5] > 0 ? croakProgressTracker[5]-1 : 0;
            if (croakProgressTracker[index] == 0) return -1;
            --croakProgressTracker[index];
            ++croakProgressTracker[index+1];
        }
        return croakProgressTracker[5];
    }
}