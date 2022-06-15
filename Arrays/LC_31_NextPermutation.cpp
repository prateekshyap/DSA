/*
https://leetcode.com/problems/next-permutation/
31. Next Permutation

*/

class Solution {
public:
    /*
            5
     3             4
1                           2

          |  5                                            // Break point
     3             4
1                           2

           |  5
     4 ------------3                                  // Swap
1                           2

           |  2                               // Reverse
     4             3
1                           5
    */
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
        cout<<" -- "<<chgNumIndex<<" "<<partNumIndex<<" "<<endl;
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
        // else
        //     partNumIndex++; // last permutation
        
        // for(int i: nums)
        //     cout<<i<<" ";
        
        // cout<<" -- "<<chgNumIndex<<" "<<partNumIndex<<" "<<endl;
        //Now, reverse the array from index index until the end of the array.
        reverse(nums.begin()+partNumIndex+1, nums.end());
        
        
    }//end
    
     void nextPermutation1(vector<int>& nums) {
        
        next_permutation(nums.begin(), nums.end());
    }
};