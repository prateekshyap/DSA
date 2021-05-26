/*https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1*/

//chindi and smart solution
class Solution {
    long maxProduct(int[] arr, int n) {
        long maxProduct = 0, currProduct = 1, prevProduct = 0;
        for (int i = 0; i < n; ++i)
        {
        	//get the product till current point
            currProduct *= arr[i];

            //if it is less than zero
            if (currProduct < 0)
            {
            	//if the product till the past break point is also less than zero
                if (prevProduct < 0)
                {
                	//mulitply both
                    currProduct *= prevProduct;
                    //set previous product to zero
                    prevProduct = 0;
                }
                else
                {
                	//set the current product as previous product, we got a break point
                    prevProduct = currProduct;
                    //reset current product
                    currProduct = 1;
                }
            }
            //if current produyct becomes zero, reset both
            else if (currProduct == 0)
            {
                currProduct = 1;
                prevProduct = 0;
            }
            if (currProduct > maxProduct)
                maxProduct = currProduct;
        }
        //do the same in reverse direction
        currProduct = 1; prevProduct = 0;
        for (int i = n-1; i >= 0; --i)
        {
            currProduct *= arr[i];
            if (currProduct < 0)
            {
                if (prevProduct < 0)
                {
                    currProduct *= prevProduct;
                    prevProduct = 0;
                }
                else
                {
                    prevProduct = currProduct;
                    currProduct = 1;
                }
            }
            else if (currProduct == 0)
            {
                currProduct = 1;
                prevProduct = 0;
            }
            if (currProduct > maxProduct)
                maxProduct = currProduct;
        }
        return maxProduct;
    }
}

//another chindi and smart solution
class Solution {
    long maxProduct(int[] arr, int n) {
        long maxProduct = Long.MIN_VALUE, currProduct = 1;
        for (int i = 0; i < n; ++i)
        {
            currProduct *= arr[i];
            if (currProduct > maxProduct)
                maxProduct = currProduct;
            if (currProduct == 0)
                currProduct = 1;
        }
        currProduct = 1;
        for (int i = n-1; i >= 0; --i)
        {
            currProduct *= arr[i];
            if (currProduct > maxProduct)
                maxProduct = currProduct;
            if (currProduct == 0)
                currProduct = 1;
        }
        return maxProduct;
    }
}

//standard solution
class Solution {
    long maxProduct(int[] arr, int n) {
        if (arr.length == 1) return arr[0];
        long maxProduct = Long.MIN_VALUE, currProduct = 1, minProduct = 1;
        //flag indicates existence of positive elements
        //edge indicates existence of only -1 and 0
        boolean flag = false, edge = true;
        for (int i = 0; i < n; ++i)
        {
            //if the current element is positive
            if (arr[i] > 0)
            {
                edge = false;
                flag = true;
                //mulitply directly to the maximum product till this point
                currProduct *= arr[i];
                //update minimum product till this point
                minProduct = Math.min(1,minProduct*arr[i]);
            }
            //if it is zero
            else if (arr[i] == 0)
            {
                //reset everything
                currProduct = 1;
                minProduct = 1;
            }
            //if it is negative
            else
            {
                if (arr[i] != -1) edge = false;
                //hold the maximum product till this point
                long temp = currProduct;
                //update maximum product till this point if the minimum product is still negative
                currProduct = Math.max(minProduct*arr[i],1);
                //update minimum product till this point
                minProduct = temp*arr[i];
            }
            //update the maximum product
            maxProduct = Math.max(maxProduct,currProduct);
        }
        //if no positive elements exist and maximum product is 1
        if (!flag && maxProduct == 1)
        {
        	//if only 0 and -1 exist, return 1
            if (edge) return 1;
            //else return 0
            else return 0;
        }
        return maxProduct;
    }
}