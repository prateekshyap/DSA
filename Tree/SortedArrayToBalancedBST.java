/*https://practice.geeksforgeeks.org/problems/array-to-bst4443/1*/

//GFG version without creating a tree and using iterative preorder travresal technique
class Data
{
    int start;
    int mid;
    int end;
    Data(int s, int e)
    {
        start = s;
        end = e;
        mid = (s+e)/2;
    }
}

class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        int[] result = new int[nums.length];
        int index = 0;

        //create a stack and push the range of the array
        Stack<Data> stack = new Stack<Data>();
        stack.push(new Data(0,nums.length-1));

        //till the stack becomes empty
        while (!stack.isEmpty())
        {
        	//pop the current data from stack
            Data curr = stack.pop();

            //store the corresponding element in the result
            result[index++] = nums[curr.mid];
            
            //if the right subtree has more than one nodes then push the right subtree range
            if (curr.mid != curr.end) stack.push(new Data(curr.mid+1,curr.end));
            //if the left subtree has more than one nodes then push the left subtree range
            if (curr.start != curr.mid) stack.push(new Data(curr.start,curr.mid-1));
        }

        return result;
    }
}

//Leetcode version