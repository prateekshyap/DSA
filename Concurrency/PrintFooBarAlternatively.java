/*https://leetcode.com/problems/print-foobar-alternately/*/

class FooBar {
    private int n;
    
    Semaphore fooBlock, barBlock;

    public FooBar(int n) {
        this.n = n;
        this.fooBlock = new Semaphore(0); //blocking semaphore
        this.barBlock = new Semaphore(0); //blocking semaphore
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooBlock.acquire(); //foo gets locked
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            barBlock.release(); //foo releases bar
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        fooBlock.release(); //only bar can release foo in the beginning
        for (int i = 0; i < n; i++) {
            barBlock.acquire(); //bar gets locked
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            fooBlock.release(); //bar releases foo
        }
    }
}

class FooBar {
    private int n;
    
    Semaphore fooRun, barBlock;

    public FooBar(int n) {
        this.n = n;
        this.fooRun = new Semaphore(1); //binary semaphore
        this.barBlock = new Semaphore(0); //blocking semaphore
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooRun.acquire(); //foo acquires semaphore only if it is available
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            barBlock.release(); //foo releases bar
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barBlock.acquire(); //bar id blocked
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            fooRun.release(); //bar releases foo
        }
    }
}