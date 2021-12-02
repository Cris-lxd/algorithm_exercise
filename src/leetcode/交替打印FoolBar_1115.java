package leetcode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * leetcode
 * Date： 2021/11/27 12:50 下午
 * User： cris
 * Description：
 **/
public class 交替打印FoolBar_1115 {
    private int n;
    private BlockingQueue<Integer> fooQueue = new LinkedBlockingQueue<Integer>() {{
        add(0);
    }};
    private BlockingQueue<Integer> barQueue = new LinkedBlockingQueue<>();

    public 交替打印FoolBar_1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i = 0 ; i < n ; i ++){

            fooQueue.take();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barQueue.add(0);
        }
    }
    public void bar(Runnable printBar) throws InterruptedException {
        for(int i = 0 ; i < n ; i ++){
            barQueue.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooQueue.add(0);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.print("Foo");
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("Bar");
            }
        };

        交替打印FoolBar_1115 a = new 交替打印FoolBar_1115(3);
        a.foo(runnable);
        a.bar(runnable1);

    }
}
