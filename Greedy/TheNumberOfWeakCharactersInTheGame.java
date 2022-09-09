/*https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/*/

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        // if we sort only by 1st indexes, there could be values where 1st index is the same 
        // Arrays.sort(properties, (a,b) -> Integer.compare(a[0], b[0]));
        
        // b[1], a[1] because we need the 2nd values in descending order
        Arrays.sort(properties, (a,b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        
        int noOfWeakCharacters = 0;
        int len = properties.length;
       // improvization here - // we need to keep track of the max value
        int max = properties[len-1][1];
        
        for(int i = len-2; i>=0 ;i--)
        {   
            System.out.println(i+" "+properties[i][1]+" "+max);
            if(properties[i][1] < max)
                noOfWeakCharacters++;
            else
                max = properties[i][1];
        }
        return noOfWeakCharacters;
    }
}

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int maxAttack = 0;
        // Find the maximum atack value
        for (int[] property : properties) {
            int attack = property[0];
            maxAttack = Math.max(maxAttack, attack);
        }
        
        int maxDefense[] = new int[maxAttack + 2];
        // Store the maximum defense for an attack value
        for (int[] property : properties) {
            int attack = property[0];
            int defense = property[1];
            
            maxDefense[attack] = Math.max(maxDefense[attack], defense);
        }

        // Store the maximum defense for attack greater than or equal to a value
        for (int i = maxAttack - 1; i >= 0; i--) {
            maxDefense[i] = Math.max(maxDefense[i], maxDefense[i + 1]);
        }
        
        int weakCharacters = 0;
        for (int[] property : properties) {
            int attack = property[0];
            int defense = property[1];
            
            // If their is a greater defense for properties with greater attack
            if (defense < maxDefense[attack + 1]) {
                weakCharacters++;
            }
        }
        
        return weakCharacters;
    }
}