/*https://leetcode.com/problems/print-in-order/*/

class Foo {
    Semaphore two, three;
    public Foo() {
        two = new Semaphore(0); //blocking semaphore
        three = new Semaphore(0); //blocking semaphore
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        //release the second one
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        //acquire the second one
        two.acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        //release the third one
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        //acquire the third one
        three.acquire();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}