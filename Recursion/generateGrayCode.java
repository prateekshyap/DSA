/*https://leetcode.com/problems/gray-code/*/

class Solution {
    String[] arr;
    public List<Integer> grayCode(int n) {
        arr = new String[(int)Math.pow(2,n)];
        for (int i = 0; i < n; ++i)
            arr[i] = "";
        List<Integer> list = new ArrayList<Integer>();
        addGrayCodes(n,0,1);
        for (int i = 0; i < arr.length; ++i)
            list.add(Integer.parseInt(arr[i],2));
        return list;
    }
    public void addGrayCodes(int n, int incr, int reflect) {
        if (incr == n)
        {
            return;
        }

        //mirror effect
        for (int i = 0, j = (reflect*2)-1; i < j; ++i,--j)
            arr[j] = arr[i];

        //add zeroes to the first half
        for (int i = 0; i < reflect; ++i)
            arr[i] = "0"+arr[i];

        //add ones to the second half
        for (int j = reflect; j < reflect*2; ++j)
            arr[j] = "1"+arr[j];

        //call for the next bit
        addGrayCodes(n,incr+1,reflect*2);
    }
}

//more efficient solution
class Solution {
    int num;
    public List<Integer> grayCode(int n) {
        List<Integer> grayCodes = new ArrayList<>();
        recur(n, grayCodes);
        return grayCodes;
    }

    private void recur(int n, List<Integer> grayCodes) {
        if (n == 0) {
            grayCodes.add(num);
        } else {
            recur(n - 1, grayCodes);
            num ^= (1 << (n - 1));
            recur(n - 1, grayCodes);
        }
    }
}

/*https://practice.geeksforgeeks.org/problems/generate-grey-code-sequences/1*/

class Solution
{
    int num, N;
    ArrayList<String> generateCode(int n)
    {
        // Your code here
        ArrayList<String> grayCodes = new ArrayList<String>();
        N = n;
        recur(n, grayCodes);
        return grayCodes;
    }
    private void recur(int n, ArrayList<String> grayCodes) {
        if (n == 0)
        {
            StringBuffer res = new StringBuffer(Integer.toBinaryString(num));
            while (res.length() < N)
            {
                StringBuffer temp = new StringBuffer("0");
                temp.append(res);
                res = temp;
            }
            grayCodes.add(res.toString());
        }
        else {
            recur(n - 1, grayCodes);
            num ^= (1 << (n - 1));
            recur(n - 1, grayCodes);
        }
    }
}
