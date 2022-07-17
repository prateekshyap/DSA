/*https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/*/

/*Prateekshya's Solution*/

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totSum = 0, currSum = 0;

        //find the total sum
        for (int i = 0; i < arr.length; ++i)
            totSum += arr[i];
        boolean flag = false;

        //if it is divisible by 3
        if (totSum%3 == 0)
        {
            for (int i = 0; i < arr.length; ++i)
            {
            	//get the sum till current point
                currSum += arr[i];

                //if flag is false
                if (!flag)
                {
                	//if first breakpoint reached, make flag true
                    if (currSum*3 == totSum)
                        flag = true;
                }
                else
                {
                	//if second break point reached, return true
                    if (currSum-(totSum/3) == totSum/3 && i != arr.length-1)
                        return true;
                }
            }
        }

        return false;
    }
}

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0, n = arr.length;
        for (int val : arr) sum += val;
        if (sum%3 != 0) return false;
        int parts = 3, index = 0, target = sum/3;
        sum = 0;
        while (parts > 0)
        {
            if (index >= n) break;
            sum += arr[index++];
            if (sum == target)
            {
                --parts;
                sum = 0;
            }
        }
        return parts == 0;
    }
}

/*Pratik's Solution*/

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) 
    {
        int n = arr.length;
        int sum = 0;
        for(int i=1;i<n;i++)
        {
            arr[i]+=arr[i-1];
        }
        if(arr[n-1]%3!=0)return false;
        int count = 0 , reqSum = arr[n-1]/3;
        for(int i=0;i<n;i++)
        {
            if(arr[i]-(count*reqSum)==reqSum)count++;
            if(count==3)return true;
        }
        return false;
    }
}