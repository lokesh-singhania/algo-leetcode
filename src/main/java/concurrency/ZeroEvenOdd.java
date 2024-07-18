package concurrency;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private volatile int n;
    Semaphore zero,odd,even;
    AtomicInteger num;

    public ZeroEvenOdd(int n) {
        this.n = n;
        num = new AtomicInteger(1);
        zero = new Semaphore(1);
        odd = new Semaphore(0);
        even = new Semaphore(0);
    }

    public static void main(String[] args) {
        var instance = new ZeroEvenOdd(10);
        IntConsumer print = (int n)->System.out.print(n);
        new Thread(()-> {
            try {
                instance.zero(print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                instance.odd(print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                instance.even(print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(num.get()<n){
            zero.acquire();
            printNumber.accept(0);
            var toRelease = (num.get()%2 == 1 ? odd : even);
            toRelease.release();
        }
        zero.release();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int evenLast = n%2==0 ? n : n-1;
        while(num.get()<=evenLast){
            even.acquire();
            printNumber.accept(num.getAndIncrement());
            zero.release();
        }
        even.release();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int oddLast = n%2 == 1?n:n-1;
        while(num.get()<=oddLast){
            odd.acquire();
            printNumber.accept(num.getAndIncrement());
            zero.release();
        }
        odd.release();
    }
}