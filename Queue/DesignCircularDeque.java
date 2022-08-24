/*https://leetcode.com/problems/design-circular-deque/*/

class MyCircularDeque {
    private int[] queue;
	private int capacity;
	private int size;
	private int front;
	private int rear;
    public MyCircularDeque(int k) {
        this.queue = new int[k];
		this.capacity = k;
		this.size = 0;
		this.front = -1;
		this.rear = -1;
    }
    
    public boolean insertFront(int value) {
        if (size == 0)
        {
            front = rear = 0;
            queue[front] = value;
            ++size;
            return true;
        }
        else if (size < capacity)
        {
            int newFront = front-1;
            if (newFront == -1) newFront = capacity-1;
            queue[newFront] = value;
            front = newFront;
            ++size;
            return true;
        }
        else return false;
    }
    
    public boolean insertLast(int value) {
        if (size == 0)
        {
            front = rear = 0;
            queue[rear] = value;
            ++size;
            return true;
        }
        else if (size < capacity)
        {
            int newRear = (rear+1)%capacity;
            queue[newRear] = value;
            rear = newRear;
            ++size;
            return true;
        }
        else return false;
    }
    
    public boolean deleteFront() {
        if (size == 0) return false;
        else if (size == 1)
        {
            size = 0;
            front = rear = -1;
            return true;
        }
        else
        {
            --size;
            front = (front+1)%capacity;
            return true;
        }
    }
    
    public boolean deleteLast() {
        if (size == 0) return false;
        else if (size == 1)
        {
            size = 0;
            front = rear = -1;
            return true;
        }
        else
        {
            --size;
            rear = rear-1;
            if (rear == -1) rear = capacity-1;
            return true;
        }
    }
    
    public int getFront() {
        return front == -1 ? -1 : queue[front];
    }
    
    public int getRear() {
        return rear == -1 ? -1 : queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */