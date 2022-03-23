/*https://practice.geeksforgeeks.org/problems/rearrange-characters4649/1*/

class Frequency
{
    int ch, freq;
    Frequency(int ch, int freq)
    {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution
{
	public static String rearrangeCharacters(String str) {
		//code here
		int[] hash = new int[26];

		//find out the frequency of each character
		for (int i = 0; i < str.length(); ++i)
		    ++hash[str.charAt(i)-'a'];
		
		//if for any character, frequency is more than the half of the string length, then arrangement is not possible
		for (int i = 0; i < 26; ++i) if (hash[i] > (str.length()+1)/2) return "-1";

	    StringBuffer result = new StringBuffer("");
	    Frequency[] freqs = new Frequency[26];
	    for (int i = 0; i < 26; ++i)
	        freqs[i] = new Frequency(i,hash[i]);
        
        //sort all the frequencies in non-increasing order
        Arrays.sort(freqs,new Comparator<Frequency>()
        {
            public int compare(Frequency f1, Frequency f2)
            {
                return f2.freq-f1.freq;
            }
        });

        //till all the characters are appended
        while (result.length() != str.length())
        {
            int i = 0;
            int currFreq = freqs[0].freq; //store the highest frequency
            while (i < 26 && freqs[i].freq == currFreq) //for all the characters whose frequency is equal to the highest frequency
            {
                result.append((char)(freqs[i].ch+'a')); //append to result
                --freqs[i].freq; //decrease the frequency of that character
                ++i; //increment i
            }
            if (i == 1) //if only one character got appended
            {
                result.append((char)(freqs[i].ch+'a')); //append the next character to avoid consecutive repititions
                --freqs[i].freq; //decrease the frequency
                ++i; //increment i
                //sort the array again
                Arrays.sort(freqs,new Comparator<Frequency>()
                {
                    public int compare(Frequency f1, Frequency f2)
                    {
                        return f2.freq-f1.freq;
                    }
                });
            }
        }
		return result.toString();
	}
}