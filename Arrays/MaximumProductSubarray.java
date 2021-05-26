/*https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1*/

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

//efficient solution
class Solution {
    long maxProduct(int[] arr, int n) {
        long maxProduct = 0, currProduct = 1, minProduct = 1;
        for (int i = 0; i < n; ++i)
        {
            //if the current element is positive
            if (arr[i] > 0)
            {
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
        return maxProduct;
    }
}