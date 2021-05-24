/* 
 	https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
	Partition Array Into Three Parts With Equal Sum
*/
class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
         int n=arr.size(); 
        int i=0,j=n-1, psl = 0, psr=0;                 //to store prefix sum left, prefix sum right
        int ind1 = -1, ind2 = -1;   //to store indices which have prefix sum divisible by S/3
        int S=0;                     //to store sum of entire array.
        for(auto &x : arr){
            S += x;
        }
        
        if(S % 3 != 0) //can be split in three equal sum sets or not.
            return false;
        int S1 = S/3;
        int cp=0; //count of parts

        do
        {
            psl+=arr[i++];
        }while(i<n && psl!=S1);
        do
        {
            psr+=arr[j--];
        }while(j>=0 && psr!=S1);
        
        if(i==n||j==-1)return false;
        i--;j++; // due to extra increment
        cout<<"i="<<i<<" j ="<<j;
        return (j>i+1)?true:false;
    }
};

