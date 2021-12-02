package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * leetcode
 * Date： 2021/11/27 1:47 下午
 * User： cris
 * Description：
 **/
public class 按序打印_1114 {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public 按序打印_1114() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
        }
        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
        }
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        };
        按序打印_1114 a = new 按序打印_1114();
        a.first(runnable);
        a.second(runnable1);
        a.third(runnable2);

    }
}

