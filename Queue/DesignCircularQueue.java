/*https://leetcode.com/problems/design-circular-queue/*/

class MyCircularQueue {
    private int[] queue;
	private int capacity;
	private int size;
	private int front;
	private int rear;
    public MyCircularQueue(int k) {
        this.queue = new int[k];
		this.capacity = k;
		this.size = 0;
		this.front = -1;
		this.rear = -1;
    }
    
    public boolean enQueue(int value) {
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
    
    public boolean deQueue() {
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
    
    public int Front() {
        return front == -1 ? -1 : queue[front];
    }
    
    public int Rear() {
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
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */