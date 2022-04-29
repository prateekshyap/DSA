/*https://www.hackerrank.com/challenges/ctci-ransom-note/*/

class Result {

    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
		HashMap<String,Integer> set = new HashMap<String,Integer>();
		for (String word : magazine)
		set.put(word,  set.containsKey(word) ? (Integer)set.get(word)+1 :  1);

		boolean result = true;

		for (String word: note)
		{
	        if (!set.containsKey(word))
	        {
		        result = false;
		        break;
	        }
	        else if((Integer)set.get(word) == 0)
	        {
				result = false;
				break;
			}
			else
			{
				set.put(word,(Integer)set.get(word)-1);
			}
		}
		System.out.println(result ? "Yes" : "No");
    }

}

