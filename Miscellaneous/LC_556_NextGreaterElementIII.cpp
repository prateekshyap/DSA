/*
https://leetcode.com/problems/next-greater-element-iii/
556. Next Greater Element III

*/

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        
        if(nums.size()<=1) return;
        
        int n = nums.size();
        
        int partNumIndex = -1; //From right to left, find the first element that is violating the increase trend, this is called PartitionNumber
        int chgNumIndex = -1; //From right to left, find the first element that is larger than PartitionNumber, this is called ChangeNumber.
        
        // Scan the array from right to left until an element is found which is smaller than the index at its right. Mark the index of such element as index.
        for(int j=n-1; j>0; j--)
        {
            if(nums[j-1] < nums[j])
            {    
                partNumIndex = j-1;
                break;
            }
        }
        
        if(partNumIndex!=-1)// there exist partition point
        {
            //Again scan the array from right to left until an element is found which is greater than the element found in the above step. Mark the index of such elements as chgNumIndex.
            for(int j=n-1; j>partNumIndex; j--)
            {
                if(nums[j] > nums[partNumIndex])
                {    
                    chgNumIndex = j;
                    break;
                }
            }
            //Swap the two elements at indices index and chgNumIndex
            swap(nums[partNumIndex], nums[chgNumIndex]);
        }
        
        reverse(nums.begin()+partNumIndex+1, nums.end());
        
        
    }//end
    
    int nextGreaterElement_(int n) 
    {
        
        vector<int> nums(log10(n)+1);
        int i=nums.size()-1;
        int copy = n;
        while(copy)
        {
            nums[i] = (copy%10);
            i--;
            copy/=10;
        }
    
        nextPermutation(nums);
        
        long ans=0;
        for(int x: nums)
        {
            ans = ans*10 + x;
        }
        if(ans > INT_MAX || ans <= n)
            return -1;
        
        return ans;
    }
    
    
    int nextGreaterElement(int n) 
    {
        
        string num = to_string(n);
        int ind=-1, ind2=-1;;
        
        for(int i=num.size()-2; i>=0; i--)
        {
            if(num[i] < num[i+1])
            {
                ind = i;
                break;
            }
        }
        if(ind==-1)
            return -1; // element is already bigger in permutation sequence
    
        for(int j=num.size()-1; j>ind; j--)
        {
            if(num[j]> num[ind])
            {
                ind2=j;
                break;
            }
        }
        swap(num[ind], num[ind2]);
        reverse(num.begin()+ind+1, num.end());
        
        long ans=stol(num);
        if(ans > INT_MAX)
            return -1;
        
        return ans;
    }
};