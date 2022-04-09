/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
215. Kth Largest Element in an Array

*/
class Solution {
public:
    class minHeap 
    {
       vector<int> arr;
        public:
        
            minHeap(vector<int>& v, int size)
            {
                arr = v;
                // build heap
                for(int i=(size/2)-1; i>=0; i--)
                    heapify_down(i);
            }
            int parent(int i){ return (i-1)/2; }
            int left (int i) { return (2*i +1);}
            int right(int i){ return (2*i + 2);}
            
            int getMinRoot(){ return arr.at(0);}
            
            void heapify_down(int root)
            {
                int l = left(root);
                int r = right(root);
                int smallest = root;
                if(l<arr.size() && arr[l] < arr[smallest])
                    smallest = l;
                if(r<arr.size() && arr[r] < arr[smallest])
                    smallest = r;
                if(smallest !=root)
                {
                    swap(arr[root], arr[smallest]);
                    heapify_down(smallest);
                }
            }
        
            int extractMin()
            {
                if(arr.size() ==0)return -1;
                
                int top = arr[0];
                if(arr.size()>1)
                {
                    arr[0] = arr[arr.size()-1];
                    heapify_down(0);
                }
                arr.resize(arr.size()-1);
                return top;
            }
            
    };
    int findKthLargest(vector<int>& nums, int k) {
        // Using self minHeap
        minHeap mh(nums,nums.size());
        
        for(int i=0; i<nums.size()-k; i++)
        {
            mh.extractMin();
        }
        
        return mh.getMinRoot();
    }
        
        /*
        // Using Sorting
        sort(nums.begin(), nums.end());
        return nums[nums.size()-k];
        */
        
        /*
        // Using MIN Heap for largest
        // Push First K elements into the heap 
        priority_queue<int, vector<int>, greater<int>> pq(nums.begin(), nums.begin()+k);
        // for the rest of the elements insert only if it is bigger.
        for(int i=k; i<nums.size(); i++)
        {
            if(pq.top() < nums[i])
            {
                pq.pop();
                pq.push(nums[i]);
            }
        }
     return pq.top();  
        */
        
        /*
        // Using QuickSort/ Select
        int n = nums.size();
        int l=0, r=nums.size()-1;
        k = n-k; // largest to smallest element 6-2=4(0-1-2-3-4-5)
        while(l<r)
        {
            int pos = partition(nums,l,r);
            if(pos==k) break; // if position is same as kth element
            if(pos < k) l=pos+1; // go to left side towards kth element
            else r = pos-1;
        }
        return nums[k];
        
    }
    
    int partition(vector<int>& nums, int low, int high)
    {
        int X = nums[low]; //first element as pivot;
        int j = low; // pivot index
        for(int i=low+1; i<=high; i++)
        {
            if(nums[i]<X)
            {
                j++;
                swap(nums[i], nums[j]);
            }
        }
        swap(nums[j], nums[low]);
        return j;
    }
    */
};