/*https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1*/


/*Here a celebrity will have 1 in the entire column
except its own position
and 0 in the entire row*/
 
class Solution
{
    int celebrity(int M[][], int n)
    {
    	for (int i = 0; i < n; ++i) //for each row
        {
        	//check if the row is completely 0 or not
            boolean isCeleb = true;
            for (int j = 0; j < n; ++j)
            {
                if (M[i][j] == 1)
                {
                    isCeleb = false;
                    break;
                }
            }

            /*if the row is 0, i is a potential candidate to be a celebrity*/

            if (isCeleb == true)
            {
                boolean retCeleb = true;

                //for each row 
                for (int k = 0; k < n; ++k)
                {
                	//if ith column at kth row is 0 i.e. if k doesn't know i, then i is not a celebrity
                    if (k != i && M[k][i] != 1)
                        retCeleb = false;                
                }

                //if the loop is uninterrupted, i is a celebrity
                if (retCeleb == true)  
                    return i;
            }
        }
        return -1;
    }
}

//efficient solution using stack

class Solution
{
    int celebrity(int M[][], int n)
    {
        //push all the ids into the stack
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i)
            stack.push(i);

        //pop till there is one id left
        while (stack.size() > 1)
        {
            //pop tow ids
            int a = stack.pop();
            int b = stack.pop();

            //if a knows b, a cannot be a celebrity, so push b
            if (M[a][b] == 1)
                stack.push(b);

            //if a doesn't know b, b cannot be a celebrity, so push a
            else
                stack.push(a);
        }

        //the remaining id is the potential candidate
        int candidate = stack.pop();

        //if the candidate knows someone, return -1
        for (int i = 0; i < n; ++i)
            if (M[candidate][i] == 1)
                return -1;

        //if there is someone who doesn't know the candidate, return -1
        for (int i = 0; i < n; ++i)
            if (i != candidate && M[i][candidate] == 0)
                return -1;

        //if both loops are uninterrupted, return the candidate
        return candidate;
    }
}
