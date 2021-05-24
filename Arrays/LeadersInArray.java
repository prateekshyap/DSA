/*https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1*/

class Solution{
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(arr[n-1]); //add last element 
        int max = arr[n-1]; //last element is always a leader
        for (int i = n-2; i >= 0; --i)
        {
            //if found a new leader, add it to list and update max
            if (arr[i] >= max)
            {
                max = arr[i];
                list.add(arr[i]);
            }
        }
        Collections.reverse(list); //reverse to get the elements in the order of their appearance 
        return list;
    }
}