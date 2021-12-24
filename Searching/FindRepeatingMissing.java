/*https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1*/

//noob hashtable solution
cases = int(input())
for i in range(cases):
    dim = int(input())
    hashTable = [0]*(dim+1)
    arr = [int(i) for i in input().split()]
    for i in range(dim):
        hashTable[arr[i]] += 1
    rep,miss = -1,-1
    for i in range(1,dim+1):
        if (rep == -1 and hashTable[i] > 1):
            rep = i
        if (miss == -1 and hashTable[i] == 0):
            miss = i
    print(rep,miss)

//bit magic solution
class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] result = new int[2];
        result[0] = result[1] = -1;

        //find the repeating element using negation logic
        for (int i = 0; i < n; ++i)
        {
            if (arr[Math.abs(arr[i])-1] < 0)
            {
                result[0] = Math.abs(arr[i]);
                break;
            }
            arr[Math.abs(arr[i])-1] *= -1;
        }
        
        //xor all elements from 1 to n once
        int xor = 0;
        for (int i = 1; i <= n; ++i)
            xor ^= i;

        //xor the repeating element
        xor ^= result[0];

        //xor the array elements
        for (int i = 0; i < n; ++i)
            xor ^= Math.abs(arr[i]);

        //remaining number is the missing number
        result[1] = xor;
        
        return result;
    }
}

/*Proest Pratik's Solution*/

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] res = new int[2];
        for(int i=0;i<n;i++)
        {
            if(arr[Math.abs(arr[i])-1]<0)
            {
                res[0] = Math.abs(arr[i]);
                continue;
            }
            arr[Math.abs(arr[i])-1] *= (-1);
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0)res[1] = i+1;
        }
        return res;
    }
}