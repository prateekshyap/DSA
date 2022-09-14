/*https://leetcode.com/problems/recover-the-original-array/*/

class Solution {
    public int[] recoverArray(int[] nums) {
        int n = nums.length, reqLen = n/2;
        int[] result = new int[reqLen];
        boolean[] visited = new boolean[n];
        Map<Integer,int[]> map = new HashMap<Integer,int[]>();
        Arrays.sort(nums);
        map.put(nums[0],new int[]{0,1});
        for (int i = 1; i < n; ++i)
            if (nums[i] != nums[i-1])
            {
                map.get(nums[i-1])[1] = i;
                map.put(nums[i],new int[]{i,i+1});
            }
        map.get(nums[n-1])[1] = n;
        for (int i = 1; i <= n; ++i) //for each next element
        {
            int diff = nums[i]-nums[0], k = diff/2, index = 0; //get the difference and k
            if (diff == 0 || diff%2 != 0) //if difference is not feasible then continue
                continue;
            Arrays.fill(visited,false); //reset visited array
            for (int j = 0, itr; j < n; ++j) //for each element
            {
                if (visited[j]) continue; //if visited, continue
                if (!map.containsKey(nums[j]+diff)) //if the counter-part is not present, continue
                    continue;
                int[] pos = map.get(nums[j]+diff); //get the range
                for (itr = pos[0]; itr < pos[1] && visited[itr]; ++itr); //move till you get an unvisited value of the same element
                if (itr == pos[1]) break; //if the range is crossed, break
                visited[j] = visited[itr] = true; //mark both j and itr as true
                result[index++] = nums[j]+k; //store the required number in the result
            }
            if (index == reqLen) break; //if all elements are stored, break
        }
        return result; //we got our result
    }
}