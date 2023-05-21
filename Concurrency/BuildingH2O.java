/*https://leetcode.com/problems/building-h2o/*/

class H2O {
    Semaphore hydrogenSem, oxygenSem;
    public H2O() {
        hydrogenSem = new Semaphore(2);
        oxygenSem = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hydrogenSem.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxygenSem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSem.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        hydrogenSem.release(2);
    }
}