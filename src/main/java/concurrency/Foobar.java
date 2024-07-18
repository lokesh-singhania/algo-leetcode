package concurrency;

import java.util.concurrent.CountDownLatch;

class FooBar {
    private final int n;
    CountDownLatch[] barriers;

    public FooBar(int n) {
        this.n = n;
        barriers = new CountDownLatch[]{new CountDownLatch(1),new CountDownLatch(1)};
    }

    public static void main(String[] args) throws InterruptedException {
        var fb = new FooBar(2);
        fb.foo(()->{System.out.print("foo");});
        fb.bar(()->System.out.print("bar"));
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if(i>0){
                barriers[0].await();
            }
            printFoo.run();
            if(i>0){
                barriers[0]=new CountDownLatch(1);
            }
            barriers[1].countDown();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barriers[1].await();
            printBar.run();
            barriers[1]=new CountDownLatch(1);
            barriers[0].countDown();
        }
    }
}