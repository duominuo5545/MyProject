import org.redisson.Config;
import org.redisson.Redisson;

import java.util.concurrent.locks.Lock;

/**
 * Created by hanwang206326 on 16/1/12.
 */
public class MyRedisson {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setTimeout(3000).setAddress("10.16.2.45:6379");
        Redisson redisson = Redisson.create(config);
        Lock lock = redisson.getLock("testRedisson");
        /*try {
            if (lock.tryLock(3000, 3000, TimeUnit.SECONDS)) {

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        lock.lock();
        try {
            System.out.println("Hello World");
        } finally {
            lock.unlock();
        }
        redisson.shutdown();
    }
}
