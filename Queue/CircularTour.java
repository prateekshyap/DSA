/*https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1*/

class Solution
{
    int tour(int petrol[], int distance[])
    {
        int n = petrol.length;

        //add the first element to the queue
	    int count = 0, front = 0, rear = 0, currPetrol = petrol[0];
	    boolean isATour = false; //indicates whether tour has happened or not

	    //till the candidate starting point is not reached
	    while (currPetrol < distance[rear])
	    {
	    	//skip the current element
	        rear = (rear+1)%n;
	        front = rear;
	        currPetrol = petrol[rear];

	        //increment count and check if it is greater than n then return -1
	        ++count;
	        if (count > n) return -1;
	    }

	    //till front and rear are different
	    while (!(front == rear && isATour))
	    {
	    	//reduce the current petrol
	        currPetrol -= distance[rear];

	        //if it becomes negative
	        if (currPetrol < 0)
	        {
	        	//reset the queue to that point
	            rear = (rear+1)%n;
	            front = rear;
	            currPetrol = petrol[rear];

	            //set indicator to false so that loop doesn't get terminated
	            isATour = false;
	        }
	        else //otherwise
	        {
	        	//set indicator to true
	            isATour = true;

	            //add the next element to queue
	            rear = (rear+1)%n;
	            currPetrol += petrol[rear];
	        }

	        //increment count and check if it is greater than 2n then return -1
	        ++count;
	        if (count > (2*n)) return -1;
	    }

	    //return the meeting point
	    return front;
    }
}