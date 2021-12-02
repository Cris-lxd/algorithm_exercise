package 设计模式;

/**
 * 设计模式
 * Date： 2021/11/29 11:21 上午
 * User： cris
 * Description：
 **/
public class 单例模式 {

    private volatile static 单例模式 instance;          //volatile避免了指令重拍
    //不能直接实例化
    private 单例模式() {
    }

    public static 单例模式 getInstance(){
        /**
         * 当有两个线程及以上，若直接对方法加锁，则性能降低
         * 两个线程，若若不加锁，一个线程判断后再次暂停，第二个线程先进去实例话过程中，第一个线程判断实例依旧为空也去实例话，则不能保证单例
         */
        if(instance == null){
            synchronized (单例模式.class){
                if(instance == null){
                    instance = new 单例模式();
                }
            }
        }
        return instance;
    }
}


