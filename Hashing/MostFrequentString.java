/*https://practice.geeksforgeeks.org/problems/most-frequent-word-in-an-array-of-strings3528/1*/

class Solution
{
    public String mostFrequentWord(String arr[],int n)
    {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        HashMap<String,Integer> freq = new HashMap<String,Integer>();
        int maxFreq = 0;
        String word = "";

        //for every string
        for (int i = 0; i < n; ++i)
        {
        	//put the first occurrence in map
            if(!map.containsKey(arr[i])) map.put(arr[i],i);

            //put the frequency in freq
            freq.put(arr[i],(freq.containsKey(arr[i]) ? (Integer)freq.get(arr[i])+1 : 1));

            //if we get a new maximum frequency
            if ((Integer)freq.get(arr[i]) > maxFreq)
            {
            	//update both maxfreq and word
                maxFreq = (Integer)freq.get(arr[i]);
                word = arr[i];
            }

            //if we get the same frequency
            else if ((Integer)freq.get(arr[i]) == maxFreq)
            	//update the word with the later occurrence
                word = arr[Math.max((Integer)map.get(word),(Integer)map.get(arr[i]))];
        }
        
        return word;
    }
}