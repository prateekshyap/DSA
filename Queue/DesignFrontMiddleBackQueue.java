https://leetcode.com/problems/design-front-middle-back-queue/*/

//circular
class FrontMiddleBackQueue {
    private int[] queue;
	private int capacity;
	private int size;
	private int front;
	private int rear;
    public FrontMiddleBackQueue() {
        this.queue = new int[1001];
		this.capacity = 1001;
		this.size = 0;
		this.front = -1;
		this.rear = -1;
    }
    
    public void pushFront(int val) {
        if (size == 0)
        {
            front = rear = 0;
            queue[front] = val;
            ++size;
        }
        else
        {
            int newFront = front-1;
            if (newFront == -1) newFront = capacity-1;
            queue[newFront] = val;
            front = newFront;
            ++size;
        }
    }
    
    public void pushMiddle(int val) {
        if (size == 0)
        {
            front = rear = 0;
            queue[rear] = val;
            ++size;
        }
        else
        {
            int mid = front+(size/2);
            mid %= capacity;
            int i = rear;
            int limit = mid-1;
            if (limit == -1) limit = capacity-1;
            while (i != limit)
            {
                queue[(i+1)%capacity] = queue[i];
                i = (i-1);
                if (i == -1) i = capacity-1;
            }
            ++size;
            rear = (rear+1)%capacity;
            queue[mid] = val;
        }
    }
    
    public void pushBack(int val) {
        if (size == 0)
        {
            front = rear = 0;
            queue[rear] = val;
            ++size;
        }
        else
        {
            int newRear = (rear+1)%capacity;
            queue[newRear] = val;
            rear = newRear;
            ++size;
        }
    }
    
    public int popFront() {
        if (size == 0) return -1;
        else if (size == 1)
        {
            size = 0;
            int val = queue[front];
            front = rear = -1;
            return val;
        }
        else
        {
            --size;
            int val = queue[front];
            front = (front+1)%capacity;
            return val;
        }
    }
    
    public int popMiddle() {
        if (size == 0) return -1;
        else if (size == 1)
        {
            size = 0;
            int val = queue[front];
            front = rear = -1;
            return val;
        }
        else
        {
            int mid = front+((size-1)/2);
            mid %= capacity;
            int val = queue[mid];
            int i = mid;
            while (i != rear)
            {
                queue[i] = queue[(i+1)%capacity];
                i = (i+1)%capacity;
            }
            --size;
            --rear;
            if (rear == -1) rear = capacity-1;
            return val;
        }
    }
    
    public int popBack() {
        if (size == 0) return -1;
        else if (size == 1)
        {
            size = 0;
            int val = queue[rear];
            front = rear = -1;
            return val;
        }
        else
        {
            --size;
            int val = queue[rear];
            rear = rear-1;
            if (rear == -1) rear = capacity-1;
            return val;
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */

//efficient
class FrontMiddleBackQueue {
    private static int MAX_SIZE = 1000;
    private int[] half1, half2;
    private int front, back, mid1, mid2, size;

    public FrontMiddleBackQueue() {
        half1 = new int[MAX_SIZE];
        half2 = new int[MAX_SIZE];
        front = 1;
        back = 0;
        mid1 = 0;
        mid2 = 1;
        size = 0;
    }
    
    public void pushFront(int val) {
        front = circularMoveLeft(front);
        half1[front] = val;
        if (size % 2 == 1) {
            mid2 = circularMoveLeft(mid2);
            half2[mid2] = half1[mid1];
            mid1 = circularMoveLeft(mid1);
        }
        size++;
    }
    
    public void pushMiddle(int val) {
        if (size <= 1) {
            pushFront(val);
            return;
        }
        if (size % 2 == 0) {
            mid1 = circularMoveRight(mid1);
            half1[mid1] = val;
        }
        else {
            int curr = half1[mid1];
            half1[mid1] = val;
            mid2 = circularMoveLeft(mid2);
            half2[mid2] = curr;
        }
        size++;
    }
    
    public void pushBack(int val) {
        if (size == 0) {
            pushFront(val);
            return;
        }
        back = circularMoveRight(back);
        half2[back] = val;
        if (size % 2 == 0) {
            mid1 = circularMoveRight(mid1);
            half1[mid1] = half2[mid2];
            mid2 = circularMoveRight(mid2);
        }
        size++;
    }
    
    public int popFront() {
        if (size == 0) {
            return -1;
        }
        int pop = half1[front];
        front = circularMoveRight(front);
        if (size % 2 == 0) {
            mid1 = circularMoveRight(mid1);
            half1[mid1] = half2[mid2];
            mid2 = circularMoveRight(mid2);
        }
        size--;
        return pop;
    }
    
    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        if (size <= 2) {
            return popFront();
        }
        int pop = half1[mid1];
        if (size % 2 == 0) {
            half1[mid1] = half2[mid2];
            mid2 = circularMoveRight(mid2);
        }
        else {
            mid1 = circularMoveLeft(mid1);
        }
        size--;
        return pop;
    }
    
    public int popBack() {
        if (size == 0) {
            return -1;
        }
        if (size == 1) {
            return popFront();
        }
        int pop = half2[back];
        back = circularMoveLeft(back);
        if (size % 2 == 1) {
            mid2 = circularMoveLeft(mid2);
            half2[mid2] = half1[mid1];
            mid1 = circularMoveLeft(mid1);
        }
        size--;
        return pop;
    }
    
    private int circularMoveRight(int pos) {
        if (pos == MAX_SIZE - 1) {
            pos = -1;
        }
        return pos + 1;
    }
    
    private int circularMoveLeft(int pos) {
        if (pos == 0) {
            pos = MAX_SIZE;
        }
        return pos - 1;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */


//efficient linkedlist implementation
/**
 * We shall implement two lists i.e. front half and rear half or back half
 * whose sizes are denoted by fSize and bSize respectively
 * 
 * We'll make sure that after each push or pop operation
 * 		Either fSize == bSize
 * 		Or fSize == bSize-1
 * By maintaining this, we can make the pushMiddle and popMiddle efficient
 * For fSize == bSize, pushMiddle will push it in the back half and popMiddle will pop from the front half
 * For fSize == bSize-1, pushMiddle will push it in the front half and popMiddle will pop from the back half
 * To maintain this, we shall always push the first element in the back half irrespective of its requirement
 * So if bSize is 0, we are pushing the first element
 * if fSize is 0, we are pushing the second element
 * 
 * front and back denote the two ends of our queue
 * frontEnd and backEnd denote the joining point i.e. if we have to make a single list, we have to join these two points
 * 
 * e.g->
 * 5 6 8 9 2 3 4
 * Here 5 is front, 8 is frontEnd, 9 is backEnd and 4 is back
 * 
 * 5 6 8 9 2 3 4 6
 * Here 5 is front, 9 is frontEnd, 2 is backEnd and 6 is back
 * */
class Node
{
    Node front;
    int val;
    Node back;
    Node(int v)
    {
        val = v;
    }
}
class FrontMiddleBackQueue {
    Node front, frontEnd, back, backEnd;
    int fSize, bSize;
    public FrontMiddleBackQueue() {
        front = frontEnd = back = backEnd = null;
        fSize = bSize = 0;
    }
    
    public void pushFront(int val) {
        if (bSize == 0) //if first element, push in back half
        {
            back = new Node(val);
            backEnd = back;
            ++bSize;
        }
        else if (fSize == 0) //if second element, push in front half
        {
            front = new Node(val);
            frontEnd = front;
            ++fSize;
        }
        else //in all other cases, push in front
        {
            Node newNode = new Node(val);
            front.front = newNode;
            newNode.back = front;
            front = newNode;
            ++fSize;
            if (fSize > bSize) //if fSize exceeds bSize, move one node from the front half to the back half
                moveFrontEndToBackEnd();
        }
    }
    
    public void pushMiddle(int val) {
        if (bSize == 0) //if first element, push in back half
        {
            back = new Node(val);
            backEnd = back;
            ++bSize;
        }
        else //otherwise
        {
            Node newNode = new Node(val);
            if (fSize == bSize) //if sizes are same, push in back half
            {
                newNode.back = backEnd;
                backEnd.front = newNode;
                backEnd = newNode;
                ++bSize;
            }
            else //otherwise (fSize is guaranteed to be smaller) push in front half
            {
                if (fSize == 0)
                {
                    front = frontEnd = newNode;
                }
                else
                {
                    newNode.front = frontEnd;
                    frontEnd.back = newNode;
                    frontEnd = frontEnd.back;
                }
                ++fSize;
            }
        }
    }
    
    public void pushBack(int val) {
        if (bSize == 0)
        {
            back = new Node(val);
            backEnd = back;
            ++bSize;
        }
        else
        {
            Node newNode = new Node(val);
            back.back = newNode;
            newNode.front = back;
            back = newNode;
            ++bSize;
            if (bSize == fSize+2) //if the gap exceeds 1, move one node from back half to front half
                moveBackEndToFrontEnd();
        }
    }
    
    public int popFront() {
        int val = 0;
        if (bSize == 0) //if no elements
        {
            val = -1;
        }
        else if (fSize == 0) //if only one element is remaining (guaranteed to be in the back half)
        {
            val = back.val;
            back = backEnd = null;
            bSize = 0;
        }
        else //in all other cases, remove from front
        {
            val = front.val;
            front = front.back;
            if (front == null) frontEnd = null;
            else front.front = null;
            --fSize;
            if (bSize == fSize+2) //if the difference exceeds 1, move one node from back half to front half
                moveBackEndToFrontEnd();
        }
        return val;
    }
    
    public int popMiddle() {
        int val = 0;
        if (bSize == 0) //if no elements
        {
            val = -1;
        }
        else if (fSize == 0) //if only one element is remaining (guaranteed to be in the back half)
        {
            val = back.val;
            back = backEnd = null;
            bSize = 0;
        }
        else //in all other cases
        {
            val = 0;
            if (fSize == bSize) //if sizes are same, pop from front half
            {
                val = frontEnd.val;
                frontEnd = frontEnd.front;
                if (frontEnd == null) front = null;
                else frontEnd.back = null;
                --fSize;
            }
            else //otherwise (fSize is guaranteed to be smaller) pop from back half
            {
                val = backEnd.val;
                backEnd = backEnd.back;
                if (backEnd == null) back = null;
                else backEnd.front = null;
                --bSize;
            }
        }
        return val;
    }
    
    public int popBack() {
        int val = 0;
        if (fSize == 0 && bSize == 0) //if no elements
        {
            val = -1;
        }
        else if (fSize == 0) //if only one element is remaining
        {
            val = back.val;
            back = backEnd = null;
            bSize = 0;
        }
        else //in all other cases, remove from back
        {
            val = back.val;
            back = back.front;
            if (back == null) backEnd = null;
            else back.back = null;
            --bSize;
            if (bSize < fSize) //if bSize decreases
                moveFrontEndToBackEnd(); //move one node from front half to back half
        }
        return val;
    }
    
    private void moveBackEndToFrontEnd()
    {
        if (fSize == 0) //if front half has no elements (back half is guaranteed to have only one element)
        {
            front = frontEnd = backEnd;
            backEnd = backEnd.back;
        }
        else //otherwise
        {
            frontEnd.back = backEnd;
            backEnd = backEnd.back;
            frontEnd.back.front = frontEnd;
            frontEnd = frontEnd.back;
        }
        frontEnd.back = backEnd.front = null;
        ++fSize;
        --bSize;
    }
    
    private void moveFrontEndToBackEnd()
    {
        if (bSize == 0) //if back half has no elements (front half is guaranteed to have 2 elements)
        {
            back = backEnd = front;
            front = frontEnd = null;
            backEnd.front = backEnd.back = null;
        }
        else //otherwise
        {
            backEnd.front = frontEnd;
            frontEnd = frontEnd.front;
            backEnd.front.back = backEnd;
            backEnd = backEnd.front;
            backEnd.front = frontEnd.back = null;
        }
        --fSize;
        ++bSize;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 