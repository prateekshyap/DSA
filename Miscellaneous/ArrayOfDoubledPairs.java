/*https://leetcode.com/problems/array-of-doubled-pairs/*/

class Solution
{
    public boolean canReorderDoubled(int[] arr)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        //put all the elements to hashmap along with their counts
        for (int i = 0; i < arr.length; ++i)
            map.put(arr[i],(map.containsKey(arr[i]) ? (Integer)map.get(arr[i])+1 : 1));

        //sort the array
        Arrays.sort(arr);
        boolean result = true;

        //start from 0th index
        int i = 0;

        //store the total number of elements in count
        int count = arr.length;

        //till count is not exhausted
        while (count > 0)
        {
        	//if the ith element has more counts left
            if ((Integer)map.get(arr[i]) > 0)
            {
            	//decrease count by 1 and decrease the element count in hashmap
                --count;
                map.put(arr[i],(Integer)map.get(arr[i])-1);
                
                //if the element is positive and its multiple is also present
                if (arr[i] >= 0 && map.containsKey(arr[i]*2) && (Integer)map.get(arr[i]*2) > 0)
                {
                	//decrease count by 1 and decrease the element count in hashmap
                    map.put(arr[i]*2,(Integer)map.get(arr[i]*2)-1);
                    --count;
                }
                //if the element is negative and even and its half is also present
                else if (arr[i] < 0 && arr[i]%2 == 0 && map.containsKey(arr[i]/2) && (Integer)map.get(arr[i]/2) > 0)
                {
                	//decrease count by 1 and decrease the element count in hashmap
                    map.put(arr[i]/2,(Integer)map.get(arr[i]/2)-1);
                    --count;
                }
                //otherwise return false
                else
                {
                    return false;
                }
            }

            //increment i
            ++i;
        }

        //return true
        return result;
    }
}

//efficient solution
class Solution {
    public boolean canReorderDoubled(int[] arr) {
    	//return true for edge case
        if(arr==null || arr.length==0)return true;

        //find the maximum element
       	int max=Integer.MIN_VALUE;
        for(int i:arr)max=Math.max(max,Math.abs(i));
        
        //create two hashtables positive and negative
        int[] pos=new int[max+1];
        int[] neg=new int[max+1];

        //store the elements respectively
        for(int i:arr){
            if(i>=0){
                pos[i]++;
            }else{
                neg[Math.abs(i)]++;
            }
        }
        
        //for each element
        for(int i=0;i<=max;i++){
        	//if it is positive
            if(pos[i]>0){
            	//if its multiple is not present within the range then return false
                if(2*i>=pos.length || pos[2*i]<pos[i])return false;
                //reduce the count
                pos[2*i]-=pos[i];
            }
            //if it is negative
            if(neg[i]>0){
            	//if its multiple is not present within the range then return false
                if(2*i>=pos.length || neg[2*i]<neg[i])return false;
                //reduce the count
                neg[2*i]-=neg[i];
            }
        }
        //return true at the end
        return true;
    }
}