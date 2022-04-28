/*https://www.hackerrank.com/challenges/new-year-chaos/*/

class Result {

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
        int i, j, count = 0;
        for (i = 0; i < q.size(); ++i)
        {
            if ((Integer)q.get(i)-(i+1) > 2)
            {
                System.out.println("Too chaotic");
                return;
            }
            for (j = Math.max(0,(Integer)q.get(i)-2); j < i; j++)
                if ((Integer)q.get(j) > (Integer)q.get(i)) ++count;
        }
        System.out.println(count);
    }
}