package cn.com.cootoo.spi;

import java.util.ServiceLoader;

/**
 * @author system
 * @create 2019/4/25
 **/
public class WatchDogMainTest {

    public static void main(String[] args) {

        ServiceLoader<IWatchDogService> loaders = ServiceLoader.load(IWatchDogService.class);

        for (IWatchDogService watchDog : loaders) {
            watchDog.watcher();
        }

    }
}
